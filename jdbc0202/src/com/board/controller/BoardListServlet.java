package com.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.dao.BoardDAO;
import com.board.vo.BoardVO;

import util.Paging;


@WebServlet("/listAll.do")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BoardVO> boards = new ArrayList<>();
		String search = request.getParameter("search");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		//페이징 객체 생성
		Paging p = new Paging();
		
		//현재 페이지 설정 (클릭한 페이지번호를 전달받아서 현재페이지를 설정)
		//header.jsp에 게시판 버튼에는 page를 전달하지 않음
		if(request.getParameter("page") != null)
			p.setPage(Integer.parseInt(request.getParameter("page")));
		
		//전체레코드 수를 구해주는 메서드 가져와서 pageClac로 보내짐
		p.pageCalc(dao.countAll(search));
		
		//게시글들 가져오는 메서드 호출
		boards = dao.selectAllBoards(search, p);
		
		request.setAttribute("paging", p);
		request.setAttribute("boards", boards);
			
		RequestDispatcher rd = request.getRequestDispatcher("boardList.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
