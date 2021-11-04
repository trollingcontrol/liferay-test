package com.trollingcont.servicebuilder.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class ProductException extends PortalException {

    private final ErrorCode errorCode;

    public ProductException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode errorCode() {
        return errorCode;
    }

    public enum ErrorCode {
        NAME_EMPTY,
        NAME_TOO_LONG,
        DESCRIPTION_EMPTY,
        DESCRIPTION_TOO_LONG,
        INVALID_COST,
        INVALID_AMOUNT
    }
}
