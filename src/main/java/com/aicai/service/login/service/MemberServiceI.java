package com.aicai.service.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aicai.service.login.domain.Member;

public interface MemberServiceI {

	public abstract Member login(String username, String password,
			HttpServletRequest req, HttpServletResponse resp);

}