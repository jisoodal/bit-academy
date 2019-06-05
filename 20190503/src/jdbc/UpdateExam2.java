package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateExam2 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url =
				"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "Update member Set addr = ?,phone = ? where id = ?";
		
		String id, addr, phone;
		
		try {
			BufferedReader br = new BufferedReader(new
					InputStreamReader(System.in));
			System.out.println("Member 테이블 내용 변경하기....");
			System.out.print("학번 임력: ");
			id = br.readLine();
			System.out.print("변경할 주소 입력: ");
			addr = br.readLine();
			System.out.print("변경할 전화번호 입력: ");
			phone = br.readLine();

			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, addr);
			pstmt.setString(2, phone);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			System.out.println("데이터베이스 연결 성공!");
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패 !");
			e.printStackTrace();
		}
		
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception ignored) {
			}
		}

	}

}
