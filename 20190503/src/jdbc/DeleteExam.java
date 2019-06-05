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
			System.out.println("Member ���̺� ���� �����ϱ�....");
			System.out.print("������ �й� �Է�: ");
			id = br.readLine();
			
			String sql = "Delete from member where id = '"+id+"'";
			
			System.out.println(sql);
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("�����ͺ��̽� ���� ����!");
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
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
