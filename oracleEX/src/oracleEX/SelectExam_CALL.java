package oracleEX;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import oracle.jdbc.OracleTypes;

public class SelectExam_CALL {

	public static void main(String[] args) {
		String driver =
				"oracle.jdbc.driver.OracleDriver";
		String url =
				"jdbc:oracle:thin:@127.0.0.1:1522:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","1234");
			
			cstmt = con.prepareCall("{call call_select(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			
			rs = (ResultSet) cstmt.getObject(1);
			// System.out.println("rs=" + rs);
			
			System.out.println("id\tname\taddr\tphone");
			
			System.out.println("-------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString("id")+"\t");
				System.out.println(rs.getString("name")+"\t");
				System.out.println(rs.getString("addr")+"\t");
				System.out.println(rs.getString("phone")+"\t");
			}
			System.out.println("-------------------------------------");
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
