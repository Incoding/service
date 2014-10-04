package com.aicai.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

public class JunitAction {
	private MockMvc					mockMvc;
	private static HandlerMapping	handlerMapping;
	private static HandlerAdapter	handlerAdapter;

	@BeforeClass
	public static void setUp() {
		if (handlerMapping == null) {
			String[] configs = { "classpath:applicationContext.xml",
					"classpath:dispatcher-servlet.xml" };
			XmlWebApplicationContext context = new XmlWebApplicationContext();
			context.setConfigLocations(configs);
			MockServletContext msc = new MockServletContext();
			context.setServletContext(msc);
			context.refresh();
			msc.setAttribute(
					WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE,
					context);// TODO
			handlerMapping = (HandlerMapping) context
					.getBean(RequestMappingHandlerMapping.class);

			handlerAdapter = (HandlerAdapter) context
					.getBean(context
							.getBeanNamesForType(RequestMappingHandlerAdapter.class)[0]);

			// handlerAdapter = (HandlerAdapter) context.getBean(context
			// .getNamespace());
		}
	}

	public ModelAndView excuteAction(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 这里需要声明request的实际类型，否则会报错
		request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		HandlerExecutionChain chain = handlerMapping.getHandler(request);
		ModelAndView model = null;
		try {
			model = handlerAdapter
					.handle(request, response, chain.getHandler());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	public String excuteActionJson(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 这里需要声明request的实际类型，否则会报错
		request.setAttribute(HandlerMapping.INTROSPECT_TYPE_LEVEL_MAPPING, true);
		HandlerExecutionChain chain = handlerMapping.getHandler(request);
		String json = null;
		// handlerAdapter
		// .handle(request, response, chain.getHandler());
		return json;
	}
	@Test
	public void testUserShow() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setServletPath("/login.htm");
		request.addParameter("username", "KK");
		request.addParameter("password", "123456");
		request.setMethod("get");
		final ModelAndView mav = this.excuteAction(request, response);
		// Assert.assertEquals("userManager/userlist", mav.getViewName());
		// String msg = (String) request.getAttribute("msg");
		System.out.println("result==>"+mav);
	}

	@Test
	public void testjson() throws Exception {
		ResultActions perform = mockMvc.perform(get("/login.htm"));
		System.out.println(perform.toString());
	}
}
