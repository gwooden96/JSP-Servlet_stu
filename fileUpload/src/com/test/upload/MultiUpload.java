package com.test.upload;

import java.io.IOException;
import java.sql.Savepoint;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload2.do")
public class MultiUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String savaDirectory = request.getServletContext().getRealPath("upload");
		
		int fileSize = 5 * 1024 * 1024;
		
		try {
			MultipartRequest multi = new MultipartRequest(
					
						request,
						savaDirectory,
						fileSize,
						"utf-8",
						new DefaultFileRenamePolicy()
					
					);
			Enumeration files = multi.getFileNames(); //업로드한 파일명들을 리턴 시켜준다. (여러 파일들)
			while(files.hasMoreElements()) {
				String file = (String)files.nextElement();
				String fileName = multi.getFilesystemName(file); //파일명 (중복되면 변경됨)
				String oriFlieName = multi.getOriginalFileName(file); //원본파일명
				
				System.out.println(fileName);
				System.out.println();
				} 
			
			}catch (Exception e) {
				e.printStackTrace();
		}
		
	}

}
