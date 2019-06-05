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

		System.out.println("1. 제품정보 입력");
		System.out.println("2. 제품정보 출력");
		System.out.println("3. 제품정보 조회");
		System.out.println("4. 제품정보 수정");
		System.out.println("5. 제품정보 삭제");
		System.out.println("6. 프로그램 종료\n");

		try {
			
			System.out.print("메뉴선택(1~6) =>");

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
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}

			default:
				System.out.println("\n1~6사이 숫자를 입력하세요.\n");
				break;
			}
		} catch (NumberFormatException nfe) {
			System.out.println("숫자만 입력해주세요\n");
		}
	}
	
	public static PanMaeMap input_product() {
		
		PanMaeMap inputPanMae = new PanMaeMap();
		
		inputPanMae.input();
		
		System.out.println("\n상품 입력 성공!!\n");
		
		return inputPanMae;
		
	}
	
	public static void output_product() {

		Set set = panMaeMap.entrySet();
		Iterator it = set.iterator();
		
		if (panMaeMap.isEmpty()) {
			System.out.println("\n출력할 데이터가 없습니다!!\n");
			return;
		}

		System.out.println();
		System.out.println("==================================");
		System.out.println("제품코드\t제품명\t단가\t수량\t금액");
		System.out.println("==================================");

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println(e.getValue());
			// 프린트 안에 객체를 넣으면 자동으로 toString이 호출되어서 나온다. 프린트 함수에 담는 순간 자동 호출되어서 나옴.
			// 객체가 어떻게 출력되고 싶은지에 따라서 오버라이딩 해야한다.
		
		}

		System.out.println("==================================\n");	
		
	}
	
	public static void search_product() {
		
		String search = null;

		System.out.print("\n검색할 상품의 제품코드를 입력하세요:");
		search = scanner.nextLine();
		System.out.println();
		
		if(panMaeMap.containsKey(search)) {
			panMaeMap.get(search).printEach();
			return;
		}
		
		System.out.println("존재하지 않는 제품코드입니다.");
		
	}
	
	public static void modify_product() {
		
		String search = null;

		System.out.print("\n변경할 상품의 제품코드를 입력하세요:");
		search = scanner.nextLine();
		System.out.println();
		
		if(panMaeMap.containsKey(search)) {
			panMaeMap.get(search).modify();
			return;
		}
		
		System.out.println("존재하지 않는 제품코드입니다.");
		
	}
	
	public static void delete_product() {
		
		String search = null;

		System.out.print("\n삭제할 상품의 제품코드를 입력하세요:");
		search = scanner.nextLine();
		System.out.println();
		
		if(panMaeMap.containsKey(search)) {
			panMaeMap.remove(search);
			return;
		}
		
		System.out.println("존재하지 않는 제품코드입니다.");
		
	}

}
