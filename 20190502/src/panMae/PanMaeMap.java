package panMae;

import java.util.Scanner;

public class PanMaeMap {
	
	String code, name;
	int price, amount, totalCost;
	
	static Scanner scanner = new Scanner(System.in);
	
	public void input() {

		System.out.print("��ǰ�ڵ带 �Է��ϼ���: ");
		this.code = scanner.nextLine();
		
		if(PanMaeMapEx.panMaeMap.containsKey(this.code)) {
			System.out.println("�̹� �����ϴ� ��ǰ�ڵ��Դϴ�.");
			return;
		}

		System.out.print("��ǰ���� �Է��ϼ���: ");
		this.name = scanner.nextLine();

		System.out.print("�ܰ��� �Է��ϼ���: ");
		this.price = Integer.parseInt(scanner.nextLine());

		System.out.print("������ �Է��ϼ���: ");
		this.amount = Integer.parseInt(scanner.nextLine());

		process();

	}

	public void process() {

		this.totalCost = this.price * this.amount;
	}

	public String toString() {

		return code + "\t" + name + "\t" + price + "��\t" + amount + "��\t" + totalCost + "��\t";
	}

	public void printEach() {

		System.out.println("��ǰ�ڵ�: " + code);
		System.out.println("��ǰ��: " + name);
		System.out.println("�ܰ�: " + price + "��");
		System.out.println("����: " + amount + "��");
		System.out.println("�ݾ�: " + totalCost + "��\n");

	}

	public void modify() {

		int newPrice = 0, newAmount = 0;

		System.out.print("�ܰ� ���� :");
		newPrice = Integer.parseInt(scanner.nextLine());

		System.out.print("���� ���� :");
		newAmount = Integer.parseInt(scanner.nextLine());

		this.price 	= newPrice;
		this.amount = newAmount;
	}

}
