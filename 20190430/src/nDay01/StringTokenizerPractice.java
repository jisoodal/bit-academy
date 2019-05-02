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
			System.out.print("���� �Է� =>");
			StringTokenizer stok = new StringTokenizer(scanner.nextLine(), "*+-/", true); // �Է¹ް� -> ������ �����ڸ� -> ��ū����
																							// �����Ѵ�
			try {
				while (stok.hasMoreTokens()) {
					String token = stok.nextToken();
					// �տ� ������ token �Է� ����

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
				} // while ��
				System.out.println(result);
			} catch (Exception e) {
				System.out.println("���� ����!!!");
			}

		}
	}
}
