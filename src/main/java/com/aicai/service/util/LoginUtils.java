package com.aicai.service.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class LoginUtils {
	public static String getCookieVal(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		if (cookies == null) {
			return null;
		}
		for (Cookie c : cookies) {
			if (c.getName().equals(key)) {
				return c.getValue();
			}
		}
		return null;

	}
}
