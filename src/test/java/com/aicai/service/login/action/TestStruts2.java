package com.aicai.service.login.action;

import static org.junit.Assert.*;

import org.apache.struts2.StrutsSpringTestCase;
import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.aicai.service.test.mvc.strutstest.action.convetion.TestAction;
import com.opensymphony.xwork2.ActionProxy;

/**
 * 还未整好
 *
 */
public class TestStruts2 extends StrutsSpringTestCase  {
	  @SuppressWarnings("unused")
	  private TestAction action;  
	  private ActionProxy proxy;  
	  
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
