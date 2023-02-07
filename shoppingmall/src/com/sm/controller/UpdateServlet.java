package com.sm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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


@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = new ProductVO();
		
		vo = dao.select(code);
		
		request.setAttribute("product", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp");
		rd.forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글 인식
		request.setCharacterEncoding("utf-8");
		
		//이미지 파일 세팅
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
		
		//기존 jsp에서 입력한 값 가져오기
		int code = Integer.parseInt(multi.getParameter("code"));
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String pictureurl = multi.getFilesystemName("pictureurl");
		String description = multi.getParameter("description");
				
		
		
		//vo 클래스 사용하기 위한 new 객체 생성
		ProductVO vo = new ProductVO();
		
		//jsp에서 입력한 값을 변수로 저장한걸 vo에 set으로 값을 넣어준다.
		vo.setCode(code);
		vo.setName(name);
		vo.setPrice(price);
		vo.setPictureurl(pictureurl);
		vo.setDescription(description);
		
		
		
		//DAO 메서드 사용 시작
		ProductDAO dao = ProductDAO.getInstance();
		
		// vo값을 업데이트 메서드로 보내서 쿼리 작동
		dao.update(vo);
		
		
		request.setAttribute("msg", "수정이 완료되었습니다.");
		
		//업데이트 된 입력값을 새롭게 보여주기 위한 코드
		request.setAttribute("product", vo);
				
		RequestDispatcher rd = request.getRequestDispatcher("updateProduct.jsp");
		rd.forward(request, response);
	}

}
