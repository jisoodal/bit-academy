package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayEx16 {
	// Q. 세 개의 정수를 입력받아서 그 중에 2번째로 큰 값을 반환하는 메서드
	// int mid(int x, int y, int z)를 작성하시오.
	
	int mid(int x, int y, int z) {
		
		if(x<=y) {
			if(y<=z)
				return y;
			else {
				y=z;
			}
		}
		
		else if(x>=y) {
			if(y>=z)
				return y;
			else
				y=z;
		}
		return y;
	}

	@Test
	public void test() {
		assertTrue(mid(1,2,3)==2);
	}
	
	@Test
	public void test2() {
		assertTrue(mid(3,2,1)==2);
	}
	
	@Test
	public void test3() {
		assertTrue(mid(1,3,2)==2);
	}
	
	@Test
	public void test4() {
		assertTrue(mid(1,1,1)==1);
	}
	
	@Test
	public void test5() {
		assertTrue(mid(0,3,2)==2);
	}
	
	@Test
	public void test6() {
		assertTrue(mid(-1,-3,-2)==-2);
	}

}

/*
 강사님 풀이
 
 int mid(int x, int y, int z) {
 	if((x<=y&&y<=z) || (z<=y&&y<=x))
 		return y;
 	else if((y<=x&&x<=z)) || (z<=x&&x<=y)
 		return x;
 	return z;
 */
