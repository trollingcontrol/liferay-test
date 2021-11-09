package com.trollingcont.importziportlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;

import javax.portlet.ActionRequest;
import java.util.List;

@FunctionalInterface
public interface CsvListWriter {
    int write(List<List<String>> csvList, ActionRequest request) throws PortalException;
}
