package day6;

// !!!!!!!!!!!!!!!!!!나중에 큰 프로젝트를 맡을 때는 한 클래스 안에서 우다다다 쓰면 안됨!!! 클래스 나눠서 쓸 것!!!!!

// Q2. 앞서 정의한 Point클래스를 테스트하기 위한 PointTest클래스를 작성하고, Point객체를 생성하는 코드를 작성하시오.

public class PointTest {

	public static void main(String[] args) {
		
		// Q3. Point 객체를 생성한 다음, x와 y값을 3과 5로 초기화하시오. 그리고 toString()을 호출해서 x와 y의 값을 출력하시오.
			Point p1 = new Point(); // Point 객체 생성
			p1.x = 3; // x와 y의 값을 초기화
			p1.y = 5;
			System.out.println("3번 문제 테스트: "+p1.toString());
			
		// Q4. x,y를 매개변수로 하는 생성자와 기본생성자(x,y를 모두 1로 초기화)한 후 테스트하시오.
			Point p2 = new Point();
			System.out.println("4번 문제(1) 테스트: "+p2);
			
			Point p3 = new Point(1, 5); // 임의의 값
			System.out.println("4번 문제(2) 테스트 : "+p3);
			
		// Q5. Point 클래스에 두 점사이의 거리를 double 타입의 값으로 계산해서 반환하는 static 메서드 getDistance(Point p1, Point p2)를 확인
			System.out.println("5번 문제 테스트: "+Point.getDistance(p3,p1));
			// static은 객체 이름 대신 클래스 명을 사용할 수 있음!!!!!
			
		// Q6. Point 클래스에 두 점사이의 거리를 double 타입의 값으로 계산해서 반환하는 getDistance(Point p)를 확인
			System.out.println("6번 문제 테스트: "+p2.getDistance(p3));
			
		// Q7. Point클래스의 equals()를 테스트
		// Q7-1 Case 1: Point 객체가 아닌 경우
			PointTest t1 = new PointTest();
			System.out.println("7번 문제(1) 테스트: "+p3.equals(t1));
			
		// Q7-2 Case 2: Point객체의 x와 y의 값이 다를 때
			System.out.println("7번 문제(2) 테스트: "+p1.equals(p3));
			
		// Q7-3 Case 3: Point객체의 x와 y의 값이 같을 때
			System.out.println("7번 문제(3) 테스트 : "+p2.equals(p3));
			
		// Q10 Point3D쿨래스의 toString()이 x,y,z의 값을 문자열로 반환하는 것을 테스트
			Point3D d1 = new Point3D();
			Point3D d2 = new Point3D(1,3,5);
			System.out.println("10번 문제(1) 테스트 : "+d1);
			System.out.println("10번 문제(2) 테스트 : "+d2);

			
	}

}
