package ch07;

public class Exercise7_27 {

	public static void main(String[] args) {
		Outer2 oc = new Outer2(); // �ܺ� Ŭ������ �ν��Ͻ��� ���� �����ؾ� �Ѵ�. �ܺ� ����
		Outer2.Inner inner = oc.new Inner(); // ���� ����. �ݵ�� �θ��� �ν��Ͻ��� �ִ� ��츸 inner �ν��Ͻ��� ���� �� �ִ�. 
											 // ���� �ݵ�� �θ��� �ν��Ͻ�.new�� �����ؾ� �Ѵ�.
		inner.method1();

	}

}

class Outer2 { 
	int value = 10;
	
	class Inner {
		int value = 20;
		void method1() {
			int value = 30;
			Inner in = new Inner();
			Outer2 oc = new Outer2();
			
			System.out.println(value);
			System.out.println(in.value);
			System.out.println(oc.value);
		}
	} // Inner Ŭ������ ��
} // Outer Ŭ������ ��
