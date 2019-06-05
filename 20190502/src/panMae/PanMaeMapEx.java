package panMae;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PanMaeMapEx {
	
	static Scanner scanner = new Scanner(System.in);
	static HashMap<String,PanMaeMap> panMaeMap = new HashMap<String,PanMaeMap>();

	public static void main(String[] args) {
		
		while(true) {
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

			case 1:{
				PanMaeMap getMap = input_product();
				
				panMaeMap.put(getMap.code, getMap);
				break;
			}

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
	
	public static PanMaeMap input_product() {
		
		PanMaeMap inputPanMae = new PanMaeMap();
		
		inputPanMae.input();
		
		System.out.println("\n��ǰ �Է� ����!!\n");
		
		return inputPanMae;
		
	}
	
	public static void output_product() {

		Set set = panMaeMap.entrySet();
		Iterator it = set.iterator();
		
		if (panMaeMap.isEmpty()) {
			System.out.println("\n����� �����Ͱ� �����ϴ�!!\n");
			return;
		}

		System.out.println();
		System.out.println("==================================");
		System.out.println("��ǰ�ڵ�\t��ǰ��\t�ܰ�\t����\t�ݾ�");
		System.out.println("==================================");

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(e.getValue());
			// ����Ʈ �ȿ� ��ü�� ������ �ڵ����� toString�� ȣ��Ǿ ���´�. ����Ʈ �Լ��� ��� ���� �ڵ� ȣ��Ǿ ����.
			// ��ü�� ��� ��µǰ� �������� ���� �������̵� �ؾ��Ѵ�.
		
		}

		System.out.println("==================================\n");	
		
	}
	
	public static void search_product() {
		
		String search = null;

		System.out.print("\n�˻��� ��ǰ�� ��ǰ�ڵ带 �Է��ϼ���:");
		search = scanner.nextLine();
		System.out.println();
		
		if(panMaeMap.containsKey(search)) {
			panMaeMap.get(search).printEach();
			return;
		}
		
		System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�.");
		
	}
	
	public static void modify_product() {
		
		String search = null;

		System.out.print("\n������ ��ǰ�� ��ǰ�ڵ带 �Է��ϼ���:");
		search = scanner.nextLine();
		System.out.println();
		
		if(panMaeMap.containsKey(search)) {
			panMaeMap.get(search).modify();
			return;
		}
		
		System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�.");
		
	}
	
	public static void delete_product() {
		
		String search = null;

		System.out.print("\n������ ��ǰ�� ��ǰ�ڵ带 �Է��ϼ���:");
		search = scanner.nextLine();
		System.out.println();
		
		if(panMaeMap.containsKey(search)) {
			panMaeMap.remove(search);
			return;
		}
		
		System.out.println("�������� �ʴ� ��ǰ�ڵ��Դϴ�.");
		
	}

}
