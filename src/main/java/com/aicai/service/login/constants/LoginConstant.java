package com.aicai.service.login.constants;

public class LoginConstant {

	private static String SSO_COOKIE_KEY = "sso_key";
	private static String SSO_LOGIN_KEY = "loginKey";
	private static int  SSO_LOGIN_TIME_OUT = 3600;

	public static String getSSO_COOKIE_KEY() {
		return SSO_COOKIE_KEY;
	}

	public static void setSSO_COOKIE_KEY(String sSO_COOKIE_KEY) {
		SSO_COOKIE_KEY = sSO_COOKIE_KEY;
	}


	public static String getSSO_LOGIN_KEY() {
		return SSO_LOGIN_KEY;
	}

	public static void setSSO_LOGIN_KEY(String sSO_LOGIN_KEY) {
		SSO_LOGIN_KEY = sSO_LOGIN_KEY;
	}

	public static int getSSO_LOGIN_TIME_OUT() {
		return SSO_LOGIN_TIME_OUT;
	}

	public static void setSSO_LOGIN_TIME_OUT(int sSO_LOGIN_TIME_OUT) {
		SSO_LOGIN_TIME_OUT = sSO_LOGIN_TIME_OUT;
	}
	
	
}
