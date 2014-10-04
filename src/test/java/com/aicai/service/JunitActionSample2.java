package com.aicai.service;

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
public class JunitActionSample2 {
	@Autowired
	private WebApplicationContext	wac;
	private MockMvc					mockMvc;

	@Before
	public void setUp() {
		LoginController loginController = new LoginController();
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void testView() throws Exception {
		// MvcResult result =
		// mockMvc.perform(MockMvcRequestBuilders.get("/user/1"))
		// .andExpect(MockMvcResultMatchers.view().name("user/view"))
		// .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
		// .andDo(MockMvcResultHandlers.print())
		// .andReturn();
		// Assert.assertNotNull(result.getModelAndView().getModel().get("user"));
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/login.htm");
		builder.param("username", "kk");
		builder.param("password", "123");
		MvcResult result = mockMvc.perform(builder).andReturn();
		result.getResponse().setCharacterEncoding("UTF-8");
		MockHttpServletResponse response = result.getResponse();
		response.setCharacterEncoding("UTF-8");
		String contentAsString = response.getContentAsString();
		System.out.println("result ==>" +new String(contentAsString.getBytes()));
	}
}
