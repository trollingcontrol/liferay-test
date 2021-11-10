package com.trollingcont.bestemployees.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.trollingcont.bestemployees.constants.BestEmployeesPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.trollingcont.servicebuilder.model.Employee;
import com.trollingcont.servicebuilder.model.Post;
import com.trollingcont.servicebuilder.model.Product;
import com.trollingcont.servicebuilder.model.Purchase;
import com.trollingcont.servicebuilder.service.EmployeeLocalServiceUtil;
import com.trollingcont.servicebuilder.service.PostLocalServiceUtil;
import com.trollingcont.servicebuilder.service.ProductLocalServiceUtil;
import com.trollingcont.servicebuilder.service.PurchaseLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author user
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=BestEmployees",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BestEmployeesPortletKeys.BESTEMPLOYEES,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BestEmployeesPortlet extends MVCPortlet {

	static final int BEST_EMPLOYEES_NUMBER = 3;
	static final int LAST_DAYS_TO_COUNT = 30;

	private Date minimumDate;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HashMap<Post, List<BestEmployeeEntry>> bestEmployeesMap = new HashMap<>();

		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, -LAST_DAYS_TO_COUNT);
		minimumDate = calendar.getTime();
		
		for (Post post : PostLocalServiceUtil.getAllPosts()) {
			bestEmployeesMap.put(post, getBestEmployeesByPost(post.getPostId()));
		}

		renderRequest.setAttribute("bestEmployeesMap", bestEmployeesMap);

		super.render(renderRequest, renderResponse);
	}

	private List<BestEmployeeEntry> getBestEmployeesByPost(long postId) {

		List<BestEmployeeEntry> sortedBestEmployees = EmployeeLocalServiceUtil.getEmployeesByPostId(postId)
				.stream()
				.map(this::createBestEmployeeEntry)
				.sorted(this::compareBestEmployeeEntry)
				.collect(Collectors.toList());

		return sortedBestEmployees.subList(
				0,
				Math.min(sortedBestEmployees.size(), BEST_EMPLOYEES_NUMBER)
		);
	}

	private BestEmployeeEntry createBestEmployeeEntry(Employee employee) {
		return new BestEmployeeEntry(
				employee,
				getTotalEmployeePurchasesCost(employee.getEmployeeId())
		);
	}

	private int compareBestEmployeeEntry(BestEmployeeEntry e1, BestEmployeeEntry e2) {
		if (e2.getCost() > e1.getCost()) {
			return 1;
		}
		else if (e2.getCost() < e1.getCost()) {
			return -1;
		}
		return 0;
	}

	private long getTotalEmployeePurchasesCost(long employeeId) {

		List<Purchase> purchases =
				PurchaseLocalServiceUtil.getPurchasesByEmployee(employeeId)
						.stream()
						.filter(this::isPurchaseLastDays)
						.collect(Collectors.toList());

		long summaryCost = 0;

		for (Purchase purchase : purchases) {
			try {
				Product product = ProductLocalServiceUtil.getProduct(purchase.getProductId());

				summaryCost += product.getCost();
			}
			catch (PortalException ignored) {}
		}

		return summaryCost;
	}


	private boolean isPurchaseLastDays(Purchase purchase) {
		return purchase.getDatePurchased().after(minimumDate);
	}
}