package com.aicai.service.login.common.vo;


public class JsonResp extends BaseJsonResp {

    public static JsonResp COMMN_ERROR = new JsonResp("service.common.error", "系统错误,请稍后再试。");

    public static JsonResp USERNAME_NULL = new JsonResp("service.login.usernamenull", "用户名不能为空。");

    public static JsonResp PWD_NULL = new JsonResp("service.login.pwdnull", "密码不能为空。");

    public static JsonResp LOGIN_WRONG = new JsonResp("service.login.wrong", "用户名或者密码错误。");

    public static JsonResp LOGIN_SUCCESS = new JsonResp("service.login.success", "登陆成功!");

	public JsonResp(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

    public JsonResp() {
    }
}
