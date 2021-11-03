package com.trollingcont.servicebuilder.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class ProductTypeException extends PortalException {

    private final ErrorCode errorCode;

    public ProductTypeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public enum ErrorCode {
        NAME_EMPTY,
        NAME_TOO_LONG
    }
}
