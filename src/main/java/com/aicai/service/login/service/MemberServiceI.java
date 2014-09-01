package com.aicai.service.login.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aicai.service.login.domain.Member;
import com.aicai.service.login.domain.modelresult.ModelResult;

public interface MemberServiceI {

	public abstract ModelResult<Member> login(String username, String password,
			HttpServletRequest req, HttpServletResponse resp);

}