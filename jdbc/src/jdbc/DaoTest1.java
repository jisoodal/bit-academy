package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTest1 {
    public static void main(String[] args) {
//    User u = new User("ff22f","4444","홍길동","aaa@aaa.com");
//     User u = selectUser("ff22f");
//     System.out.println(u);
//	   insertUser(u);
//     updateUser(u); // 객체 u에 저장된 값을 DB의 user_info테이블에 insert하는 메서드
//     deleteUser("ff22f"); // 객체 u에 저장된 user_id와 동일한 행의 정보를 delete하는 메서드

//     u = selectUser("ff22f");
  
     List<User> list = selectAllUsers();

     System.out.println(list);
   }
    
    static List<User> selectAllUsers() {
    	
    	 Connection conn = null;
	     // 생성
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     List<User> list = new ArrayList<User>();
	     User u = null;
	 
	 	 try {	
	 		 
	 		 	Class.forName("com.mysql.jdbc.Driver");
	 		
	 		 	String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // DB이름인 book_ex를 적절히 변경 
	 	        String DB_User = "root";  // DB의 Userid와 pwd를 알맞게 변경 
	 	        String DB_PASSWORD = "rootpw"; 
	 	        
	 	        conn = DriverManager.getConnection(DB_URL, DB_User, DB_PASSWORD);
	 	        
	 	        //쿼리의 틀을 미리 생성해 놓고 값을 나중에 지정
	 	        pstmt = conn.prepareStatement(
	 	        		"select * from book_ex.user_info");
	 	        // 필요한 값 지정 .
	 	        // u.USER_ID로 불러오는것 -> 말 없이 펜을 들고가는 것
	 	        // u.getUSER_ID로 불러오는 것 -> 야 펜좀줄래? 하는 것
	 	        // 쿼리를 실행하기 위한 메서드
	 	       rs = pstmt.executeQuery();
	 	        
	 	       while (rs.next()) { 
	 	          String user_id = rs.getString("USER_ID");
	 	          String passwd = rs.getString("PASSWORD");
	 	          String name = rs.getString("NAME");
	 	          String email = rs.getString("EMAIL");
	 	          list.add(new User(user_id, passwd, name, email));
	 	         }
	 	 	} catch ( Exception e ) {
	 	       e.printStackTrace();
	 	     } finally {
	 		 if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
	 		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
	 		 }
    	
	 	 return list;

    	}
    
    static int deleteUser(String userId) {

    	Connection conn = null;
	     // 생성
	     PreparedStatement pstmt = null;
	     int result = 0;
	 
	 	 try {	
	 		 
	 		 	Class.forName("com.mysql.jdbc.Driver");
	 		
	 		 	String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // DB이름인 book_ex를 적절히 변경 
	 	        String DB_User = "root";  // DB의 Userid와 pwd를 알맞게 변경 
	 	        String DB_PASSWORD = "rootpw"; 
	 	        
	 	        conn = DriverManager.getConnection(DB_URL, DB_User, DB_PASSWORD);
	 	        
	 	        //쿼리의 틀을 미리 생성해 놓고 값을 나중에 지정
	 	        pstmt = conn.prepareStatement(
	 	        		"delete from book_ex.user_info where USER_ID = ?");
	 	        // 필요한 값 지정 .
	 	        // u.USER_ID로 불러오는것 -> 말 없이 펜을 들고가는 것
	 	        // u.getUSER_ID로 불러오는 것 -> 야 펜좀줄래? 하는 것
	 	        pstmt.setString(1, userId);
	 	        // 쿼리를 실행하기 위한 메서드
	 	        pstmt.executeUpdate();
	 	        result = pstmt.getUpdateCount();
	 	 	} catch ( Exception e ) {
	 	       e.printStackTrace();
	 	     } finally {
	 		 if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
	 		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
	 		 }
	 	 
	 	 	return result;

    	}
    
    static User selectUser(String userId) {
    	
    	 Connection conn = null;
	     // 생성
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     
	     User u = null;
	     
    	 try {	
	 		 
	 		 	Class.forName("com.mysql.jdbc.Driver");
	 		
	 		 	String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // DB이름인 book_ex를 적절히 변경 
	 	        String DB_User = "root";  // DB의 Userid와 pwd를 알맞게 변경 
	 	        String DB_PASSWORD = "rootpw"; 
	 	        
	 	        conn = DriverManager.getConnection(DB_URL, DB_User, DB_PASSWORD);
	 	        
	 	        //쿼리의 틀을 미리 생성해 놓고 값을 나중에 지정
	 	        pstmt = conn.prepareStatement(
	 	        		"select * from book_ex.user_info where USER_ID = ?");
	 	        // 필요한 값 지정 .
	 	        // u.USER_ID로 불러오는것 -> 말 없이 펜을 들고가는 것
	 	        // u.getUSER_ID로 불러오는 것 -> 야 펜좀줄래? 하는 것
//	 	        pstmt.setString(1, u.getPASSWORD());
//	 	        pstmt.setString(2, u.getNAME());
//	 	        pstmt.setString(3, u.getEMAIL());
	 	        pstmt.setString(1, userId);
	 	        // 쿼리를 실행하기 위한 메서드	 	        
	 	        rs = pstmt.executeQuery();
	 	        
	 	       while (rs.next()) { 
	 	          String user_id = rs.getString("USER_ID");
	 	          String passwd = rs.getString("PASSWORD");
	 	          String name = rs.getString("NAME");
	 	          String email = rs.getString("EMAIL");
	 	          u = new User(userId, passwd, name, email);
	 	         }
	 	 	} catch ( Exception e ) {
	 	       e.printStackTrace();
	 	     } finally {
	 		 if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
	 		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
	 		if(rs != null) try {rs.close();} catch(SQLException ex) {}
	 		 }
  
    	 	return u;

    	}
    
    static int updateUser(User u) { 

    	Connection conn = null;
	     // 생성
	     PreparedStatement pstmt = null;
	     int result = 0;
	 
	 	 try {	
	 		 
	 		 	Class.forName("com.mysql.jdbc.Driver");
	 		
	 		 	String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // DB이름인 book_ex를 적절히 변경 
	 	        String DB_User = "root";  // DB의 Userid와 pwd를 알맞게 변경 
	 	        String DB_PASSWORD = "rootpw"; 
	 	        
	 	        conn = DriverManager.getConnection(DB_URL, DB_User, DB_PASSWORD);
	 	        
	 	        //쿼리의 틀을 미리 생성해 놓고 값을 나중에 지정
	 	        pstmt = conn.prepareStatement(
	 	        		"update book_ex.user_info set PASSWORD = ?, NAME = ?, EMAIL = ? where USER_ID = ?");
	 	        // 필요한 값 지정 .
	 	        // u.USER_ID로 불러오는것 -> 말 없이 펜을 들고가는 것
	 	        // u.getUSER_ID로 불러오는 것 -> 야 펜좀줄래? 하는 것
	 	        pstmt.setString(1, u.getPASSWORD());
	 	        pstmt.setString(2, u.getNAME());
	 	        pstmt.setString(3, u.getEMAIL());
	 	        pstmt.setString(4, u.getUSER_ID());
	 	        // 쿼리를 실행하기 위한 메서드
	 	        pstmt.executeUpdate();
	 	        result = pstmt.getUpdateCount();
	 	 	} catch ( Exception e ) {
	 	       e.printStackTrace();
	 	     } finally {
	 		 if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
	 		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
	 		 }
	 	 
	 	 	return result;

    }
    
    static int insertUser(User u) { 
	// DB의 User_info테이블에 insert하는 메서드
	     
	     Connection conn = null;
	     // 생성
	     PreparedStatement pstmt = null;
	     int result = 0;
	 
	 	 try {	
	 		 
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
	 	        pstmt.setString(1, u.getUSER_ID());
	 	        pstmt.setString(2, u.getPASSWORD());
	 	        pstmt.setString(3, u.getNAME());
	 	        pstmt.setString(4, u.getEMAIL());
	 	        // 쿼리를 실행하기 위한 메서드
	 	        pstmt.executeUpdate();
	 	        result = pstmt.getUpdateCount();
	 	 	} catch ( Exception e ) {
	 	       e.printStackTrace();
	 	     } finally {
	 		 if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
	 		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
	 		 }
	 	 
	 	 	return result;
    }

} // end of class

