
import java.io.IOException;
import java.util.Scanner;

public class MainSungJukHash {

	// ������ �͵�!!
	static Scanner scanner = new Scanner(System.in);
	static SungJuk sungjuk = new SungJuk();

	public static void main(String[] args) {

		for (;;) {
			// 6�� �Է� ������ ���ѷ���!!
			try {
				menu();
			} catch (Exception e) {
				System.out.println("�����ͺ��̽� ���� ����!");
				e.printStackTrace();
			}
		}

	}

	public static void menu() throws Exception {

		System.out.println("***�޴�***");
		System.out.println("1. ���� �Է�");
		System.out.println("2. ���� ���");
		System.out.println("3. ���� ��ȸ");
		System.out.println("4. ���� ����");
		System.out.println("5. ���� ����");
		System.out.println("6. ���� ����\n");

		try {
			System.out.print("�޴� ����(1~6) =>");
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {

			case 1: {
				// HashMap�� �Ѿ�� �� ���
				input_sungjuk();
				break;
			}

			case 2:
				output_sungjuk();
				break;

			case 3:
				search_sungjuk();
				break;

			case 4:
				modify_sungjuk();
				break;

			case 5:
				remove_sungjuk();
				break;

			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);

			default:
				System.out.println("���� ��ȣ�Դϴ�.");
				break;
			}
		} catch (NumberFormatException nfe) {
			System.out.println("���ڸ� �Է����ּ���.\n");
		}

	}

	public static void input_sungjuk() {

		sungjuk.input();
	}

	public static void output_sungjuk() throws Exception {

		sungjuk.output_jdbc();
	}

	public static void search_sungjuk() throws Exception {

		String result = null;

		System.out.print("��ȸ�� �й� �Է� =>");

		String search = scanner.nextLine();

		sungjuk.select_jdbc(search);

	}

	public static void modify_sungjuk() throws Exception {

		int nKor = 0, nEng = 0, nMath = 0;

		System.out.print("������ �й� �Է� =>");

		String search = scanner.nextLine();

		System.out.print("���� ���� ����=>");
		nKor = Integer.parseInt(scanner.nextLine());

		System.out.print("���� ���� ����=>");
		nEng = Integer.parseInt(scanner.nextLine());

		System.out.print("���� ���� ����=>");
		nMath = Integer.parseInt(scanner.nextLine());

		sungjuk.update_jdbc(search, nKor, nEng, nMath);

	}

	public static void remove_sungjuk() throws Exception {

		System.out.print("������ �й� �Է� =>");

		String search = scanner.nextLine();

		sungjuk.delete_jdbc(search);

	}

}