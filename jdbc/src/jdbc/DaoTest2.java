package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoTest2 {
    public static void main(String[] args) {

     UserDao udao = UserDao.getInstance();

     List<User2> list2 = udao.selectAllUsers();
     System.out.println(list2);    

   }

}

class UserDao {
	
	static private UserDao instance = null;
	
	private UserDao() {
		
	}
 
	public static UserDao getInstance() {
		
		if(instance == null)
			instance = new UserDao();

			return instance;
	}
	
	static List<User2> selectAllUsers() {
    	
   	 Connection conn = null;
	     // 생성
	     PreparedStatement pstmt = null;
	     ResultSet rs = null;
	     List<User2> list2 = new ArrayList<User2>();
	     User2 u = null;
	 
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
	 	          list2.add(new User2(user_id, passwd, name, email));
	 	         }
	 	 	} catch ( Exception e ) {
	 	       e.printStackTrace();
	 	     } finally {
	 		 if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
	 		 if(conn != null) try {conn.close();} catch(SQLException ex) {}
	 		 }
   	
	 	 return list2;

   	}
}



class User2 {
	String USER_ID;
	String PASSWORD;
	String NAME;
	String EMAIL;
	Date IN_DATE;
	Date UP_DATE;
	
	public User2(String uSER_ID, String pASSWORD, String nAME, String eMAIL) {
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