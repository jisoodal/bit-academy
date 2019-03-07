package day9;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class MyVectorTest {

	@Test // 값을 대입해서 초기화 한 경우
	void initiallizeTest01() {
		MyVector v = new MyVector();
		
		assertTrue(v.isEmpty() == true);
		
		assertTrue(v.capacity() == 16);
	}
	// expected -> 예외가 발생해야 통과
	// 기본 초기화의 경우
	@Test //(expected=IllegalArgumentException.class) // expected -> 예외가 발생해야 통과
	void initiallizeTest02() {
		MyVector v = new MyVector(100);
		
		assertTrue(v.isEmpty() == true);
		
		assertTrue(v.capacity() == 100);
		
//		MyVector v2 = new MyVector(-3); 음수의 경우 에러
//		assertTrue(v2.capacity() == -3);
	}
	
	@Test
	void isEmpty() { // 비어있는지 
		MyVector v = new MyVector();
		
		assertTrue(v.isEmpty() == true);
		
		v.add("hi");
		assertTrue(v.isEmpty() == false);
		
		v.remove("hi"); // 추가하고 비어있는지 보고 삭제하고 비어있는지 확인하자
		assertTrue(v.isEmpty() == true);
		
		v.remove("hi"); // 없는걸 한번 더 삭제해본다
		assertTrue(v.isEmpty() == true);
	}
	
	@Test
	void add() { // 값 대입 후 사이즈 제대로 반환하는지
		MyVector v = new MyVector();
		
		assertTrue(v.isEmpty() == true);
		assertTrue(v.size() == 0);
		
		v.add(1);
		assertTrue(v.size() == 1);
		v.remove(3);
		assertTrue(v.size() == 1);
		v.remove(1);
		
		v.add("a"); //0
		v.add("2"); //1
		v.add("3"); //2
		v.add("tt"); //3 삭제
		v.add("hihi"); //4 - 3
		
		assertTrue(v.size() == 5);
		
		v.add("z"); //5 - 4
		v.add("z1"); //6 - 5
		v.add("z2"); //7 삭제
		v.add("z3"); //8 삭제
		
		assertTrue(v.size() == 9);
		
		v.remove("z3"); // size - 8
		v.remove("z2"); // size - 7
		v.remove("tt"); // size - 6
		
		assertTrue(v.size() == 6);
		
		assertTrue(v.indexOf("z") == 4); 
		
		assertTrue(v.isEmpty() == false);
		
	}
	
	@Test
	void add2() {
		Vector v = new Vector();
		
		assertTrue(v.size() == 0);
		
		for(int i=0;i<10000000;i++) {
			v.add(i+"");
		}
		assertTrue(v.size() == 10000000);
	}
	
	@Test
	void add3() {
		Vector v = new Vector();
		
		assertTrue(v.size() == 0);
		
		v.add(null);
		assertTrue(v.size() == 1);
		assertTrue(v.get(0) == null);
	}
	
	
	@Test
	void get() { // index위치의 객체를 제대로 반환하는지
		MyVector v = new MyVector();
		
		assertTrue(v.isEmpty() == true);
		
		v.add("a");
		v.add("2");
		v.add("3");
		v.add("tt");
		v.add("hihi");
		
		assertTrue(v.get(3).equals("tt"));
		assertTrue("a".equals(v.get(0)));
		
		v.remove("tt");
		v.remove("2");
		
		assertTrue(v.get(2).equals("hihi"));
		
		assertTrue(v.isEmpty() == false);
	}
	
	@Test
	void stringOk() { // 모든 객체를 문자열로 이어서 잘 반환하는지
		MyVector v = new MyVector();
		
		assertTrue(v.isEmpty() == true);
		
		v.add("i");
		v.add("wanna");
		v.add("go");
		
		assertTrue(v.toString().equals("iwannago"));
		
		v.add("home");
		v.remove("wanna");
		v.add("right");
		v.add("now");
		
		assertTrue(v.toString().equals("igohomerightnow"));
		
		v.remove("i");
		v.remove("wanna");
		v.remove("go");
		v.remove("home");
		v.remove("right");
		v.remove("now");
		
		assertTrue(v.isEmpty() == true);
		
	}
	
	@Test
	void indexOf() { // 지정된 객체가 저장되어 있는 위치를 잘 반환하는지
		MyVector v = new MyVector();
		
		v.add("i");
		v.add("wanna");
		v.add("go");
		
		assertTrue(v.indexOf("wanna") == 1);
		
		v.add("home");
		v.remove("wanna");
		v.add("right");
		v.add("now");
		
		assertTrue(v.indexOf("home") == 2);
	}
	
	@Test
	void removeOk() { // 객체를 제대로 삭제하는지
		MyVector v = new MyVector();
		
		v.add("a");
		v.add("2");
		v.add("3");
		v.add("t");
		v.add("i");
		
		assertTrue(v.remove("i") == true);
	}
}

/*
  	Vector v;
  	@Before <- 테스트 실행되기 전에 한 번만 돌아감
	void setup() {
		v = new Vector();
	}
	
	@After
	void cleanUp(){
	 테스트가 끝난 후에 수행할 작업을 넣는다.
	}
	
	순서: before -> test1 -> after.
		 before -> test2 -> after.
		 before -> test3 -> after.
*/