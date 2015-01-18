package com.aicai.service.test.mvc.strutstest.action.convetion;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


@Results({
    @Result(name="index",location="/pages/test/application/struts2/testConvention.jsp")
})
public class TesAction {
	private String username;
	private String age;
	
	/**
	 * /convetion/tes/testConvention.action
	 */
	public String testConvention() {
		username = "kk";
		System.out.println("test struts convention");
		return "index";
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
