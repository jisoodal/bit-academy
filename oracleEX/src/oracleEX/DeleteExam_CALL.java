package oracleEX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class DeleteExam_CALL {

	public static void main(String[] args) {
		String driver =
				"oracle.jdbc.driver.OracleDriver";
		String url =
				"jdbc:oracle:thin:@127.0.0.1:1522:orcl";
		Connection con = null;
		CallableStatement cstmt = null;
		
		String id;
		
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.println("Member ���̺� �� �����ϱ�.....");
			System.out.print("�й� �Է�: ");
			id = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,"scott","1234");
			
			cstmt = con.prepareCall("{call call_delete(?)}");
			cstmt.setString(1, id);
			cstmt.executeUpdate();
			
			System.out.println("�����ͺ��̽� ���� ����!");
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� : =" +e.getMessage());
		}
		finally {
			try {
				if(con != null) con.close();
				if(cstmt != null) cstmt.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
