package sungJukProgram;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSungJuk {

	// 공유할 것들!!
	static ArrayList<SungJuk> sungJukList = new ArrayList<SungJuk>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		for (;;) {
			// 6번 입력 전까지 무한루프!!
			menu();
		}

	}

	public static void menu() {
		
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
			// ArrayList에 넘어온 값 담기
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
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			
		default:
			System.out.println("없는 번호입니다.");
			break;
		}
		}
		catch(NumberFormatException nfe) {
			System.out.println("숫자를 입력해주세요.\n");
		}
		
	}

	public static SungJuk input_sungjuk() { 
		
		SungJuk sungjuk = new SungJuk();
		// 여기서 static으로 sungjuk객체를 만들면 sungjuk을 공유하기 때문에
		// 내가 여러번 성적을 입력해도 마지막 값만 저장이 됨! 따라서 매번 객체를 생성해줘야 함.

		sungjuk.input();

		System.out.println("\n성적 입력 성공!!!\n");

		return sungjuk;

	}
	
	public static void output_sungjuk() {
		
		System.out.println("\t***성적표\t");
		System.out.println("=================================================================");
		System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("=================================================================");
		
		for(int i=0;i<sungJukList.size();i++) {
			System.out.println(sungJukList.get(i).toString());
		}
		
		System.out.println("=================================================================");
	}
	
	
	public static void search_sungjuk() {
		
		String result = null;

		System.out.print("조회할 학번 입력 =>");

		String search = scanner.nextLine();
		
		for(int i=0;i<sungJukList.size();i++) {
			if(sungJukList.get(i).hakbun.equals(search)) {
				sungJukList.get(i).process();
				result = sungJukList.get(i).getEach();
				System.out.println(result);
				
				return;
			}
		}
		
		System.out.println("일치하는 학번이 없습니다.\n");
		
	}
	
	public static void modify_sungjuk() {
	
		int nKor =0,
			nEng = 0,
			nMath = 0;

		System.out.print("조회할 학번 입력 =>");

		String search = scanner.nextLine();
		
		for(int i=0; i<sungJukList.size();i++) {
			if(sungJukList.get(i).hakbun.equals(search)) {
				System.out.print("수정할 국어 성적 =>");
				nKor = Integer.parseInt(scanner.nextLine());
				
				System.out.print("수정할 영어 성적 =>");
				nEng = Integer.parseInt(scanner.nextLine());
				
				System.out.print("수정할 수학 성적 =>");
				nMath = Integer.parseInt(scanner.nextLine());
				
				sungJukList.get(i).kor = nKor;
				sungJukList.get(i).eng = nEng;
				sungJukList.get(i).math = nMath;
				
				return;
			}
		}
		
		System.out.println("일치하는 학번이 없습니다.\n");
	}
	
	public static void remove_sungjuk() {
		
		System.out.print("삭제할 학번 입력 =>");

		String search = scanner.nextLine();
		
		for(int i=0;i<sungJukList.size();i++) {
			if(sungJukList.get(i).hakbun.equals(search)) {
				sungJukList.remove(i);
				System.out.println("삭제 완료 !!!\n");
				return;
			}
		}
		
		System.out.println("일치하는 학번이 없습니다.\n");
		
	}

}
