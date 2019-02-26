package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayEx16Test2 {
	// Q. 길이가 3인 두 개의 int배열을 입력받아서 비교한 결과를
	// String으로 반환하는 메서드를 작성하시오.
	// 두 배열에 같은 값이 있으면 ball이고,
	// 같은 값이면서 위치까지 같으면 strike이다.
	// 만일 {1,2,3}rhk{1,3,2}를 비교하면 "1S2B"를 반환해야 한다.
	
	String check(int[] arr1, int[] arr2) {
		
		int ball = 0 ,
			strike = 0;
		
		String result = " ";
		
		for(int i=0;i<arr1.length;i++) { // 두 배열을 각각 한 번씩 비교.
			
			for(int j=0;j<arr2.length;j++) {
				if(arr1[i]==arr2[j]) {
					if(arr1[i] == arr2[i]) {
						strike++;
					}
					else
						ball++;
				}
				else
					continue;	
			}
		}
		result = strike+""+"S"+ball+""+"B";
		return result;
	}

	@Test
	public void test1() {
		assertTrue(check(new int[]{1,2,3},new int[] {1,3,2})
					.equals("1S2B")); // true
	}
	
	@Test
	public void test2() {
		assertTrue(check(new int[]{1,3,5},new int[] {1,3,2})
					.equals("1S2B")); // false
	}
	
	@Test
	public void test3() {
		assertTrue(check(new int[]{3,2,1},new int[] {1,3,2})
					.equals("1S2B")); // false
	}
	
	@Test
	public void test4() {
		assertTrue(check(new int[]{5,1,4},new int[] {4,1,5})
					.equals("1S2B")); // true
	}
	
	@Test
	public void test5() {
		assertTrue(check(new int[]{9,-1,0},new int[] {9,0,-1})
					.equals("1S2B")); // true
	}
	
	@Test
	public void test6() {
		assertTrue(check(new int[]{-1,-2,-3},new int[] {-3,-2,-1})
					.equals("1S2B")); // true
	}

}
