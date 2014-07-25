package com.aicai.service.biz.auth.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 测试获得外网ip 
 * @project service
 * @author kk
 * @date 2014年7月25日
 */
@SuppressWarnings("serial")
public class UserInfo extends HttpServlet {


    public void getUserInfo() {
        System.out.println();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("getUserInfo==>");
        String ip = req.getRemoteAddr();
        System.out.println(ip);
    }

}
