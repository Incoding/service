package com.aicai.service.login.exception;

public class MemberException extends BaseException {

	private static String		message				= "MemberException";
	private static final long	serialVersionUID	= 1L;

	public MemberException() {
		super();
	}

	public MemberException(Throwable cause) {
		super(message, cause);
	}

	public MemberException(String message, Throwable cause) {
		super(message, cause);
	}

}
