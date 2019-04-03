<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>home</title>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:1px solid #bbb;
}

li:last-child {
  border-right: none;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #4CAF50;
}
</style>
</head>
<body>
<%
	String url = request.getRequestURI();
%>
<ul>
  <li><a href="/index.jsp">Home</a></li>
  <li><a href="/board.jsp">Board</a></li>
  <li><a href="/shopping.jsp">Shopping</a></li>
  <% 
  String memberId = (String)session.getAttribute("MEMBERID");
  boolean login = memberId == null ? false : true;
  if(login){ %> <!-- 로그인 상태에는 로그아웃 메뉴가 보여져야 함 -->
  <li><a href="/logout.jsp">로그아웃</a></li>
  <% }else { %> <!-- 로그아웃 상태에는 로그인 메뉴가 보여져야 함 -->
  <li><a href="/loginForm11.jsp?url=<%=url %>">로그인</a></li>
  <% } %>
</ul>

</body>
</html>