class User {

	String USER_ID;
	String PASSWORD;
	String NAME;
	String EMAIL;
	Date IN_DATE;
	Date UP_DATE;
	
	public User(String uSER_ID, String pASSWORD, String nAME, String eMAIL) {
		super();
		USER_ID = uSER_ID;
		PASSWORD = pASSWORD;
		NAME = nAME;
		EMAIL = eMAIL;
	}

	@Override
	public String toString() {
		if(USER_ID != null) {
		return "User [USER_ID=" + USER_ID + ", PASSWORD=" + PASSWORD + ", NAME=" + NAME + ", EMAIL=" + EMAIL + "]";
		} else {
			return "없는 아이디입니다.";
		}
	}

	public String getUSER_ID() { // 데이터를 읽는 용 데이터를 받기만 함
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) { // 데이터에 접근해서 값을 바꿈. 이 메서드의 경우 user_id가 아니면 값을 넣지 않는 것임.
		USER_ID = uSER_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public Date getIN_DATE() {
		return IN_DATE;
	}

	public void setIN_DATE(Date iN_DATE) {
		IN_DATE = iN_DATE;
	}

	public Date getUP_DATE() {
		return UP_DATE;
	}

	public void setUP_DATE(Date uP_DATE) {
		UP_DATE = uP_DATE;
	}

}