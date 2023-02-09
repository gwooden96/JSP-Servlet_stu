package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;


@WebServlet("/delete.do")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String l_id = request.getParameter("l_id");
		String b_id = request.getParameter("b_id");
		int no = Integer.parseInt(request.getParameter("no"));
		
		String url = null;
		
		
		
		
		if(l_id.equals(b_id)) {
			BoardDAO dao = BoardDAO.getInstance();
			dao.delete(no);                                                     
			url = "listAll.do";
		} else {
			request.setAttribute("msg", "작성자만 삭제가능합니다.");
			url = "showBoard.do";
		}
		

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
