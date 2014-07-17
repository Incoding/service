package com.aicai.service.burlap;


import java.net.MalformedURLException;

import com.caucho.burlap.client.BurlapProxyFactory;

/**
 * Burlap客户端测试代码
 * 
 * @author longgangbai
 * 
 */
public class BurlapServiceWSClient {
	public static void main(String[] args) {
		String url = "http://localhost:8080/service/remoting/burlapWs";

		BurlapProxyFactory factory = new BurlapProxyFactory();
		BurlapService basic;
		try {
			basic = (BurlapService) factory.create(BurlapService.class, url);
			System.out.println("hello(): " + basic.getUserName());
			System.out.println("getList(): " + basic.getUserName());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}