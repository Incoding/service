package com.aicai.service.login.action;

import org.apache.struts2.StrutsSpringTestCase;
import org.junit.Test;
import org.springframework.mock.web.MockServletContext;

import com.aicai.service.test.mvc.strutstest.action.convetion.TestAction;
import com.opensymphony.xwork2.ActionProxy;

/**
 * http://struts.apache.org/docs/testing-actions.html
 * 注意initServletMockObjects
 *
 */
public class TestStruts2 extends StrutsSpringTestCase  {
	  @SuppressWarnings("unused")
	  private TestAction action;  
	  private ActionProxy proxy;  
	  
	  
	  
	    @Override
	protected void initServletMockObjects() {
		// TODO Auto-generated method stub
		super.initServletMockObjects();
		servletContext = new MockServletContext("file://home/kk/git/service/src/main/webapp",resourceLoader);
	}

		private void init() {  
	        proxy = getActionProxy("/test/testConvention"); //action url，可以写扩展名".action"也可以干脆不写  
	        action = (TestAction) proxy.getAction();  
	    }  
	  
	    public void testUserNameErrorMessage() throws Exception {  
	    	init();  
	        request.setParameter("nihao", "Bruc");  
	        proxy.execute();  
	    }  
	    
	    @Test 
		public void testExecuteAction() throws Exception {
	    	String output = executeAction("/test/testConvention");
	    	System.out.println(output);
		}
	  
}
