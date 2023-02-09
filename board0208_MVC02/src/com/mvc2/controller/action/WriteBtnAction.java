package com.mvc2.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

public class WriteBtnAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BoardVO vo = new BoardVO();

		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		vo.setId(request.getParameter("id"));

		BoardDAO dao = BoardDAO.getInstance();

		dao.insertBoard(vo);

		RequestDispatcher rd = request.getRequestDispatcher("listAll.do"); // 참고 : 단순 게시판목록 페이지(jsp)로 이동하면 게시판 목록이 출력되지
																			// 않는다.listAll.do
		rd.forward(request, response);

	}

}
