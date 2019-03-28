package com.jisoolee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyFortune")
public class MyFortuneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MyFortuneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		
		String[] anim = {"pig", "dog", "chicken", "monkey", "sheep", "horse" ,
						"snake", "dragon","rabbit","tiger","cow","mouse"};
		
		String pigFort 		= "There is all likelihood today of things not shaping up as you desired.",
			   dogFort 		= "You will find it difficult to keep up appearances. Be prepared.",
			   chickenFort	= "There is a possibility that your peers may pass on their workload to you.",
			   monkeyFort 	= "Today you will be forced to make quick decisions.",
			   sheepFort
		
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println(name+"'s fortune :");
		out.println("<br>");
		out.println("birth date:"+birth);
		out.println("</body>");
		out.println("</html>");
			
		// 띠별 운세 불러오기
		String[] birthArr = birth.split("-");
		
		
		
	}


}
