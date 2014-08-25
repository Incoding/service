package com.aicai.service.login.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aicai.service.login.common.vo.LoginResp;
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

        if (username.equals("kk")) {
            //            try {
            //                resp.sendError(404);
            //            } catch (IOException e) {
            //                // TODO Auto-generated catch block
            //                e.printStackTrace();
            //            }
            throw new RuntimeException("123");
        }
		if (username == null) {
			return LoginResp.USERNAME_NULL.json();
		}
		if (password == null) {
			return LoginResp.PWD_NULL.json();
		}
		Member member = null;
		try {
			member = memberService.login(username, password, req, resp);
		} catch (Exception e) {
			logger.info("user:{}登陆发生异常,异常堆栈{}", username, e);
            return new LoginResp().commonError("未知错误，请稍后再试。").json();
		}
		if (member == null || member.getUserId() == "") {
			return LoginResp.LOGIN_WRONG.json();
		}
		logger.info("user:{}登陆成功", username);
		return LoginResp.LOGIN_SUCCESS.json();
	}

	public static void main(String[] args) {
		String md5pwd = DigestUtils.md5Hex("123");
		System.out.println(md5pwd);
	}
}
