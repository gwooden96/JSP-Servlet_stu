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


@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String l_id = request.getParameter("l_id");
		String b_id = request.getParameter("b_id");
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO vo = new BoardVO();
		
		BoardDAO dao = BoardDAO.getInstance();
		
		String url = null;

		
		if(l_id.equals(b_id)) {
			vo = dao.selectBoard(no);
			request.setAttribute("boardPost", vo);
			
			url = "updateBoard.jsp";
		} else {
			request.setAttribute("msg", "작성자만 수정 가능합니다.");
			url = "showBoard.do";
		}
		

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(no);
		
		BoardDAO dao = BoardDAO.getInstance();
		
		dao.updateBoard(vo);
		
		request.setAttribute("msg", "수정이 완료되었습니다.");
		
		vo = dao.selectBoard(no);
		request.setAttribute("boardPost", vo);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("updateBoard.jsp");
		rd.forward(request, response);
	}

}
