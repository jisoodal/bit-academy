package program;

import java.util.Scanner;

public class PersonInfo extends Person implements Personable {

	String phone;
	String addr;

	Scanner scanner = new Scanner(System.in);

	@Override
	public void input() {
		System.out.print("학번:");
		hakbun = scanner.nextLine();
		System.out.print("이름 :");
		irum = scanner.nextLine();

		System.out.print("전화번호:");
		phone = scanner.nextLine();

		System.out.print("주소 입력:");
		addr = scanner.nextLine();
		System.out.println();

	}

	@Override
	public void output() {
		System.out.print(hakbun + "\t" + irum + "\t" + phone + "\t" + addr + "\t");
	}
}
