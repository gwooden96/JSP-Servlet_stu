package com.sm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sm.dao.ProductDAO;
import com.sm.vo.ProductVO;


@WebServlet("/list.do")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<ProductVO> list = new ArrayList<>();
		
		ProductDAO dao = ProductDAO.getInstance();
		
		list = dao.list();
		
		request.setAttribute("products", list);
		
//		RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
//		rd.forward(request, response);
		
		request.getRequestDispatcher("list.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
