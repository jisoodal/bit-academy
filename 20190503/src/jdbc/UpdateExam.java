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
			System.out.println("Member ���̺� ���� �����ϱ�....");
			System.out.print("�й� �ӷ�: ");
			id = br.readLine();
			System.out.print("������ �ּ� �Է�: ");
			addr = br.readLine();
			System.out.print("������ ��ȭ��ȣ �Է�: ");
			phone = br.readLine();
			
			String sql = "Update member Set addr = '"+addr;
			sql += "', phone = '"+phone+"' where id = '"+id+"'";
			// +=�� �ϴ� ������ addr�� �Է��ϴ� �κ��� �ʹ� �� �� �������� ������ ������ ó�� sql�� �ڿ� �����شٴ� ������ +=�� ��
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("�����ͺ��̽� ���� ����!");
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ���� !");
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
