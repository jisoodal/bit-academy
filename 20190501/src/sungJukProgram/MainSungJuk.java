package sungJukProgram;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSungJuk {

	// ������ �͵�!!
	static ArrayList<SungJuk> sungJukList = new ArrayList<SungJuk>();
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
			// ArrayList�� �Ѿ�� �� ���
			sungJukList.add(input_sungjuk());
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
		}
		catch(NumberFormatException nfe) {
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
		
		System.out.println("\t***����ǥ\t");
		System.out.println("=================================================================");
		System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t���");
		System.out.println("=================================================================");
		
		for(int i=0;i<sungJukList.size();i++) {
			System.out.println(sungJukList.get(i).toString());
		}
		
		System.out.println("=================================================================");
	}
	
	
	public static void search_sungjuk() {
		
		String result = null;

		System.out.print("��ȸ�� �й� �Է� =>");

		String search = scanner.nextLine();
		
		for(int i=0;i<sungJukList.size();i++) {
			if(sungJukList.get(i).hakbun.equals(search)) {
				sungJukList.get(i).process();
				result = sungJukList.get(i).getEach();
				System.out.println(result);
				
				return;
			}
		}
		
		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");
		
	}
	
	public static void modify_sungjuk() {
	
		int nKor =0,
			nEng = 0,
			nMath = 0;

		System.out.print("��ȸ�� �й� �Է� =>");

		String search = scanner.nextLine();
		
		for(int i=0; i<sungJukList.size();i++) {
			if(sungJukList.get(i).hakbun.equals(search)) {
				System.out.print("������ ���� ���� =>");
				nKor = Integer.parseInt(scanner.nextLine());
				
				System.out.print("������ ���� ���� =>");
				nEng = Integer.parseInt(scanner.nextLine());
				
				System.out.print("������ ���� ���� =>");
				nMath = Integer.parseInt(scanner.nextLine());
				
				sungJukList.get(i).kor = nKor;
				sungJukList.get(i).eng = nEng;
				sungJukList.get(i).math = nMath;
				
				return;
			}
		}
		
		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");
	}
	
	public static void remove_sungjuk() {
		
		System.out.print("������ �й� �Է� =>");

		String search = scanner.nextLine();
		
		for(int i=0;i<sungJukList.size();i++) {
			if(sungJukList.get(i).hakbun.equals(search)) {
				sungJukList.remove(i);
				System.out.println("���� �Ϸ� !!!\n");
				return;
			}
		}
		
		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");
		
	}

}
