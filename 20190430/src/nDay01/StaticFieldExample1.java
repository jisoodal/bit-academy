package nDay01;

public class StaticFieldExample1 {

	public static void main(String[] args) {
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(10);
		obj2.accumulate(20);
		System.out.println("obj1.total = "+obj1.total);
		System.out.println("obj1.grandTotal = " +Accumulator.grandTotal); // obj1 = ��ü�̸�
		System.out.println("obj2.total = " + obj2.total);
		System.out.println("obj2.grandTotal = "+Accumulator.grandTotal); // ��ü�Ҽ����� Ŭ�����Ҽ����� ->  Accumulator = Ŭ���� �̸�
	}
}

class Accumulator {
	 int total = 0;
	 static int grandTotal = 0; // ���� �ʵ带 �����ϴ� ����
	 void accumulate(int amount) {
	 total += amount;
	 grandTotal += amount; // ���� �ʵ带 ����ϴ� ��ɹ�
	 }
} 