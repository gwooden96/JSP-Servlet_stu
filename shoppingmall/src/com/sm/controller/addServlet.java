package com.sm.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sm.dao.ProductDAO;
import com.sm.vo.ProductVO;


@WebServlet("/add.do")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		int size = 10 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(
							request,
							path,
							size,
							"utf-8",
							new DefaultFileRenamePolicy()
					);
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureurl = multi.getParameter("pictureurl");
		String description = multi.getParameter("description");
		
		ProductVO vo = new ProductVO();
		
		vo.setName(name);
		vo.setPrice(price);
		vo.setPictureur1(pictureurl);
		vo.setDescription(description);
		
		ProductDAO dao = ProductDAO.getInstance();
		
		dao.add(vo);
		
//		request.getRequestDispatcher("/list.do").forward(request, response);
		
		response.sendRedirect("list.do");
		
	}

}
