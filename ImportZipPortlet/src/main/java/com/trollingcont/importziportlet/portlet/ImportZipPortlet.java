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
import org.osgi.service.component.annotations.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

	final EntryDescriptor[] entryDescriptors = {
			new EntryDescriptor(
					this::writePosts, "Posts.csv", "Posts"
			),
			new EntryDescriptor(
					this::writeProductTypes, "ProductTypes.csv", "Product types"
			),
			new EntryDescriptor(
					this::writePurchaseTypes, "PurchaseTypes.csv", "Purchase types"
			),
			new EntryDescriptor(
					this::writeEmployees, "Employees.csv", "Employees"
			),
			new EntryDescriptor(
					this::writeProducts, "Products.csv", "Products"
			),
			new EntryDescriptor(
					this::writePurchases, "Purchases.csv", "Purchases"
			)
	};

	static final String csvDateFormatPattern = "yyyy-MM-dd";
	static final String csvTimeFormatPattern = "yyyy-MM-dd'T'HH:mm:ss";

	private final SimpleDateFormat csvDateFormat = new SimpleDateFormat(csvDateFormatPattern);
	private final SimpleDateFormat csvTimeFormat = new SimpleDateFormat(csvTimeFormatPattern);

	private Date maxValidDate;

	public void importZip(ActionRequest request, ActionResponse response) {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);

		try {
			File file = uploadPortletRequest.getFile("zipFile", true);

			if (file == null) {
				throw new IllegalStateException("fileNotSelected");
			}

			maxValidDate = new Date();

			ZipImportResult importResult = importFromZipFile(new ZipFile(file), request);

			request.setAttribute("importResult", importResult);
		}
		catch (IllegalStateException ise) {
			SessionErrors.add(request, ise.getMessage());
		}
		catch (IOException ioe) {
			SessionErrors.add(request, "failedToOpenZip");
		}
	}

	private ZipImportResult importFromZipFile(ZipFile file, ActionRequest request) {

		ZipImportResult importResult = new ZipImportResult();

		for (EntryDescriptor descriptor : entryDescriptors) {
			try {
				ZipEntry entry = file.getEntry(descriptor.getZipEntryName());

				if (entry != null) {
					try {
						List<List<String>> csvList = generateCsvList(
								new BufferedReader(
									new InputStreamReader(file.getInputStream(entry))
								)
						);

						int skippedEntries = descriptor.getWriter().write(csvList, request);

						importResult.addResultEntry(
								new ZipImportResult.ResultEntry(
										descriptor.getEntryNameToDisplay(),
										csvList.size(),
										skippedEntries
								)
						);
					}
					catch (Exception ignored) {}
				}
			}
			catch (IllegalStateException ise) {
				throw new IllegalStateException("errorReadingZip");
			}
		}

		return importResult;
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

	private int writePosts(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Post.class.getName(), request
		);

		final int ID_INDEX = 0;
		final int NAME_INDEX = 1;

		int skippedEntries = 0;

		for (List<String> entry : csvList) {
			try {
				long postId = Long.parseUnsignedLong(entry.get(ID_INDEX));

				Post post;
				try {
					post = PostLocalServiceUtil.getPost(postId);
				}
				catch (PortalException pe) {
					post = PostLocalServiceUtil.createPost(postId);
				}

				post.setName(entry.get(NAME_INDEX));

				PostLocalServiceUtil.updatePost(post, serviceContext);
			}
			catch (Exception e) {
				skippedEntries++;
			}
		}

		return skippedEntries;
	}

	private int writeEmployees(List<List<String>> csvList, ActionRequest request)
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

		int skippedEntries = 0;

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

				Date birthDate = csvDateFormat.parse(entry.get(BIRTH_DATE_INDEX));

				if (birthDate.after(maxValidDate)) {
					throw new IllegalStateException("dateInFuture");
				}

				employee.setLastName(entry.get(LAST_NAME_INDEX));
				employee.setFirstName(entry.get(FIRST_NAME_INDEX));
				employee.setMiddleName(entry.get(MIDDLE_NAME_INDEX));
				employee.setBirthDate(birthDate);
				employee.setPostId(Long.parseUnsignedLong(entry.get(POST_ID_INDEX)));
				employee.setSex(Boolean.parseBoolean(entry.get(SEX_INDEX)));

				EmployeeLocalServiceUtil.updateEmployee(employee, serviceContext);
			}
			catch (Exception e) {
				skippedEntries++;
			}
		}

		return skippedEntries;
	}

	private int writeProducts(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Product.class.getName(), request
		);

		final int ID_INDEX = 0;
		final int NAME_INDEX = 1;
		final int PRODUCT_TYPE_ID_INDEX = 2;
		final int COST_INDEX = 3;
		final int AMOUNT_INDEX = 4;
		final int PRESENT_INDEX = 5;
		final int ARCHIVED_INDEX = 6;
		final int DESCRIPTION_INDEX = 7;

		int skippedEntries = 0;

		for (List<String> entry : csvList) {
			try {

				long productId = Long.parseUnsignedLong(entry.get(ID_INDEX));

				Product product;

				try {
					product = ProductLocalServiceUtil.getProduct(productId);
				}
				catch (PortalException pe) {
					product = ProductLocalServiceUtil.createProduct(productId);
				}

				product.setName(entry.get(NAME_INDEX));
				product.setProductTypeId(Long.parseUnsignedLong(entry.get(PRODUCT_TYPE_ID_INDEX)));
				product.setCost(Long.parseUnsignedLong(entry.get(COST_INDEX)));
				product.setAmount(Long.parseUnsignedLong(entry.get(AMOUNT_INDEX)));
				product.setPresent(Boolean.parseBoolean(entry.get(PRESENT_INDEX)));
				product.setArchived(Boolean.parseBoolean(entry.get(ARCHIVED_INDEX)));
				product.setDescription(entry.get(DESCRIPTION_INDEX));

				ProductLocalServiceUtil.updateProduct(product, serviceContext);

			}
			catch (Exception e) {
				skippedEntries++;
			}
		}

		return skippedEntries;
	}

	private int writeProductTypes(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ProductType.class.getName(), request
		);

		final int ID_INDEX = 0;
		final int NAME_INDEX = 1;

		int skippedEntries = 0;

		for (List<String> entry : csvList) {
			try {

				long productTypeId = Long.parseUnsignedLong(entry.get(ID_INDEX));

				ProductType productType;

				try {
					productType = ProductTypeLocalServiceUtil.getProductType(productTypeId);
				}
				catch (PortalException pe) {
					productType = ProductTypeLocalServiceUtil.createProductType(productTypeId);
				}

				productType.setName(entry.get(NAME_INDEX));

				ProductTypeLocalServiceUtil.updateProductType(productType, serviceContext);
			}
			catch (Exception e) {
				skippedEntries++;
			}
		}

		return skippedEntries;
	}

	private int writePurchases(List<List<String>> csvList, ActionRequest request) {

		final int ID_INDEX = 0;
		final int PRODUCT_ID_INDEX = 1;
		final int EMPLOYEE_ID_INDEX = 2;
		final int TIME_PURCHASED_INDEX = 3;
		final int PURCHASE_TYPE_ID_INDEX = 4;

		int skippedEntries = 0;

		for (List<String> entry : csvList) {
			try {

				long purchaseId = Long.parseUnsignedLong(entry.get(ID_INDEX));

				Purchase purchase;

				try {
					purchase = PurchaseLocalServiceUtil.getPurchase(purchaseId);
				}
				catch (PortalException pe) {
					purchase = PurchaseLocalServiceUtil.createPurchase(purchaseId);
				}

				Date datePurchased = csvTimeFormat.parse(entry.get(TIME_PURCHASED_INDEX));

				if (datePurchased.after(maxValidDate)) {
					throw new IllegalStateException("dateInFuture");
				}

				purchase.setProductId(Long.parseUnsignedLong(entry.get(PRODUCT_ID_INDEX)));
				purchase.setEmployeeId(Long.parseUnsignedLong(entry.get(EMPLOYEE_ID_INDEX)));
				purchase.setDatePurchased(datePurchased);
				purchase.setPurchaseTypeId(Long.parseUnsignedLong(entry.get(PURCHASE_TYPE_ID_INDEX)));

				PurchaseLocalServiceUtil.updatePurchase(purchase);
			}
			catch (Exception e) {
				skippedEntries++;
			}
		}

		return skippedEntries;
	}

	private int writePurchaseTypes(List<List<String>> csvList, ActionRequest request)
			throws PortalException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				PurchaseType.class.getName(), request
		);

		final int ID_INDEX = 0;
		final int NAME_INDEX = 1;

		int skippedEntries = 0;

		for (List<String> entry : csvList) {
			try {

				long purchaseTypeId = Long.parseUnsignedLong(entry.get(ID_INDEX));

				PurchaseType purchaseType;

				try {
					purchaseType = PurchaseTypeLocalServiceUtil.getPurchaseType(purchaseTypeId);
				}
				catch (PortalException pe) {
					purchaseType = PurchaseTypeLocalServiceUtil.createPurchaseType(purchaseTypeId);
				}

				purchaseType.setName(entry.get(NAME_INDEX));

				PurchaseTypeLocalServiceUtil.updatePurchaseType(purchaseType, serviceContext);

			}
			catch (Exception e) {
				skippedEntries++;
			}
		}

		return skippedEntries;
	}
}