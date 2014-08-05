package com.aicai.service.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aicai.service.login.domain.Member;
import com.aicai.service.login.service.MemberServiceI;

@Controller
public class LoginController {
	@Autowired
	private MemberServiceI	memberService;
	private transient Logger	logger	= LoggerFactory
												.getLogger(LoginController.class);

	@RequestMapping(value = "login")
	@ResponseBody
	public String login(String username, String password,
			HttpServletRequest req,
			HttpServletResponse resp) {
		logger.info("user:{} try login", username);
		if (username == null) {
			return "用户名不能为空";
		}
		if (password == null) {
			return "密码不能为空";
		}
		Member member = null;
		try {
			member = memberService.login(username, password, req, resp);
		} catch (Exception e) {
			logger.info("user:{}登陆发生异常,异常堆栈{}", username, e);
			return "系统异常,请稍后再试.如继续无法登陆,请联系客服.";
		}
		if (member == null) {
			return "用户名或者密码错误!";
		}
		logger.info("user:{}登陆成功", username);
		return "登陆成功";
	}

}
