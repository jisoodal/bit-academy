<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="userInfo.userInfo" />
<jsp:setProperty name="user" property="*"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유저 정보</title>
</head>
<body>
<h2>유저 정보입니다.</h2>
이름:  <jsp:getProperty name="user" property="name"/><br>
id: <jsp:getProperty name="user" property="id"/><br>
pwd: <jsp:getProperty name="user" property="pwd"/><br>
email: <jsp:getProperty name="user" property="email"/>

</body>
</html>