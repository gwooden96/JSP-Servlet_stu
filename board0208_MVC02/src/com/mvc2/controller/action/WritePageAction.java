package com.mvc2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WritePageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 게시글 작성하기 위한 서블릿

		HttpSession session = request.getSession();
		String url = null;

		// loginUser에 아무것도 없다면 로그인 페이지로 반대로 데이터가 들어있으면 게시글 작성이 가능하게
		if (session.getAttribute("loginUser") == null) {
			url = "login.jsp";
			request.setAttribute("msg", "로그인 후 사용하세요.");
		} else {
			url = "writeBoard.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
		

	}

}
