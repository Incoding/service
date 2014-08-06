package com.aicai.service.login.common.vo;

import com.alibaba.fastjson.JSONObject;

public class BaseJsonResp {

	protected String	code;
	protected String	msg;

	public static void main(String[] args) {
		JsonResp json = new JsonResp("200", "登陆成功");
		System.out.println(json.json());
	}

	public String json() {
		return JSONObject.toJSONString(this);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BaseJsonResp() {
		super();
	}

}