package day6;

//Q8. Point클래스를 상속받고 z를 인스턴스 변수로 갖는 Point3D 클래스를 작성하시오.
public class Point3D extends Point {
	int z;
//Q9. Point3D클래스에 생성자 Point3D(int x, int y, int z)와 기본 생성자(x,y,z를 1로 초기화)를 추가하시오.
	Point3D(int x, int y, int z) {
//		this.x = x;
//		this.y = y;
		super(x,y); // 상속 클래스의 x,y값을 받아옴
		this.z = z;
		}
	
	Point3D(){ // 기본 생성자
//		x = 1;
//		y = 1;
		super(1,1);
		this.z = 1; // 그냥 z를 하는거랑 this.z를 하는거랑 무슨 차이?? 값 나오는거 자체는 같던데
	}
	
//Q10. Point3D클래스의 toString()이 x,y,z의 값을 문자열로 반환하도록 오버라이딩하시오.
//오버라이딩 조건: 1. 선언부가 같아야 한다, 2. 접근제어자가 더 좁으면 안된다 3. 예외처리가 더 많으면 안된다.
	public String toString() {
//		return "x="+x+", y="+y+", z="+z; // x, y, z의 값을 문자열로 반환
		return super.toString()+", z:"+this.z;
	}
}