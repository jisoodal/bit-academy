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

	public static PanMaeArr input_product() {

		PanMaeArr panmae = new PanMaeArr();

		panmae.input();

		return panmae;

	}

	public static void output_product() {

		System.out.println("==================================");
		System.out.println("제품코드\t제품명\t단가\t수량\t금액");
		System.out.println("==================================");

		for (int i = 0; i < panMaeList.size(); i++) {
			panMaeList.get(i).output();
		}

		System.out.println();

	}

	public static void search_product() {

		String search = null;

		System.out.print("\n검색할 상품의 제품코드를 입력하세요:");
		search = scanner.nextLine();
		System.out.println();

		for (int i = 0; i < panMaeList.size(); i++) {
			if (panMaeList.get(i).code.equals(search)) {
				panMaeList.get(i).printEach();
				System.out.println();

				return;
			}
		}

		System.out.println("\n일치하는 제품코드가 없습니다.\n");

	}

	public static void modify_product() {

		String search = null;

		System.out.print("\n변경할 상품의 제품코드를 입력하세요:");
		search = scanner.nextLine();
		System.out.println();

		for (int i = 0; i < panMaeList.size(); i++) {
			if (panMaeList.get(i).code.equals(search)) {
				panMaeList.get(i).modify();

				System.out.println("정상적으로 변경되었습니다.\n");

				return;
			}
		}
	}

	public static void delete_product() {

		String search = null;

		System.out.print("\n삭제할 상품의 제품코드를 입력하세요:");
		search = scanner.nextLine();
		System.out.println();

		for (int i = 0; i < panMaeList.size(); i++) {
			if (panMaeList.get(i).code.equals(search)) {
				panMaeList.remove(i);

				System.out.println("정상적으로 삭제되었습니다.\n");

				return;
			}
		}

	}

}
