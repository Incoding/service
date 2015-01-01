package com.aicai.service.test.application.prg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用prg模式防止表单重复提交</br>
 * http://www.bkjia.com/jingyan/471187.html
 * http://my.oschina.net/imot/blog/143120
 *
 */
@Controller
public class TestPrg {
	
	
	
	@RequestMapping("prg/post")
	public String postMethod(String name,String amount) {
		System.out.println(name+"购买了"+amount+"元");
		return "redirect:/prg/get.htm";
	}
	@RequestMapping("prg/get")
	public String getMethod(String name,String amount) {
		System.out.println(name+"提示购买成功");
		return "/test/application/prg/buySuccess";
	}

}
