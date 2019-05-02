package sungJukProgram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainSungJukHash {

	// ������ �͵�!!
	static HashMap<String, SungJuk> sungJukMap = new HashMap<String, SungJuk>(); // Object�� �ϸ� �Ź� ����ȯ �ؾߵǱ� ������ ���׸����� String SungJuk���� ��!!
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		for (;;) {
			// 6�� �Է� ������ ���ѷ���!!
			menu();
		}

	}

	public static void menu() {

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
				SungJuk sungjuk = input_sungjuk();
				sungJukMap.put(sungjuk.hakbun, sungjuk);
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

	public static SungJuk input_sungjuk() {

		SungJuk sungjuk = new SungJuk();

		// ���⼭ static���� sungjuk��ü�� ����� sungjuk�� �����ϱ� ������
		// ���� ������ ������ �Է��ص� ������ ���� ������ ��! ���� �Ź� ��ü�� ��������� ��.

		sungjuk.input();

		System.out.println("\n���� �Է� ����!!!\n");

		return sungjuk;

	}

	public static void output_sungjuk() {
		
		Set set = sungJukMap.entrySet();
		Iterator it = set.iterator();
		
		if (sungJukMap.isEmpty()) {
			System.out.println("\n����� �����Ͱ� �����ϴ�!!\n");
			return;
		}

		System.out.println("\t***����ǥ***\t");
		System.out.println("=================================================================");
		System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t���");
		System.out.println("=================================================================");

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(e.getValue());
		}

		System.out.println("=================================================================");
	}

	public static void search_sungjuk() {

		String result = null;

		System.out.print("��ȸ�� �й� �Է� =>");

		String search = scanner.nextLine();

		if (sungJukMap.containsKey(search)) {
			System.out.println(sungJukMap.get(search).getEach());
			return;
		}

		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");

	}

	public static void modify_sungjuk() {

		int nKor = 0, nEng = 0, nMath = 0;

		System.out.print("��ȸ�� �й� �Է� =>");

		String search = scanner.nextLine();

		if (sungJukMap.containsKey(search)) {
			System.out.print("������ ���� ���� =>");
			nKor = Integer.parseInt(scanner.nextLine());

			System.out.print("������ ���� ���� =>");
			nEng = Integer.parseInt(scanner.nextLine());

			System.out.print("������ ���� ���� =>");
			nMath = Integer.parseInt(scanner.nextLine());

			sungJukMap.get(search).kor = nKor;
			sungJukMap.get(search).eng = nEng;
			sungJukMap.get(search).math = nMath;

			return;
		}

		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");
	}

	public static void remove_sungjuk() {

		System.out.print("������ �й� �Է� =>");

		String search = scanner.nextLine();

		if (sungJukMap.containsKey(search)) {
			sungJukMap.remove(search);
			System.out.println("\n�����Ǿ����ϴ�.\n");

			return;
		}

		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");

	}

}