package panMae;

import java.util.ArrayList;
import java.util.Scanner;

public class PanMaeArrEx {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<PanMaeArr> panMaeList = new ArrayList<PanMaeArr>();

	public static void main(String[] args) {

		while (true) {
			menu();
		}

	}

	public static void menu() {

		int choice = 0;

		System.out.println("1. ��ǰ���� �Է�");
		System.out.println("2. ��ǰ���� ���");
		System.out.println("3. ��ǰ���� ��ȸ");
		System.out.println("4. ��ǰ���� ����");
		System.out.println("5. ��ǰ���� ����");
		System.out.println("6. ���α׷� ����\n");

		try {
			
			System.out.print("�޴�����(1~6) =>");

			choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {

			case 1:
				panMaeList.add(input_product());
				break;

			case 2:
				output_product();
				break;

			case 3:
				search_product();
				break;

			case 4:
				modify_product();
				break;

			case 5:
				delete_product();
				break;

			case 6: {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			}

			default:
				System.out.println("\n1~6���� ���ڸ� �Է��ϼ���.\n");
				break;
			}
		} catch (NumberFormatException nfe) {
			System.out.println("���ڸ� �Է����ּ���\n");
		}
	}

	public static PanMaeArr input_product() {

		PanMaeArr panmae = new PanMaeArr();

		panmae.input();

		return panmae;

	}

	public static void output_product() {

		System.out.println("==================================");
		System.out.println("��ǰ�ڵ�\t��ǰ��\t�ܰ�\t����\t�ݾ�");
		System.out.println("==================================");

		for (int i = 0; i < panMaeList.size(); i++) {
			panMaeList.get(i).output();
		}

		System.out.println();

	}

	public static void search_product() {

		String search = null;

		System.out.print("\n�˻��� ��ǰ�� ��ǰ�ڵ带 �Է��ϼ���:");
		search = scanner.nextLine();
		System.out.println();

		for (int i = 0; i < panMaeList.size(); i++) {
			if (panMaeList.get(i).code.equals(search)) {
				panMaeList.get(i).printEach();
				System.out.println();

				return;
			}
		}

		System.out.println("\n��ġ�ϴ� ��ǰ�ڵ尡 �����ϴ�.\n");

	}

	public static void modify_product() {

		String search = null;

		System.out.print("\n������ ��ǰ�� ��ǰ�ڵ带 �Է��ϼ���:");
		search = scanner.nextLine();
		System.out.println();

		for (int i = 0; i < panMaeList.size(); i++) {
			if (panMaeList.get(i).code.equals(search)) {
				panMaeList.get(i).modify();

				System.out.println("���������� ����Ǿ����ϴ�.\n");

				return;
			}
		}
	}

	public static void delete_product() {

		String search = null;

		System.out.print("\n������ ��ǰ�� ��ǰ�ڵ带 �Է��ϼ���:");
		search = scanner.nextLine();
		System.out.println();

		for (int i = 0; i < panMaeList.size(); i++) {
			if (panMaeList.get(i).code.equals(search)) {
				panMaeList.remove(i);

				System.out.println("���������� �����Ǿ����ϴ�.\n");

				return;
			}
		}

	}

}
