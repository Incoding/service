package com.aicai.service.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aicai.service.login.common.vo.JsonResp;
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
		logger.info("user:{} 尝试登陆", username);
		if (username == null) {
			return JsonResp.username_null.json();
		}
		if (password == null) {
			return JsonResp.pwd_null.json();
		}
		Member member = null;
		try {
			member = memberService.login(username, password, req, resp);
		} catch (Exception e) {
			logger.info("user:{}登陆发生异常,异常堆栈{}", username, e);
			new JsonResp("", "");
			return JsonResp.commnError.json();
		}
		if (member == null) {

			return JsonResp.loginWrong.json();
		}
		logger.info("user:{}登陆成功", username);
		return JsonResp.success.json();
	}

}
