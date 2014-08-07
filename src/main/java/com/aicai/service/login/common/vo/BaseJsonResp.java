package com.aicai.service.login.common.vo;

import com.aicai.service.util.JsonUtils;

public class BaseJsonResp {

    protected static final String SERVICE_COMMON_SUCCESS = "service.common.success";
    protected static final String SERVICE_COMMON_ERROR = "service.common.error";
	protected String	code;
	protected String	msg;

	public static void main(String[] args) {
        JsonResp json = new JsonResp("service.login.success", "登陆成功");
		System.out.println(json.json());
	}

	public String json() {
        return JsonUtils.toJsonString(this);
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

    public BaseJsonResp(String msg) {
        super();
        this.msg = msg;
    }

    /**快捷方法产生一个 通用错误信息
     * @param msg
     * @return
     */
    public BaseJsonResp commonError(String msg) {
        this.setCode(SERVICE_COMMON_ERROR);
        this.setMsg(msg);
        return this;
    }

    /**快捷方法产生一个 通用成功信息
     * @param msg
     * @return
     */
    public BaseJsonResp commonSucce(String msg) {
        this.setCode(SERVICE_COMMON_SUCCESS);
        this.setMsg(msg);
        return this;
    }
    @Override
    public String toString() {
        return JsonUtils.toJsonString(this);
    }

}