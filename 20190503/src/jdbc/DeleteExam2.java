package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteExam2 {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = 
				"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String id;
		String sql = "Delete from member where id = ?";
		
		try {
			BufferedReader br = new BufferedReader (new
					InputStreamReader(System.in));
			System.out.println("Member ���̺� ���� �����ϱ�....");
			System.out.print("������ �й� �Է�: ");
			id = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			System.out.println("�����ͺ��̽� ���� ����!");
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!");
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
