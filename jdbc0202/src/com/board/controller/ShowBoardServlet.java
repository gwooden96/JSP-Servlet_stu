package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;


@WebServlet("/showBoard.do")
public class ShowBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = new BoardVO(); //저장
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.updateCnt(no);
		vo = dao.selectBoard(no);
		
		request.setAttribute("boardPost", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("showBoard.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
