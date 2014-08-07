package com.aicai.service.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtils {
    public static String toJsonString(Object object) {
        return JSONObject.toJSONString(object);
    }
}
