package com.jisoolee;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String[] check = request.getParameterValues("remember");
		
		if(id.equals("jisoo") && pwd.equals("1234")) {
			// 아이디 기억 체크되어 있으면
			if(check != null) {
			Cookie cookie = new Cookie("CookieId", "jisoo");
			response.addCookie(cookie);
			response.sendRedirect("loginForm11.jsp");
			// 쿠키 추가
			} else {
				Cookie[] cookies = request.getCookies();
				if(cookies != null && cookies.length>0) {
					for(int i=0;i<cookies.length;i++) {
						if(cookies[i].getName().equals("CookieId")) {
							Cookie cookie = new Cookie("CookieId", "");
							cookie.setMaxAge(0);
							response.addCookie(cookie);
						}
					}
				}
				response.sendRedirect("loginForm11.jsp");
			}
		}
		else
			response.sendRedirect("loginForm11.jsp");
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("</body>");
		out.println("</html>");
	}
}
// 아이디 일치하면 아이디 저장
// 아이디 일치하지 않으면 저장하지 않음
