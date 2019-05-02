package nDay01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerPractice {

	static String before = null, after = null, result = null;

	public static void main(String[] args) {
		
		calculate();
	}

	public static void calculate() {

		Scanner scanner = new Scanner(System.in);

		for (;;) {
			System.out.print("수식 입력 =>");
			StringTokenizer stok = new StringTokenizer(scanner.nextLine(), "*+-/", true); // 입력받고 -> 각각의 수식자를 -> 토큰으로
																							// 구분한다
			try {
				while (stok.hasMoreTokens()) {
					String token = stok.nextToken();
					// 앞에 변수에 token 입력 받음

					if(token.equals("exit"))
						System.exit(0);

					else if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")) {

						after = stok.nextToken();

						if (token.equals("*")) {
							before = (Integer.parseInt(before) * Integer.parseInt(after)) + "";
						}

						else if (token.equals("+")) {
							before = (Integer.parseInt(before) + Integer.parseInt(after)) + "";
						}

						else if (token.equals("-")) {
							before = (Integer.parseInt(before) - Integer.parseInt(after)) + "";
						}

						else {
							before = (Integer.parseInt(before) / Integer.parseInt(after)) + "";
						}

						result = before;
					} else
						before = token;
				} // while 끝
				System.out.println(result);
			} catch (Exception e) {
				System.out.println("수식 오류!!!");
			}

		}
	}
}
