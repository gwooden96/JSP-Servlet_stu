package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.UserDAO;
import com.board.vo.UserVO;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
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
	
	
//	String id = request.getParameter("id");
//	String pw = request.getParameter("pw");
//	String url ="login.jsp";
//	
//	UserDAO dao = UserDAO.getInstance();
//	
//	int result = dao.checkLogin(id, pw);
//	
//	if(result == 1) {
//		UserVO vo = dao.getUser(id);
//		
//		HttpSession session = request.getSession();
//		
//		session.setAttribute("loginUser", vo);
//		
//		url = "index.jsp";
//	} else {
//		if(result == -1) {
//			request.setAttribute("msg", "비밀번호가 일치하지 않습니다.");
//		} else {
//			request.setAttribute("msg", "아이디가 존재하지 않습니다.");
//		}
//	}
//	
//	RequestDispatcher rd = request.getRequestDispatcher(url);
//	rd.forward(request, response);
//}

}
