package program;

import java.util.Scanner;

public class PersonInfo extends Person implements Personable {

	String phone;
	String addr;

	Scanner scanner = new Scanner(System.in);

	@Override
	public void input() {
		System.out.print("�й�:");
		hakbun = scanner.nextLine();
		System.out.print("�̸� :");
		irum = scanner.nextLine();

		System.out.print("��ȭ��ȣ:");
		phone = scanner.nextLine();

		System.out.print("�ּ� �Է�:");
		addr = scanner.nextLine();
		System.out.println();

	}

	@Override
	public void output() {
		System.out.print(hakbun + "\t" + irum + "\t" + phone + "\t" + addr + "\t");
	}
}
