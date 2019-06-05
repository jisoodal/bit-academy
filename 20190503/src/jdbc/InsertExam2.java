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
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // �Է°�ü
			System.out.println("Member ���̺� �� �߰��ϱ�....");
			System.out.print("�й� �Է� : ");
			id = br.readLine();
			System.out.print("�̸� �Է�: ");
			name = br.readLine();
			System.out.print("�ּ� �Է� : ");
			addr = br.readLine();
			System.out.print("��ȭ��ȣ �Է� : ");
			phone = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url,"root","rootpw");
			
			pstmt = con.prepareStatement(sql); // �� �κ��� ������ ��� setString�� �ؾ����� �𸣱� ������ ������ �ȵ�.
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			pstmt.setString(4, phone);
			
			pstmt.executeUpdate();
			
			System.out.println("�����ͺ��̽� ���� ����!");
		}
		catch(Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!="+e.getMessage());
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
