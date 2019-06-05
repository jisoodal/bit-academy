
import java.io.IOException;
import java.util.Scanner;

public class MainSungJukHash {

	// 공유할 것들!!
	static Scanner scanner = new Scanner(System.in);
	static SungJuk sungjuk = new SungJuk();

	public static void main(String[] args) {

		for (;;) {
			// 6번 입력 전까지 무한루프!!
			try {
				menu();
			} catch (Exception e) {
				System.out.println("데이터베이스 연결 실패!");
				e.printStackTrace();
			}
		}

	}

	public static void menu() throws Exception {

		System.out.println("***메뉴***");
		System.out.println("1. 성적 입력");
		System.out.println("2. 성적 출력");
		System.out.println("3. 성적 조회");
		System.out.println("4. 성적 수정");
		System.out.println("5. 성적 삭제");
		System.out.println("6. 성적 종료\n");

		try {
			System.out.print("메뉴 선택(1~6) =>");
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {

			case 1: {
				// HashMap에 넘어온 값 담기
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
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("없는 번호입니다.");
				break;
			}
		} catch (NumberFormatException nfe) {
			System.out.println("숫자를 입력해주세요.\n");
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

		System.out.print("조회할 학번 입력 =>");

		String search = scanner.nextLine();

		sungjuk.select_jdbc(search);

	}

	public static void modify_sungjuk() throws Exception {

		int nKor = 0, nEng = 0, nMath = 0;

		System.out.print("수정할 학번 입력 =>");

		String search = scanner.nextLine();

		System.out.print("국어 성적 수정=>");
		nKor = Integer.parseInt(scanner.nextLine());

		System.out.print("엉어 성적 수정=>");
		nEng = Integer.parseInt(scanner.nextLine());

		System.out.print("수학 성적 수정=>");
		nMath = Integer.parseInt(scanner.nextLine());

		sungjuk.update_jdbc(search, nKor, nEng, nMath);

	}

	public static void remove_sungjuk() throws Exception {

		System.out.print("삭제할 학번 입력 =>");

		String search = scanner.nextLine();

		sungjuk.delete_jdbc(search);

	}

}