package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTest3 {
    public static void main(String[] args) {
    	// Dao클래스를 작성하고 UserDao가 상속받도록 변경하시오
        UserDao2 udao2 = new UserDao2();

        List<User2> list3 = udao2.selectAllUsers();
        System.out.println(list3);
       
       } // main()의 끝

   } // 클래스의 끝



   class Dao {
    Connection conn;
    String tableName = "";
    List<User2> list3 = new ArrayList<User2>();
    User2 u = null;
    
    Dao() {
     this(null, "");
    }
    
    Dao(String tableName) {
     this(null, tableName );
    }
    
    Dao(Connection conn, String tableName) {
     this.tableName = tableName;
     this.conn = conn;
    }  
    
    void rollback(){
     if(conn!=null) {
      try {
       conn.rollback();
      } catch(SQLException e){
       
      }
     }
    }
    
    
    void close(AutoCloseable... acs) {
    	PreparedStatement pstmt = null;
    	if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
   }
    
}



   class UserDao2 extends Dao {
	   
	UserDao2(){
		super();
	}
	   
	UserDao2(Connection conn, String tableName) {
		   
		   super(conn,tableName);
	}
	   
	  List<User2> selectAllUsers() {
		  
		  tableName = "book_ex.user_info";
			     // 생성
			     PreparedStatement pstmt = null;
			     ResultSet rs = null;
			     List<User2> list3 = new ArrayList<User2>();
			     User2 u = null;
			 
			 	 try {	
			 		 
			 		 	Class.forName("com.mysql.jdbc.Driver");
			 		
			 		 	String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // DB이름인 book_ex를 적절히 변경 
			 	        String DB_User = "root";  // DB의 Userid와 pwd를 알맞게 변경 
			 	        String DB_PASSWORD = "rootpw"; 
			 	        
			 	        conn = DriverManager.getConnection(DB_URL, DB_User, DB_PASSWORD);
			 	        
			 	        //쿼리의 틀을 미리 생성해 놓고 값을 나중에 지정
			 	        pstmt = conn.prepareStatement(
			 	        		"select * from "+tableName);

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
			 	          list3.add(new User2(user_id, passwd, name, email));
			 	         }
			 	 	} catch ( Exception e ) {
			 	       e.printStackTrace();
			 	     } finally {
			 	    	close();
			 		 }
		   	
			 	 return list3;

		   	}

}
