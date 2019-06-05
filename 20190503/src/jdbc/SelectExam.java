package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExam {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url =
				"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "Select * from member";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("id\tname\taddr\tphone");
			
			System.out.println("------------------------------------------------");
			
			while(rs.next()) {
				System.out.print(rs.getString("id")+"\t");
				System.out.print(rs.getString("name")+"\t");
				System.out.print(rs.getString("addr")+"\t");
				System.out.print(rs.getString("phone")+"\t");
				System.out.println();
			}

		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		
		finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}
			catch(Exception ignored) {
			}
		}

	}

}
