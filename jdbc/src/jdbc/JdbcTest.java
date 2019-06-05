package jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
     test_jdbc_connect();
    } // main()의 끝
   
    static void test_jdbc_connect() {
     String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // 한글 인코딩 문제 때문에 serverTimeZone = Asia 등으로 변경해야함 
     String DB_USER = "root";  // DB의 userid와 pwd를 알맞게 변경 
     String DB_PASSWORD = "rootpw"; 
     
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     
     String query = "SELECT now()"; // 시스템의 날짜를 출력한다.
     try {
      // 드라이버를 로딩한다.
      Class.forName("com.mysql.jdbc.Driver"); // mysql.cj.jdbc -> 최신버전
     
      conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // 데이터베이스의 연결을 설정한다.
      stmt = conn.createStatement();             // Statement를 가져온다.
      rs = stmt.executeQuery(query); // SQL문을 실행한다.
      
      while (rs.next()) { 
       String curDate = rs.getString(1);
       System.out.println(curDate); 
      }
     } catch ( Exception e ) {
      e.printStackTrace();
     } finally {
      try {
       rs.close();
       stmt.close();
       conn.close();
      } catch ( SQLException e ) {}
     }
    }

}
