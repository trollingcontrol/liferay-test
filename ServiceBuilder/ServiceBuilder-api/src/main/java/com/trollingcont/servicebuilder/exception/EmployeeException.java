package com.trollingcont.servicebuilder.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class EmployeeException extends PortalException {

    private final ErrorCode errorCode;

    public EmployeeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public enum ErrorCode {
        FIRST_NAME_EMPTY,
        FIRST_NAME_TOO_LONG,
        LAST_NAME_EMPTY,
        LAST_NAME_TOO_LONG,
        MIDDLE_NAME_EMPTY,
        MIDDLE_NAME_TOO_LONG
    }
}
