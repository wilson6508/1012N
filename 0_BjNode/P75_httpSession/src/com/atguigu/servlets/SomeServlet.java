package com.atguigu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// request.getSession() 同 request.getSession(true): 若已經有session則返回 無則創建新的
// returns the current session associated with this request, or if the request dose not have a session, creates one.
public class SomeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username"); // 獲取用戶提交參數
		request.setAttribute("user", username); // 將參數放入request域

		HttpSession session = request.getSession(); // 獲取Session對象
		session.setAttribute("userSess", username); // 向Session域中寫入屬性

		response.getWriter().print("SomeServlet : " + username);
	}

}
