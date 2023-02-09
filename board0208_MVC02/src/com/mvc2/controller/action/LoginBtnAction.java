package com.mvc2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.UserDAO;
import com.board.vo.UserVO;

//로그인 처리 모델
public class LoginBtnAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String url ="login.jsp";
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO();
		
		//로그인 성공 회원정보가 리턴, 실패하면 null이 리턴
		vo = dao.checkLogin(id, pw);
		
		if(vo != null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", vo);
			
			url="index.jsp";
		} else {
			request.setAttribute("msg", "로그인 실패!");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
		
}

