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
	Cookie[] cookies = request.getCookies(); // 브라우저로부터 쿠키를 받음.
	String cookieName = "";
	if (cookies != null && cookies.length > 0) {
		// cookieId와 일치하는 cookie를 찾아서 value값 리턴
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("CookieId"))
				cookieName = cookies[i].getValue();
		}
	}
%>
<form action = "/LoginAction">
	id : <input name = "id" type=text value ="<%= cookieName %>" placeholder = "your id."><br>
	pwd: <input name = "pwd" type=password value="" placeholder = "your password."><br>
	<input type =checkbox name="remember" value="remok"
		<%
		if(cookieName.equals("jisoo")){
			out.println("checked");
		}
		%> >id 기억하기<br>
		 <input type =submit value="로그인">
</form>
</body>
</html>