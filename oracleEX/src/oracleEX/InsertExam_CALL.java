package oracleEX;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class InsertExam_CALL {

	public static void main(String[] args) {
		String driver =
				 "oracle.jdbc.driver.OracleDriver";
		String url =
				"jdbc:oracle:thin:@127.0.0.1:1522:orcl";
		Connection con  = null;
		CallableStatement cstmt = null;
		
		String sql = "Insert into member (id, name, addr, phone) Values(?,?,?,?)";
		String id, name, addr, phone;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Member ���̺� �� �߰��ϱ�.....");
			System.out.print("�й� �Է�: ");
			id = br.readLine();
			System.out.print("�̸� �Է�: ");
			name = br.readLine();
			System.out.print("�ּ� �Է�: ");
			addr = br.readLine();
			System.out.print("��ȭ��ȣ �Է�: ");
			phone = br.readLine();
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "1234");
			
			cstmt = con.prepareCall("{call call_insert(?,?,?,?)}");
			cstmt.setString(1, id);
			cstmt.setString(2, name);
			cstmt.setString(3, addr);
			cstmt.setString(4, phone);
			cstmt.executeUpdate();
			
			System.out.println("�����ͺ��̽� ���� ����!");
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� ! = "+e.getMessage());
		}
		finally {
			try {
				if(con != null) con.close();
				if(cstmt != null) cstmt.close();
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

}
