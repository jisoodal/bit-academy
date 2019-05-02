package panMae;

import java.util.Scanner;

public class PanMaeArr {

	String code, name;
	int price, amount, totalCost;

	static Scanner scanner = new Scanner(System.in);

	public void input() {

		System.out.print("제품코드를 입력하세요: ");
		this.code = scanner.nextLine();
		
		for(int i=0;i<PanMaeArrEx.panMaeList.size();i++) {
			if(PanMaeArrEx.panMaeList.get(i).code.equals(this.code)) {
				System.out.println("이미 존재하는 제품코드입니다.\n");
				
				return;
			}
		}

		System.out.print("제품명을 입력하세요: ");
		this.name = scanner.nextLine();

		System.out.print("단가를 입력하세요: ");
		this.price = Integer.parseInt(scanner.nextLine());

		System.out.print("수량을 입력하세요: ");
		this.amount = Integer.parseInt(scanner.nextLine());

		process();
		
		System.out.println("상품이 등록되었습니다.\n");

	}

	public void process() {

		this.totalCost = this.price * this.amount;
	}

	public void output() {

		System.out.println(code + "\t" + name + "\t" + price + "원\t" + amount + "개\t" + totalCost + "원\t");
	}

	public void printEach() {

		System.out.println("제품코드: " + code);
		System.out.println("제품명: " + name);
		System.out.println("단가: " + price + "원");
		System.out.println("수량: " + amount + "개");
		System.out.println("금액: " + totalCost + "원");

	}

	public void modify() {

		int newPrice = 0, newAmount = 0;

		System.out.print("단가 변경 :");
		newPrice = Integer.parseInt(scanner.nextLine());

		System.out.print("수량 변경 :");
		newAmount = Integer.parseInt(scanner.nextLine());

		this.price 	= newPrice;
		this.amount = newAmount;
	}

}
