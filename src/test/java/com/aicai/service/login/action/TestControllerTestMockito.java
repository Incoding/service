package com.aicai.service.login.action;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

/**
 * 单元测试
 * 但是这个也是要启动spring容器的
 * 
 */
public class TestControllerTestMockito {
	private MockMvc	mockMvc;

	@Before
	public void setUp() {
		TestController testController = new TestController();
		mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
	}

	@Test
	public void testAndReturn() throws Exception {
		MockHttpServletRequestBuilder builder = get("/testjsp.htm");
		MvcResult result = mockMvc.perform(builder).andReturn();
		ModelAndView modelAndView = result.getModelAndView();
		String viewName = modelAndView.getViewName();
		Map<String, Object> model = modelAndView.getModel();
		System.out.println("result==>" + viewName);
		System.out.println("result==>" + model);
		System.out.println(model);
	}
}
