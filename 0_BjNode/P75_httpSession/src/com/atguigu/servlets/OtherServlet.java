package com.atguigu.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 要從session讀取數據 要使用request.getSession(false): 若已經有session則返回 無則返回null
// if the request has no valid HttpSession, this method returns null.
public class OtherServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user"); // 從request域中讀取user屬性

		String userSess = null;
		HttpSession session = request.getSession(false); // 獲取Session對象
		if (session != null) {
			userSess = (String) session.getAttribute("userSess");
		}

		PrintWriter out = response.getWriter();
		out.println("OtherServlet: user = " + user);
		out.println("OtherServlet: session = " + session);
		out.println("OtherServlet: userSess = " + userSess);
	}

}
