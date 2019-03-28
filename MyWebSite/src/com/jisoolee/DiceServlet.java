package com.jisoolee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DiceServlet")
public class DiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		
		String dice1 = "";
		String dice2 = "";
		int ranNum = 0;
		
		ranNum = (int)((Math.random()*6)+1);
		
		out.print("<img src='" + request.getContextPath() + "/image/dice"+ranNum+".jpg'/>");
		ranNum = (int)((Math.random()*6)+1);
		out.print("<img src='" + request.getContextPath() + "/image/dice"+ranNum+".jpg'/>");
		
		out.println("</body>");
		out.println("</html>");
	}
}
