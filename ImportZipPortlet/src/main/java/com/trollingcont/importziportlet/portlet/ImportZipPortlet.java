package com.trollingcont.importziportlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.trollingcont.importziportlet.constants.ImportZipPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import com.trollingcont.servicebuilder.model.*;
import com.trollingcont.servicebuilder.service.*;
import com.trollingcont.servicebuilder.service.persistence.EmployeePersistence;
import org.osgi.service.component.annotations.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ImportZip",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ImportZipPortletKeys.IMPORTZIP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ImportZipPortlet extends MVCPortlet {

	static final String[] entryNames = {
			"Posts.csv",
			"ProductTypes.csv",
			"PurchaseTypes.csv",
			"Employees.csv",
			"Products.csv",
			"Purchases.csv"
	};

	static final String csvDateFormatPattern = "yyyy-MM-dd";
	static final String csvTimeFormatPattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";

	private final SimpleDateFormat csvDateFormat = new SimpleDateFormat(csvDateFormatPattern);
	private final SimpleDateFormat csvTimeFormat = new SimpleDateFormat(csvTimeFormatPattern);

	public void importZip(ActionRequest request, ActionResponse response) {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);

		try {
			File file = uploadPortletRequest.getFile("zipFile", true);

			if (file == null) {
				throw new IllegalStateException("fileNotSelected");
			}

			readZip(new ZipFile(file), request);
		}
		catch (IllegalStateException ise) {
			SessionErrors.add(request, ise.getMessage());
		}
		catch (IOException ioe) {
			SessionErrors.add(request, "failedToProcessZip");
		}
	}

	private void readZip(ZipFile file, ActionRequest request) {

		for (String entryName : entryNames) {
			try {
				ZipEntry entry = file.getEntry(entryName);

				if (entry != null) {

					try {
						List<List<String>> csvList = generateCsvList(
								new BufferedReader(
									new InputStreamReader(file.getInputStream(entry))
								)
						);

						writeCsvList(csvList, entryName, request);
					}
					catch (Exception e) {
						System.out.printf("An error occurred while processing entry '%s', skipping\n", entryName);
					}
				}
				else {
					System.out.printf("Entry '%s' not found, skipping\n", entryName);
				}
			}
			catch (IllegalStateException ise) {
				System.out.println("Failed to read ZIP archive");
			}
		}
	}

	private List<List<String>> generateCsvList(BufferedReader reader)
			throws IOException {

		List<List<String>> csvValuesList = new ArrayList<>();

		String line;
		while ((line = reader.readLine()) != null) {
			String[] values = line.split(",");

			csvValuesList.add(Arrays.asList(values));
		}

		return csvValuesList;
	}

	private void writeCsvList(
			List<List<String>> csvList,
			String entryName,
			ActionRequest request
	) {
		try {
			switch (entryName) {
				case "Posts.csv":
					writePosts(csvList, request);
					break;
				case "ProductTypes.csv":
					writeProductTypes(csvList, request);
					break;
				case "PurchaseTypes.csv":
					writePurchaseTypes(csvList, request);
					break;
				case "Employees.csv":
					writeEmployees(csvList, request);
					break;
				case "Products.csv":
					writeProducts(csvList, request);
					break;
				case "Purchases.csv":
					writePurchases(csvList, request);
			}
		}
		catch (PortalException pe) {
			System.out.printf("Failed to write CSV list of ZIP entry '%s', skipping this entry\n", entryName);
		}
	}

	private void writePosts(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Post.class.getName(), request
		);

		final int NAME_INDEX = 0;

		for (List<String> entry : csvList) {
			try {
				PostLocalServiceUtil.addPost(entry.get(NAME_INDEX), serviceContext);
			}
			catch (Exception e) {
				System.out.println("Failed to add Post entry, skipping this entry");
			}
		}

	}

	private void writeEmployees(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Employee.class.getName(), request
		);

		final int ID_INDEX = 0;
		final int LAST_NAME_INDEX = 1;
		final int FIRST_NAME_INDEX = 2;
		final int MIDDLE_NAME_INDEX = 3;
		final int BIRTH_DATE_INDEX = 4;
		final int POST_ID_INDEX = 5;
		final int SEX_INDEX = 6;

		for (List<String> entry : csvList) {
			try {
				long employeeId = Long.parseUnsignedLong(entry.get(ID_INDEX));

				Employee employee;

				try {
					employee = EmployeeLocalServiceUtil.getEmployee(employeeId);
				}
				catch (PortalException pe) {
					employee = EmployeeLocalServiceUtil.createEmployee(employeeId);
				}

				employee.setLastName(entry.get(LAST_NAME_INDEX));
				employee.setFirstName(entry.get(FIRST_NAME_INDEX));
				employee.setMiddleName(entry.get(MIDDLE_NAME_INDEX));
				employee.setBirthDate(csvDateFormat.parse(entry.get(BIRTH_DATE_INDEX)));
				employee.setPostId(Long.parseUnsignedLong(entry.get(POST_ID_INDEX)));
				employee.setSex(Boolean.parseBoolean(entry.get(SEX_INDEX)));

				EmployeeLocalServiceUtil.updateEmployee(employee);
			}
			catch (Exception e) {
				System.out.println("Failed to add Employee entry, skipping this entry");
			}
		}
	}

	private void writeProducts(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Product.class.getName(), request
		);

		final int NAME_INDEX = 0;
		final int PRODUCT_TYPE_ID_INDEX = 1;
		final int COST_INDEX = 2;
		final int AMOUNT_INDEX = 3;
		final int PRESENT_INDEX = 4;
		final int ARCHIVED_INDEX = 5;
		final int DESCRIPTION_INDEX = 6;

		for (List<String> entry : csvList) {
			try {
				ProductLocalServiceUtil.addProduct(
						entry.get(NAME_INDEX),
						Long.parseUnsignedLong(entry.get(PRODUCT_TYPE_ID_INDEX)),
						Long.parseUnsignedLong(entry.get(COST_INDEX)),
						Long.parseUnsignedLong(entry.get(AMOUNT_INDEX)),
						Boolean.parseBoolean(entry.get(PRESENT_INDEX)),
						Boolean.parseBoolean(entry.get(ARCHIVED_INDEX)),
						entry.get(DESCRIPTION_INDEX),
						serviceContext
				);
			}
			catch (Exception e) {
				System.out.println("Failed to add Product entry, skipping");
			}
		}
	}

	private void writeProductTypes(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ProductType.class.getName(), request
		);

		final int NAME_INDEX = 0;

		for (List<String> entry : csvList) {
			try {
				ProductTypeLocalServiceUtil.addProductType(
						entry.get(NAME_INDEX),
						serviceContext
				);
			}
			catch (Exception e) {
				System.out.println("Failed to add Product Type entry, skipping this entry");
			}
		}
	}

	private void writePurchases(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Purchase.class.getName(), request
		);

		final int PRODUCT_ID_INDEX = 0;
		final int EMPLOYEE_ID_INDEX = 1;
		final int TIME_TAKEN_INDEX = 2;
		final int PURCHASE_TYPE_ID_INDEX = 3;

		for (List<String> entry : csvList) {
			try {
				PurchaseLocalServiceUtil.addPurchase(
						Long.parseUnsignedLong(entry.get(PRODUCT_ID_INDEX)),
						Long.parseUnsignedLong(entry.get(EMPLOYEE_ID_INDEX)),
						Long.parseUnsignedLong(entry.get(PURCHASE_TYPE_ID_INDEX)),
						csvTimeFormat.parse(entry.get(TIME_TAKEN_INDEX)),
						serviceContext
				);
			}
			catch (Exception e) {
				System.out.println("Failed to add Purchase entry, skipping this entry");
			}
		}
	}

	private void writePurchaseTypes(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				PurchaseType.class.getName(), request
		);

		final int NAME_INDEX = 0;

		for (List<String> entry : csvList) {
			try {
				PurchaseTypeLocalServiceUtil.addPurchaseType(
						entry.get(NAME_INDEX),
						serviceContext
				);
			}
			catch (Exception e) {
				System.out.println("Failed to add Purchase Type entry, skipping this entry");
			}
		}
	}
}