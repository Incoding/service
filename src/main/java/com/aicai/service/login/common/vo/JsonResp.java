package com.aicai.service.login.common.vo;

import com.alibaba.fastjson.JSONObject;

public class JsonResp {


    private boolean isOk;

    private String code;

    private String msg;

    private String result;

    public String toJsonString() {
        return JSONObject.toJSONString(this);
    }

    private JsonResp(boolean isOk, String code, String msg, String result) {
        super();
        this.isOk = isOk;
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean isOk) {
        this.isOk = isOk;
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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
