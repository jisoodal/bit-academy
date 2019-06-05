package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectExam2 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url =
				"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String id;
		String sql = "Select * from member where id = ?";
		
		try {
			
			BufferedReader br = new BufferedReader(new
					InputStreamReader(System.in));
			System.out.println("Member 테이블 내용 조회하기....");
			System.out.print("조회할 학번 임력: ");
			id = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
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
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception ignored) {
			}
		}

	}

}
