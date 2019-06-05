package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample2 {
	public static void main(String args[]) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC",
					"root","rootpw");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select code, name, price, maker from goodsinfo;");
			
			System.out.println("��ǰ�ڵ� ��ǰ�� \t\t���� ������");
			System.out.println(
					"---------------------------------------------------");
			while(rs.next()) {
				String code = rs.getString("code"); // char�� varcharŸ���� getString���� �޾ƿ���
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, name, price, maker);
			}
		} catch(ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�."+cnfe.getMessage());
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		} 
		finally {
			try {
				stmt.close();
			}
			catch(Exception ignored) {	
			}
			try {
				conn.close();
			}
			catch (Exception ignored) {
			}
		}
	}
}
