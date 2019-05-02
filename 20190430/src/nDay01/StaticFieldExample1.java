package nDay01;

public class StaticFieldExample1 {

	public static void main(String[] args) {
		Accumulator obj1 = new Accumulator();
		Accumulator obj2 = new Accumulator();
		obj1.accumulate(10);
		obj2.accumulate(20);
		System.out.println("obj1.total = "+obj1.total);
		System.out.println("obj1.grandTotal = " +Accumulator.grandTotal); // obj1 = 객체이름
		System.out.println("obj2.total = " + obj2.total);
		System.out.println("obj2.grandTotal = "+Accumulator.grandTotal); // 객체소속인지 클래스소속인지 ->  Accumulator = 클래스 이름
	}
}

class Accumulator {
	 int total = 0;
	 static int grandTotal = 0; // 정적 필드를 선언하는 선언문
	 void accumulate(int amount) {
	 total += amount;
	 grandTotal += amount; // 정적 필드를 사용하는 명령문
	 }
} 