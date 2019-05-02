package sungJukProgram;

import java.util.HashMap;
import java.util.Scanner;

public class MainSungJukHash {

	// ������ �͵�!!
	static HashMap<String,Object> sungJukHash = new HashMap<String,Object>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		for (;;) {
			// 6�� �Է� ������ ���ѷ���!!
			menu();
		}

	}

	public static void menu() {
		
		SungJuk sungjuk = new SungJuk();
		
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
			sungJukHash.put(sungjuk.hakbun,input_sungjuk());
			break;
		}

		case 2:
			output_sungjuk();
			break;

//		case 3:
//			search_sungjuk();
//			break;
//
//		case 4:
//			modify_sungjuk();
//			break;
//
//		case 5:
//			remove_sungjuk();
//			break;

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
		
		SungJuk sungjuk = new SungJuk();
		
		System.out.println("\t***����ǥ\t");
		System.out.println("=================================================================");
		System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t���");
		System.out.println("=================================================================");
		
//		for(int i=0;i<sungJukHash.size();i++) {
//			System.out.println(sungJukHash.get(sungjuk.hakbun));
//		}
		
		for( String key : sungJukHash.keySet()) {
			System.out.println(sungJukHash.get(sungjuk.hakbun));
			System.out.println(sungJukHash.size());
		}

		
		System.out.println("=================================================================");
	}
	
	
//	public static void search_sungjuk() {
//		
//		String result = null;
//
//		System.out.print("��ȸ�� �й� �Է� =>");
//
//		String search = scanner.nextLine();
//		
//		for(int i=0;i<sungJukHash.size();i++) {
//			if(sungJukHash.get(i).hakbun.equals(search)) {
//				sungJukHash.get(i).process();
//				result = sungJukHash.get(i).toString();
//				System.out.println(result);
//				
//				return;
//			}
//		}
//		
//		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");
//		
//	}
//	
//	public static void modify_sungjuk() {
//	
//		int nKor =0,
//			nEng = 0,
//			nMath = 0;
//
//		System.out.print("��ȸ�� �й� �Է� =>");
//
//		String search = scanner.nextLine();
//		
//		for(int i=0; i<sungJukHash.size();i++) {
//			if(sungJukHash.get(i).hakbun.equals(search)) {
//				System.out.print("������ ���� ���� =>");
//				nKor = Integer.parseInt(scanner.nextLine());
//				
//				System.out.print("������ ���� ���� =>");
//				nEng = Integer.parseInt(scanner.nextLine());
//				
//				System.out.print("������ ���� ���� =>");
//				nMath = Integer.parseInt(scanner.nextLine());
//				
//				sungJukHash.get(i).kor = nKor;
//				sungJukHash.get(i).eng = nEng;
//				sungJukHash.get(i).math = nMath;
//				
//				return;
//			}
//		}
//		
//		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");
//	}
//	
//	public static void remove_sungjuk() {
//		
//		System.out.print("������ �й� �Է� =>");
//
//		String search = scanner.nextLine();
//		
//		for(int i=0;i<sungJukHash.size();i++) {
//			if(sungJukHash.get(i).hakbun.equals(search)) {
//				sungJukHash.remove(i);
//				System.out.println("���� �Ϸ� !!!\n");
//				return;
//			}
//		}
//		
//		System.out.println("��ġ�ϴ� �й��� �����ϴ�.\n");
//		
//	}

}