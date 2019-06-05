package ch07;

public class Exercise7_19 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	

	}

}

class Buyer {
	int money = 1000;
	Product[] cart = new Product[3];
	int i = 0;
	
	void buy(Product p) {
		/*
		 1.1 ���� ���� ������ ������ ���ؼ� ���� ���� ������ �޼��带 �����Ѵ�.
		 1.2 ���� ���� ����ϸ�, ��ǰ�� ������ ���� ������ ����
		 1.3 ��ٱ��Ͽ� ������ ������ ��´�.(add�޼��� ȣ��)
		 */
		if(money < p.price) {
			System.out.println("�ܾ��� �����Ͽ�"+p+"��/�� �� �� �����ϴ�.");
			return;
		}
		
		money -= p.price;
		add(p);
	}
	
	void add(Product p) {
		/*
		 1.1 i�� ���� ��ٱ����� ũ�⺸�� ���ų� ũ��
		1.1.1 2 . ������ ��ٱ��Ϻ��� �� ū ���ο� �迭�� �����Ѵ�
		1.1.2 . ������ ��ٱ����� ������ ���ο� �迭�� �����Ѵ�
		1.1.3 . ���ο� ��ٱ��Ͽ� ������ ��ٱ��ϸ� �ٲ۴�
		1.2 ������ ��ٱ���(cart)�� �����Ѵ�. �׸��� i�� ���� 1 ������Ų��.
		 */
		if(i>=cart.length) {
			Product[] newCart = new Product[cart.length*2];
			System.arraycopy(cart, 0, newCart, 0, i);
			cart = newCart;
			cart[i] = p;
			i++;
		} else {
			cart[i] = p;
			i++;
		}
	}
	
	void summary() {
		/*
		(3) . �Ʒ��� ������ �°� �ڵ带 �ۼ��Ͻÿ�
		1.1 . ��ٱ��Ͽ� ��� ���ǵ��� ����� ����� ����Ѵ�
		1.2 . ��ٱ��Ͽ� ��� ���ǵ��� ������ ��� ���ؼ� ����Ѵ�
		1.3 (money) . ������ ��� ���� �ݾ� �� ����Ѵ�
		*/
		System.out.print("������ ����:");
		for(int i=0;i<cart.length;i++) {
			System.out.print(cart[i]+", ");
		}
		System.out.println();
		System.out.print("����� �ݾ�:"+(1000-money));
		System.out.println();
		System.out.print("���� �ݾ�: "+money);
		
	}
}

class Product {
	int price;
	
	Product(int price){
		this.price = price;
	}
}

class Tv extends Product {
	Tv() {super(100);}
	
	public String toString() {return "Tv"; }
}

class Computer extends Product {
	Computer() {super(200);}
	
	public String toString() {return "Computer"; }
}

class Audio extends Product {
	Audio() {super(50); }
	
	public String toString() {return "Audio";}
}