package com.aicai.service.test.mvc;

import java.util.ArrayList;
import java.util.List;

public class IocTest2Impl implements IocTestInterface {
	public List<String> getList() {
		List<String> l = new ArrayList<>();
		l.add("123");
		l.add("456");
		l.add("789");
		return l;
	}
}