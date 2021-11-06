package com.trollingcont.servicebuilder.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class PostException extends PortalException {

    private final ErrorCode errorCode;

    public PostException(ErrorCode errorCode) {
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
