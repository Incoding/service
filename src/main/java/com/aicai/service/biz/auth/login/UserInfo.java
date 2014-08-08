package com.aicai.service.biz.auth.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 测试获得外网ip 
 * @project service
 * @author kk
 * @date 2014年7月25日
 */
@SuppressWarnings("serial")
public class UserInfo extends HttpServlet {
	public void getUserInfo(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println("getUserInfo==>");
		String ip = req.getRemoteAddr();
        dealSession(req, resp);
		System.out.println(ip);
    }

    /**测试session与cookie得配合
     * http://blog.csdn.net/xiao__gui/article/details/17298437?reload
     * @param req
     * @param resp
     */
    private void dealSession(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        System.out.println(session.getId());
        if (session.getAttribute("user") == null) {
            session.setAttribute("user", "xxg");
            System.out.println("null");
        } else {
            System.out.println(session.getAttribute("user"));
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		getUserInfo(req, resp);
		after();
    }

	private void after() {
		System.out.println("after");
	}


}
