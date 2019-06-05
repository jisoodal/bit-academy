package jdbc;

import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
     test_jdbc_connect();
    } // main()�� ��
   
    static void test_jdbc_connect() {
     String DB_URL = "jdbc:mysql://localhost:3306/book_ex?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC"; // �ѱ� ���ڵ� ���� ������ serverTimeZone = Asia ������ �����ؾ��� 
     String DB_USER = "root";  // DB�� userid�� pwd�� �˸°� ���� 
     String DB_PASSWORD = "rootpw"; 
     
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null;
     
     String query = "SELECT now()"; // �ý����� ��¥�� ����Ѵ�.
     try {
      // ����̹��� �ε��Ѵ�.
      Class.forName("com.mysql.jdbc.Driver"); // mysql.cj.jdbc -> �ֽŹ���
     
      conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); // �����ͺ��̽��� ������ �����Ѵ�.
      stmt = conn.createStatement();             // Statement�� �����´�.
      rs = stmt.executeQuery(query); // SQL���� �����Ѵ�.
      
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
