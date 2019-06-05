import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SungJuk {

	String hakbun, name, grade;
	int kor, eng, math, total;
	double avg;

	static Scanner scanner = new Scanner(System.in);

	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/sqldb?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
	static Connection con = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public void input() {
		// �й�, �̸�, ����, ����, ���� �Է� �޴� �޼���

		System.out.print("�й� �Է� =>");
		hakbun = scanner.nextLine();

		System.out.print("�̸� �Է� =>");
		name = scanner.nextLine();

		System.out.print("����  �Է� =>");
		kor = Integer.parseInt(scanner.nextLine());

		System.out.print("���� �Է� =>");
		eng = Integer.parseInt(scanner.nextLine());

		System.out.print("���� �Է� =>");
		math = Integer.parseInt(scanner.nextLine());

		process();

		input_jdbc();

		// ���� �κ�
	}

	public void process() {
		// ����, ���, ��� ����ϴ� �޼���

		// ���� ���
		total = kor + eng + math;

		// ��� ���
		avg = total / 3;

		// ��� ���
		switch ((int) avg / 10) {

		case 10:
		case 9:
			grade = "A";
			break;

		case 8:
			grade = "B";
			break;

		case 7:
			grade = "C";
			break;

		case 6:
			grade = "D";
			break;

		default:
			grade = "F";
			break;

		}
	}

	public void input_jdbc() {

		String sql = "Insert into sungJuk(id, name, grade, kor, eng, math, total, avg) Values(?,?,?,?,?,?,?,?)";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "rootpw");

			pstmt = con.prepareStatement(sql); // �� �κ��� ������ ��� setString�� �ؾ����� �𸣱� ������ ������ �ȵ�.
			pstmt.setString(1, this.hakbun);
			pstmt.setString(2, this.name);
			pstmt.setString(3, this.grade);
			pstmt.setInt(4, this.kor);
			pstmt.setInt(5, this.eng);
			pstmt.setInt(6, this.math);
			pstmt.setInt(7, this.total);
			pstmt.setDouble(8, this.avg);

			pstmt.executeUpdate();

			System.out.println("\n���� �Է� ����!!!\n");
			System.out.println("�����ͺ��̽� ���� ����!");
		} catch (SQLException sqle) {
			System.out.println("�̹� �����ϴ� �й��Դϴ�.");
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����!=" + e.getMessage());
			e.printStackTrace();
		}

	}

	public void output_jdbc() throws SQLException, ClassNotFoundException {

		String sql = "Select * from sungJuk";

		Class.forName(driver);
		con = DriverManager.getConnection(url, "root", "rootpw");

		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();

		System.out.println("===========================================================");
		System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t���");
		System.out.println("===========================================================");

		while (rs.next()) {
			System.out.print(rs.getString("id") + "\t");
			System.out.print(rs.getString("name") + "\t");
			System.out.print(rs.getString("kor") + "\t");
			System.out.print(rs.getString("eng") + "\t");
			System.out.print(rs.getString("math") + "\t");
			System.out.print(rs.getString("total") + "\t");
			System.out.print(rs.getString("avg") + "\t");
			System.out.print(rs.getString("grade") + "\t");
			System.out.println();
		}
		System.out.println("===========================================================");

		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}

	public void delete_jdbc(String id) throws SQLException, ClassNotFoundException {
		
			String sql = "Delete from sungJuk where id = ?";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "rootpw");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int res = pstmt.executeUpdate();
			if (res == 1) {
			System.out.println("�����ͺ��̽� ���� ����!");
			}
			else {
				System.out.println("�������� �ʴ� �й��Դϴ�!!!");
			}

			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

	}

	public void update_jdbc(String id, int kor, int eng, int math) throws SQLException, ClassNotFoundException {
			
		String sql = "Update sungJuk Set kor = ? ,eng = ? ,math = ? where id = ?";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "rootpw");

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kor);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, math);
			pstmt.setString(4, id);
			int res = pstmt.executeUpdate();
			if (res == 1) {
			System.out.println("�����ͺ��̽� ���� ����!");
			}
			else {
				System.out.println("�������� �ʴ� �й��Դϴ�!!!");
			}

			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

	}

	public void select_jdbc(String id) throws SQLException, ClassNotFoundException {

			String sql = "Select * from sungJuk where id = ?";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "rootpw");

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			System.out.println("===========================================================");
			System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t���");
			System.out.println("===========================================================");

			while (rs.next()) {
				System.out.print(rs.getString("id") + "\t");
				System.out.print(rs.getString("name") + "\t");
				System.out.print(rs.getString("kor") + "\t");
				System.out.print(rs.getString("eng") + "\t");
				System.out.print(rs.getString("math") + "\t");
				System.out.print(rs.getString("total") + "\t");
				System.out.print(rs.getString("avg") + "\t");
				System.out.print(rs.getString("grade") + "\t");
				System.out.println();
			}
			System.out.println("===========================================================");

			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
	}

	public boolean find_id(String id) throws SQLException, ClassNotFoundException {

		try {
			String sql = "Select * from sungJuk";

			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "rootpw");

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if (!(rs.getString("id").equals(id)))
					throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("\n�������� �ʴ� �й��Դϴ�.\n");
			return false;
		}

		return true;
	}
}
