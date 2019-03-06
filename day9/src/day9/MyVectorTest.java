package day9;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Vector;

import org.junit.jupiter.api.Test;

class MyVectorTest {

	@Test // 값을 대입해서 초기화 한 경우
	void initiallizeTest01() {
		MyVector v = new MyVector();
		
		assertTrue(v.capacity == 16);
	}
	
	@Test // 기본 초기화의 경우
	void initiallizeTest02() {
		MyVector v = new MyVector(8);
		
		assertTrue(v.capacity == 8);
	}
	
	@Test
	void isEmpty() { // 비어있는지 
		MyVector v = new MyVector();
		
		assertTrue(v.isEmpty() == true);
		
		v.add("hi");
		assertTrue(v.isEmpty() == false);
	}
	
	@Test
	void add() { // 값 대입 후 사이즈 제대로 반환하는지
		MyVector v = new MyVector();
		
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
		
	}
	
	@Test
	void get() { // index위치의 객체를 제대로 반환하는지
		MyVector v = new MyVector();
		
		v.add("a");
		v.add("2");
		v.add("3");
		v.add("tt");
		v.add("hihi");
		
		assertTrue(v.get(3).equals("tt"));
		
		v.remove("tt");
		v.remove("2");
		
		assertTrue(v.get(2).equals("hihi"));
	}
	
	@Test
	void stringOk() { // 모든 객체를 문자열로 이어서 잘 반환하는지
		MyVector v = new MyVector();
		
		v.add("i");
		v.add("wanna");
		v.add("go");
		
		assertTrue(v.toString().equals("iwannago"));
		
		v.add("home");
		v.remove("wanna");
		v.add("right");
		v.add("now");
		
		assertTrue(v.toString().equals("igohomerightnow"));
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
		
		assertTrue(v.remove("3") == true);
	}

}
