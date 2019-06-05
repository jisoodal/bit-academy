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
			
			System.out.println("상품코드 상품명 \t\t가격 제조사");
			System.out.println(
					"---------------------------------------------------");
			while(rs.next()) {
				String code = rs.getString("code"); // char나 varchar타입은 getString으로 받아오삼
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, name, price, maker);
			}
		} catch(ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다."+cnfe.getMessage());
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
