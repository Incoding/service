package com.aicai.service.login.common.vo;


public class JsonResp extends BaseJsonResp {

	public static JsonResp	commnError	= new JsonResp("service.common.error",
												"系统错误,请稍后再试");
	public static JsonResp	username_null	= new JsonResp(
												"service.login.usernamenull",
												"系统错误,请稍后再试");
	public static JsonResp	pwd_null			= new JsonResp(
													"service.login.pwdnull",
												"系统错误,请稍后再试");
	public static JsonResp	loginWrong	= new JsonResp("service.login.wrong",
												"用户名或者密码错误");
	public static JsonResp	success		= new JsonResp("service.login.success",
												"登陆成功!");

	public JsonResp(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
}
