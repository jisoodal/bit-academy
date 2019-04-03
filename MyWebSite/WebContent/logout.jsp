<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<%
	String isLogin = (String)session.getAttribute("MEMBERID");
	if(isLogin != null){
	session.removeAttribute("MEMBERID");
%>
<script>
	alert('로그아웃 되었습니다.');
</script>
<%
	}
%>
<a href = "/index.jsp">홈으로</a>
</body>
</html>