<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>

<jsp:useBean id="user" scope="request" class="userInfo.userInfo" />
<jsp:setProperty name="user" property="*" />

<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // DB이름인 book_ex를 적절히 변경 
	        String DB_User = "root";  // DB의 Userid와 pwd를 알맞게 변경 
	        String DB_PASSWORD = "rootpw"; 
	        
	        conn = DriverManager.getConnection(DB_URL, DB_User, DB_PASSWORD);
 	        
 	        //쿼리의 틀을 미리 생성해 놓고 값을 나중에 지정
 	        pstmt = conn.prepareStatement(
 	        		"insert into book_ex.user_info(USER_ID,PASSWORD,NAME,EMAIL) values(?,?,?,?)");
 	        // 필요한 값 지정 .
 	        // u.USER_ID로 불러오는것 -> 말 없이 펜을 들고가는 것
 	        // u.getUSER_ID로 불러오는 것 -> 야 펜좀줄래? 하는 것
 	        pstmt.setString(1, user.getId());
 	        pstmt.setString(2, user.getPwd());
 	        pstmt.setString(3, user.getName());
 	        pstmt.setString(4, user.getEmail());
 	        // 쿼리를 실행하기 위한 메서드
 	        pstmt.executeUpdate();
 	 	} catch ( Exception e ) {
 	       e.printStackTrace();
 	     } finally {
 		 if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
 		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
 		 }
%>


<jsp:forward page="/viewUserInfo.jsp"/>

