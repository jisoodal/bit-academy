package day6;

// Q1. 두 개의 정수 x,y를 저장하기 위한 인스턴스 변수가 선언된 Point 클래스를 정의하시오.
public class Point{ 	
	int x; // 인스턴스 변수인 x,y 선언
	int y;
	
	// Q3. Point 클래스에 toString()을 오버라이딩해서 x와 y의 값을 3과 5로 초기화하시오. 그리고 toString()을 호출해서 x와 y의 값을 출력하시오.
	public String toString() { // public 붙여야함!!
		return "x:"+x+", y:"+y; // x와 y의 값을 출력해줌
	}
	
	// Q4. Point클래스에 x,y를 매개변수로 하는 생성자와 기본 생성자(x,y를 모두 1로 초기화)를 추가하시오. 그 다음에 PointTest클래스에서 테스트 하시오.
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	Point(){
//		this.x = 1; // 기본 생성자의 경우 x와 y를 1로 초기화한다.
//		this.y = 1;
		this(1,1); // 이렇게 쓰는게 깔끔하다. super()와 헷갈리지 말것! 조상 클래스가 없음!
		
	}
	
	// Q5.Point클래스에 두 점사이의 거리를 double타입의 값으로 계산해서 반환하는 static메서드 getDistance(Point p1, Point p2)를 추가하시오.
	public static double getDistance(Point p1, Point p2) {
		int a = p2.x - p1.x; // x2-x1
		int b = p2.y - p1.y; // y2-y1
		return Math.sqrt(a*a+b*b); // 루트((x2-x1)^2 +(y2-y1)^2)
	}
	
	// Q6. Point 클래스에 두 점 사이의 거리를 double타입의 값으로 계산해서 반환하는 getDistance(Point p)를 추가하시오.
	public double getDistance(Point p) {
		
//		double result = 0; // 결과값을 담을 double 변수
//		
//		if(p.x-p.y>=0) { // x점과 y점을 뺀 값이 0보다 작은 경우
//				result = p.x-p.y;
//			}
//			else // x점과 y점을 뺀 값이 0보다 큰 경우
//				result = (p.x-p.y)*-1;  // 결과값을 양수로 바꿔준다
//		
//		return result;
		// im은 cm호출 가능, cm은 im호출 불가능
		// this.x, this.y 이렇게 말고 나 자신을 this로 메소드 인자를 줄 수 있다.
		return getDistance(this, p); //
	}
	
	// Q7. Point클래스의 equals()를 다음과 같은 조건으로 오버라이딩 하고 테스트 하시오.
	//	   1)비교하는 객체가 Point객체가 아니면 false를 반환
	public boolean equals(Point p) {
		if(!(p instanceof Point)) // 비교하는 객체가 Point 객체가 아닌 경우.
			return false;
		
	//	   2)Point객체의 x와 y의 값이 같을 때만 true를 반환
		else if(p.x != this.x || p.y != this.y) // p.x와 p.y가 Point객체의 x와 y 값과 일치하지 않으면 false
			return false;
		
		return true; // Point 객체이면서 Point 객체의 x와 y값과 일치한 경우 true
	}
}
