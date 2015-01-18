package com.aicai.service.test.mvc.strutstest.action.convetion;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * 总结常用的注解如下：

Namespace：指定命名空间。

ParentPackage：指定父包。

Result：提供了Action结果的映射。（一个结果的映射）

Results：“Result”注解列表

ResultPath：指定结果页面的基路径。

Action：指定Action的访问URL。

Actions：“Action”注解列表。

ExceptionMapping：指定异常映射。（映射一个声明异常）

ExceptionMappings：一级声明异常的数组。

InterceptorRef：拦截器引用。

InterceptorRefs：拦截器引用组。
 *
 */
@Results({
    @Result(name="index",location="/pages/test/application/struts2/testConvention.jsp")
})
@Namespace("/test")
public class TestAction {
	private String username;
	private String age;
	
	@Action("/testConvention")
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