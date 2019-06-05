package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertExam2 {
	
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url =
				"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;
		
		String sql = "Insert into member(id, name, addr, phone) Values(?,?,?,?)";
		String id, name, addr, phone;
		
		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력객체
			System.out.println("Member 테이블에 값 추가하기....");
			System.out.print("학번 입력 : ");
			id = br.readLine();
			System.out.print("이름 입력: ");
			name = br.readLine();
			System.out.print("주소 입력 : ");
			addr = br.readLine();
			System.out.print("전화번호 입력 : ");
			phone = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			pstmt = con.prepareStatement(sql); // 이 부분이 없으면 어디에 setString을 해야할지 모르기 때문에 없으면 안됨.
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone);
			
			pstmt.executeUpdate();
			
			System.out.println("데이터베이스 연결 성공!");
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!="+e.getMessage());
			e.printStackTrace();
		}
		
		finally {
			try {
//				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception ignored) {
			}
		}

	}

}
