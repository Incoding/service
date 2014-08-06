package com.aicai.service.login.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorCode errorCode;

    public BaseException() {
        super();
    }

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getInfo());
        this.errorCode = errorCode;
    }

    public BaseException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getInfo(), cause);
        this.errorCode = errorCode;
    }

    public BaseException(String message) {
        super(message);
        this.errorCode = new ErrorCode(ErrorCode.BUSINESS_COMMON_ERROR, message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = new ErrorCode(ErrorCode.BUSINESS_COMMON_ERROR, message);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
