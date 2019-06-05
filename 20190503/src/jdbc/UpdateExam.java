package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateExam {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url =
				"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = null;
		Statement stmt = null;
		
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
			
			String sql = "Update member Set addr = '"+addr;
			sql += "', phone = '"+phone+"' where id = '"+id+"'";
			// +=를 하는 이유는 addr를 입력하는 부분이 너무 길어서 두 문장으로 나웠기 때문에 처음 sql문 뒤에 더해준다는 뜻으로 +=를 씀
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("데이터베이스 연결 성공!");
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패 !");
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
