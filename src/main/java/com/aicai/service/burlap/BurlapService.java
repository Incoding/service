package com.aicai.service.burlap;

import java.util.List;

/**
 * 声明服务端相关的服务
 * 
 * 
 */
public interface BurlapService {

	public String getUserName();

	public List<String> getList();

	public void setGreeting(String greeting);

	public String hello();

}