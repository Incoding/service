package com.aicai.service.util;

import java.util.HashMap;

import org.junit.Test;

public class JsonUtilsTest {

	@Test
	public void testToJsonString() throws Exception {
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put("name", "kk");
		System.out.println(JsonUtils.toJsonString(hashMap));
	}

	public static void main(String[] args) {
		System.out.println("你好");
	}

}
