package com.aicai.service.test.mvc.strutstest.action.convetion;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.aicai.service.login.service.MemberServiceI;

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
	
	@Autowired
	MemberServiceI MemberServiceI;
	
	@Action("/testConvention")
	public String testConvention() {
		username = "kk";
		System.out.println("test struts convention");
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameter("nihao"));
//		MemberServiceI.login(username, age, request, null);
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
