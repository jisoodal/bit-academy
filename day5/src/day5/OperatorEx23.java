package day5;

class Point { // extends Object가 생략되어 있는 것.
	int x;
	int y;
}

public class OperatorEx23 {

	public static void main(String[] args) {
		Point p = new Point();
		Point p2 = new Point();
		
		System.out.println(p.toString()); // 최고조상인 Object를 자동으로 상속받아서 toString이 사용 가능해진다.
		System.out.println(p.equals(p2));

	}

}