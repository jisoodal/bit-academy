<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<form action = "/registerAction.jsp" method="post">
이름 <input type="text" name="name" placeholder="이름을 입력하세요"><br>
아이디 <input type="text" name="id" placeholder="아이디를 입력하세요"><br>
비밀번호 <input type="password" name="pwd" placeholder="비밀번호를 입력하세요"><br>
이메일 <input type="text" name="email" placeholder="이메일을 입력하세요"><br>
<input type = "submit" value = "가입">
</body>
</html>