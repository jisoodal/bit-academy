package com.jisoolee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet") // 한개일 때는 무조건 name = 을 붙이면 안됨!! 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int count = 0;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 요청 시 넘겨받은 값들을 읽어온다.
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		// 2. 작업을 수행한다. -> 여기서의 경우 id, pwd
		
		// 3. 작업 결과를 response에 출력한다.(out.println()). 이 3단계로 코드를 짜주면 됨 
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello, "+id+".</h1>");
		out.println("<h1>Your password is "+pwd+".</h1>");
		out.println("<h1>count="+ ++count +".</h1>");
		out.println("</body>");
		out.println("</html>");
	}
}
