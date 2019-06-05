package ch07;

public class Exercise7_27 {

	public static void main(String[] args) {
		Outer2 oc = new Outer2(); // 외브 클래스의 인스턴스를 먼저 생성해야 한다. 외부 생성
		Outer2.Inner inner = oc.new Inner(); // 내부 생성. 반드시 부모의 인스턴스가 있는 경우만 inner 인스턴스를 만들 수 있다. 
											 // 따라서 반드시 부모의 인스턴스.new로 생성해야 한다.
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
	} // Inner 클래스의 끝
} // Outer 클래스의 끝
