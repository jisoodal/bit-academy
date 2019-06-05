package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteExam {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = 
				"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = null;
		Statement stmt = null;
		
		String id;
		
		try {
			BufferedReader br = new BufferedReader (new
					InputStreamReader(System.in));
			System.out.println("Member 테이블 내용 삭제하기....");
			System.out.print("삭제할 학번 입력: ");
			id = br.readLine();
			
			String sql = "Delete from member where id = '"+id+"'";
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("데이터베이스 연결 성공!");
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		
		finally {
			try {
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			}
			catch(Exception ignored) {
			}
		}

	}

}
