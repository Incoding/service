package com.aicai.service.login.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class TestController {
	@RequestMapping(value="testjsp")
	public String getjsp(Model model){
		model.addAttribute("hello", "world");
		return "/test/test";
	}
}
