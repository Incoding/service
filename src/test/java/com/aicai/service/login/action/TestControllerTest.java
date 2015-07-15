package com.aicai.service.login.action;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


/**
 * http://andy-ghg.iteye.com/blog/1772215 </br>
 * http://jinnianshilongnian.iteye.com/blog/2007180</br>
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
		mockMvc = webAppContextSetup(wac).build();
	}

	@Test
	public void testAndReturn() throws Exception {
		MockHttpServletRequestBuilder builder = get("/testjsp.htm");
		MvcResult result = mockMvc.perform(builder).andReturn();
		ModelAndView modelAndView = result.getModelAndView();
		String viewName = modelAndView.getViewName();
		Map<String, Object> model = modelAndView.getModel();
		System.out.println("result==>"+viewName);
		System.out.println("result==>"+model);
		System.out.println(model);
	}
	
	@Test
	public void tesAndDo() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/testjsp.htm");
		MvcResult result = mockMvc.perform(builder).andDo(new ResultHandler() {
			@Override
			public void handle(MvcResult result) throws Exception {
				result.getModelAndView().setViewName("123123123");
			}
		}).andReturn();
		System.out.println("----"+result.getModelAndView().getViewName());
	}
	
	@Test
	public void testAndExpect() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/testjsp.htm");
		mockMvc.perform(builder).andExpect(status().isOk()).andExpect(model().attributeExists("hello"));
		// 下面会测试失败
//		mockMvc.perform(builder).andExpect(status().isOk()).andExpect(model().attributeExists("hello2"));
	}
	
	@Test
	public void testViewResponse() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/testjsp.htm");
		mockMvc.perform(builder).andDo(print());
	}
}
