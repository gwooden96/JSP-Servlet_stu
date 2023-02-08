package com.movie.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/download.do")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//파일 다운로드 기능
		
		String saveDirectory = request.getServletContext().getRealPath("images"); //경로
		String title = request.getParameter("title"); //다운받을떄 표시할 파일명
		String poster = request.getParameter("poster"); //실제 서버에 저장된 파일명
		
		//그냥 title을 사용하면 다운받을때 '아바타' 이런식으로 다운받아짐
		//그래서 아바타.jpg 뒤에 확장자를 추가한 코드
		title += ".jpg";
		
		try {
			//new File(파일경로, 파일명);
			File file = new File(saveDirectory, poster);
			InputStream is = new FileInputStream(file);
			
			
			//사용자 브라우저 종류를 찾은 후 저장
			String client = request.getHeader("user-agent");
			
			if(client.indexOf("WOW64") == 1) {
				title = new String(title.getBytes("utf-8"), "iso-8859-1");
			} else {
				title = new String(title.getBytes("ksc5601"), "iso-8859-1"); //익스플로러 브라우저만 인코딩 방식이 다르다.
			}
			
			response.reset();
			
			response.setContentType("application/octet-stream"); //8비트짜리 바이너리 데이터
			response.setHeader("Content-Disposition", "attachment; filename=\"" + title + "\"");
			
			//mapper클래스다 보니 문자열로 형변환을 위해서는 Long.toString(file.length()) <--이런식으로 하거나 아래처럼 공백을 넣어주면 된다.
			response.setHeader("content-Length", "" + file.length()); 
			
			OutputStream os = response.getOutputStream();
			
			byte[] b = new byte[(int)file.length()];
			int readBuffer = 0;
			
			while ((readBuffer = is.read(b)) > 0) {
				os.write(b, 0, readBuffer);
			}
			os.close();
			is.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
