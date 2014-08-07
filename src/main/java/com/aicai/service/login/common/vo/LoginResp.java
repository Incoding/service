package com.aicai.service.login.common.vo;


public class LoginResp extends BaseJsonResp {

    public static final LoginResp COMMN_ERROR = new LoginResp("service.common.error", "系统错误,请稍后再试。");

    public static final LoginResp USERNAME_NULL = new LoginResp("service.login.usernamenull", "用户名不能为空。");

    public static final LoginResp PWD_NULL = new LoginResp("service.login.pwdnull", "密码不能为空。");

    public static final LoginResp LOGIN_WRONG = new LoginResp("service.login.wrong", "用户名或者密码错误。");

    public static final LoginResp LOGIN_SUCCESS = new LoginResp("service.login.success", "登陆成功!");

	public LoginResp(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

    public LoginResp() {
    }
}
