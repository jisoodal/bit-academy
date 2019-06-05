package oracleEX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SearchExam_CALL {

	public static void main(String[] args) {
		String driver =
				"oracle.jdbc.driver.OracleDriver";
		String url =
				"jdbc:oracle:thin:@127.0.0.1:1522:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		//String sql = "Select * From member";
		
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "1234");
			
			System.out.print("조회할 학번 입력: ");
			String id = br.readLine();
			
			cstmt = con.prepareCall("{call call_search(?,?,?,?)}");
			// 첫 번째 물음표 = 입력용(in으로 전달받은 파라미터). 나머지 = 출력용(out으로 전달받은 파라미터) 
			cstmt.setString(1, id);
			cstmt.registerOutParameter(1, Types.VARCHAR); // 문자 타입이라 VARCHAR
			cstmt.registerOutParameter(2, Types.VARCHAR);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			
			cstmt.executeQuery();
			
			System.out.println();
			
			System.out.println("id\tname\taddr\tphone");
			
			System.out.println("-------------------------------------------");
			
			System.out.print(cstmt.getString(1) + "\t");
			System.out.print(cstmt.getString(2) + "\t");
			System.out.print(cstmt.getString(3) + "\t");
			System.out.println(cstmt.getString(4) + "\t");
			
			System.out.println("-------------------------------------------");
		} 
		catch(SQLException sqle) {
			System.out.println("없는 학번입니다.");
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패 ! =");
			e.printStackTrace();
		}
		finally {
			try {
				if(con != null) con.close();
				if(cstmt != null) cstmt.close();
				if(rs != null) rs.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
