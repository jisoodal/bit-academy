<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쇼핑 페이지</title>
</head>
<body>
<jsp:include page="index.jsp" flush="false" />
<%
	String memberId = (String)session.getAttribute("MEMBERID");
	String url = request.getRequestURI();
	boolean login = memberId == null? false: true; // MEMBERID 속성이 존재하는 경우 true를, null(없는 경우) false를 지정해준다.
%>
<input type =hidden name="getUrl" value=<%=url %>>
<%
	if(login){ // 로그인 속성이 존재하는 경우 테이블 페이지를 보여줌
%>
<h1>쇼핑 페이지 입니다!!</h1>
<%
	} else {// 로그인 속성이 존재하지 않는 경우 loginForm.jsp로 돌려줌. 이 과정을 이 페이지에서 해야됨!! 로그인 속성이 필요한 페이지가 이 기능을 처리함. index.jsp는 그냥 버튼만 보여주는 화면임
		response.sendRedirect("/loginForm11.jsp?url="+url);
	}
%>
</body>
</html>