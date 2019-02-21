// ctrl+space : 자동완성
// alt+up, down : 행이동
// ctrl+/ : 주석(toggle)
// ctrl+d : 한줄 삭제
// ctrl+shift+f : 자동 정렬
// ctrl+shift+o : 자동 import

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("두자리 정수를 하나 입력해주세요.>");
		String input = scanner.nextLine();
		int num = Integer.parseInt(input);

		System.out.println("입력내용 :" + input);
		System.out.printf("num=%d%n", num);
		System.out.printf("%n ㅎㅎ");
	}

}
