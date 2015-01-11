package com.aicai.service.test.mvc;

import java.util.ArrayList;
import java.util.List;

public class IocTestImpl implements IocTestInterface {
	public List<String> getList() {
		List<String> l = new ArrayList<>();
		l.add("abc");
		l.add("def");
		l.add("hig");
		return l;
	}
}