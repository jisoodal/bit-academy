<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<jsp:include page="index.jsp" flush="false" />
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
	// get 방식으로 넘겨받은 url을 변수에 받음.
	String url = request.getParameter("url");
	// 홈에서 바로 로그인 시도 시
	if(url==null){
		// 로그인 후 /index.jsp로 가야 함.
		url=request.getRequestURI();
	}
%>
<form action = "/loginAction.jsp">

	id : <input name = "id" type=text value ="<%= cookieName %>" placeholder = "your id."><br>
	pwd: <input name = "pwd" type=password value="" placeholder = "your password."><br>
	<input type =checkbox name="remember" value="remok"
		<%
		if(cookieName.equals("jisoo")){
			out.println("checked"); // 이렇게 하지말고 checked = "" 해놓은 다음에 일치하면 ="checked"로 아니면 ""로 냅두면 됨.
		}
		%> >id 기억하기<br>
		 <input type=submit value="로그인">
		 <input type =hidden name="getUrl" value=<%=url %>>
</form>
</body>
</html>