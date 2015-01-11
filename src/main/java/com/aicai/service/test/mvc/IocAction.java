package com.aicai.service.test.mvc;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class IocAction extends ActionSupport {
	private static final long	serialVersionUID	= 1L;
	private IocTestInterface iti;
	
	private List<String> list;
	
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public IocTestInterface getIti() {
		return iti;
	}
	public void setIti(IocTestInterface iti) {
		this.iti = iti;
	}
	
	public String execute() throws Exception {
		this.setList(iti.getList());
		return "ioc";
	}
}