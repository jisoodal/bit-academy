<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String url = request.getParameter("getUrl");
String[] check = request.getParameterValues("remember");

if(id.equals("jisoo") && pwd.equals("1234")) {
	// 아이디 비밀번호 일치하는 경우 세션에 id 저장
	session.setAttribute("MEMBERID", id);
	
	// 아이디 기억 체크되어 있으면
	if(check != null) {
	// 쿠키 생성
	Cookie cookie = new Cookie("CookieId", "jisoo");
	response.addCookie(cookie);
	} else {
		// 체크되어있지 않으면 쿠키 삭제해야함.
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
	}
	// board로 가려다가 로그인 창이 뜬 경우에는 로그인 후 board로, shopping인 경우에는 shopping으로 가야하기 때문에 url 변수를 따로 지정해야 함.
	response.sendRedirect(url);
%>
<%
}
else // 로그인 실패시 다시 로그인 화면으로 가되, url값은 유지해줘야 함.
	response.sendRedirect("loginForm11.jsp?url="+url);
%>
</body>
</html>