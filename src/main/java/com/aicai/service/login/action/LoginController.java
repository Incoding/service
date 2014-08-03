package com.aicai.service.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	@RequestMapping(value = "login")
	@ResponseBody
	public String login(String username, String password,
			HttpServletRequest req,
			HttpServletResponse resp) {
		if (username == null) {
			return "用户名不能为空";
		}
		if (password == null) {
			return "密码不能为空";
		}
		Member member = memberService.login(username, password, req, resp);
		if (member == null) {
			return "用户名或者密码错误!";
		}
		return "登陆成功";
	}

}
