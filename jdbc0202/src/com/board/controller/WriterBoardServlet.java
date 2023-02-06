package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;


@WebServlet("/write.do")
public class WriterBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public WriterBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//게시글 작성하기 위한 서블릿
		
		HttpSession session = request.getSession();
		String url = null;
		
		//loginUser에 아무것도 없다면 로그인 페이지로 반대로 데이터가 들어있으면 게시글 작성이 가능하게
		if(session.getAttribute("loginUser") == null) {
			url = "login.jsp";
			request.setAttribute("msg", "로그인 후 사용하세요.");
		} else {
			url = "writeBoard.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setId(request.getParameter("id"));
		
		
		BoardDAO dao = BoardDAO.getInstance();

		
		dao.insertBoard(vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("listAll.do"); //참고 : 단순 게시판목록 페이지(jsp)로 이동하면 게시판 목록이 출력되지 않는다.listAll.do
		rd.forward(request, response);
		
	}

}
