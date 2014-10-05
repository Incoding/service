package com.aicai.service;


import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.aicai.service.login.action.LoginController;

/**
 * http://andy-ghg.iteye.com/blog/1772215 </br>
 * http://jinnianshilongnian.iteye.com/blog/2004660</br>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)  
@WebAppConfiguration(value = "src/main/webapp")    
//@ContextConfiguration(locations = { "classpath:applicationContext.xml",  
//        "classpath:dispatcher-servlet.xml" })  
@ContextHierarchy({  
    @ContextConfiguration(name = "parent", locations = "classpath:applicationContext.xml"),  
    @ContextConfiguration(name = "child", locations = "classpath:dispatcher-servlet.xml")  
}) 
public class TestControllerTest {
	@Autowired
	private WebApplicationContext	wac;
	private MockMvc					mockMvc;

	@Before
	public void setUp() {
		TestControllerTest testController = new TestControllerTest();
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testView() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/testjsp.htm");
		MvcResult result = mockMvc.perform(builder).andReturn();
		ModelAndView modelAndView = result.getModelAndView();
		String viewName = modelAndView.getViewName();
		Map<String, Object> model = modelAndView.getModel();
		System.out.println("result==>"+viewName);
		System.out.println("result==>");
		System.out.println(model);
	}
}
