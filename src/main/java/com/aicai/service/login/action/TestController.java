package com.aicai.service.login.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class TestController {
	@Autowired
	private ServletContext	servletContext;
	@RequestMapping(value="testjsp")
	public String getjsp(Model model){
		model.addAttribute("hello", "world2");
		return "/test/test";
	}

	/**
	 * 先去子容器找,找不到,再去父容器找
	 */
	@RequestMapping(value = "testwebapplication")
	public String testwebapplication(HttpServletRequest req) {
		// WebApplicationContext webApplicationContext =
		// WebApplicationContextUtils
		// .getWebApplicationContext(servletContext);
		WebApplicationContext webApplicationContext = RequestContextUtils
				.getWebApplicationContext(req);
		Object bean = webApplicationContext
				.getBean(BeanNameUrlHandlerMapping.class);
		System.out.println(bean);
		Object dataSource = webApplicationContext.getBean("dataSource");
		System.out.println(dataSource);
		return "/test/test";
	}

	/**
	 * 子容器和根容器虽然都持有CommonAnnotationBeanPostProcessor内部类型得实例,但是这俩个容器中的实例不是同一个
	 */
	@RequestMapping(value = "testwebapplication2")
	public String testwebapplication2(HttpServletRequest req) {
		// 子容器
		WebApplicationContext child = RequestContextUtils
				.getWebApplicationContext(req);
		// 根容器
		WebApplicationContext root = WebApplicationContextUtils
				.getWebApplicationContext(servletContext);
		CommonAnnotationBeanPostProcessor childCommonAnnotationBeanPostProcessor = child
				.getBean(CommonAnnotationBeanPostProcessor.class);
		System.out.println(childCommonAnnotationBeanPostProcessor);
		CommonAnnotationBeanPostProcessor rootCommonAnnotationBeanPostProcessor = root
				.getBean(CommonAnnotationBeanPostProcessor.class);
		System.out.println(rootCommonAnnotationBeanPostProcessor);
		System.out
				.println(childCommonAnnotationBeanPostProcessor == rootCommonAnnotationBeanPostProcessor);
		return "/test/test";
	}
}
