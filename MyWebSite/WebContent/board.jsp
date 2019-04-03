<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
<!-- 맨 위에 메뉴를 보여주기 위해 include -->
<jsp:include page="index.jsp" flush="false" />
<!-- 로그인 인증 되었는지 확인해서 로그인 속성 존재하면 board.jsp를 보여주고, 로그인 속성이 존재하지 않는다면 loginForm.jsp로 보내준다. -->
<%
// 세션의 속성을 받아와야 한다
	String memberId = (String)session.getAttribute("MEMBERID");
// url 값을 넘겨준 다음 그 값을 loginAction의 파라미터로 받아야 함.
	String url = request.getRequestURI();
	boolean login = memberId == null? false: true; // MEMBERID 속성이 존재하는 경우 true를, null(없는 경우) false를 지정해준다.
%>
<%
if(!login){ // 로그인 속성이 존재하지 않는 경우 loginForm.jsp로 돌려줌. 이 과정을 이 페이지에서 해야됨!! 로그인 속성이 필요한 페이지가 이 기능을 처리함. index.jsp는 그냥 메뉴만 보여주는 화면임
	// get 방식으로 url을 넘겨준다. 이렇게 넘겨주면 loginForm11에서 url을 getParameter로 받을 수 있음.
	response.sendRedirect("/loginForm11.jsp?url="+url);
}
%>
<table border=1>
    <tr>
        <td class="col1">글번호</td>
        <td class="col2">제목</td>
        <td class="col3">날짜</td>
    </tr>
    <tr>
        <td>1</td>
        <td class="col2">안녕하세요.</td>
        <td class="col3">18-07-31</td>
    </tr>
    <tr>
        <td>2</td>
        <td class="col2">안녕하세요2.</td>
        <td class="col3">18-07-31</td>
    </tr>
    <tr>
        <td>2</td>
        <td class="col2">안녕하세요3.</td>
        <td class="col3">18-07-31</td>
    </tr>                               
</table>

</body>
</html>