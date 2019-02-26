package day4;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayEx16Test3 {
	
	int bingoCheck(int[][] arr) {
		
		int bingoCnt = 0;
		int garoCnt = 0;
		int seroCnt = 0;
		int daegakCnt = 0;
	    int daegakCnt2 = 0;
		 
		 	for(int i=0;i<arr.length;i++) {
		 		for(int j=0;j<arr[i].length;j++) { 
		 				if(arr[i][j]==1)
		 					garoCnt++;
		 				if(arr[j][i]==1)
		 					seroCnt++;
		 				if(arr[i][j] ==1 && i==j)
		 					daegakCnt++;
		 				if(arr[i][j]==1 && i+j==4)
		 					daegakCnt2++;
		 		}
		 		if(garoCnt ==5) bingoCnt++;
		 		if(seroCnt ==5) bingoCnt++;
		 		
		 		garoCnt = 0; 
		 		seroCnt = 0;
		 	}
		 	
		 		if(daegakCnt ==5) bingoCnt++;
		 		if(daegakCnt ==5) bingoCnt++;
				return bingoCnt;
}

	@Test
	public void test1() {
		int[][] arr = {
				{1,1,1,1,1},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
		} ;
		assertTrue(bingoCheck(arr)==1);
	}
	
	@Test
	public void test2() {
		int[][] arr = {
				{1,0,0,0,0},
				{0,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,0},
				{0,0,0,0,1}
		} ;
		assertTrue(bingoCheck(arr)==0);
	}
	
	@Test
	public void test3() {
		int[][] arr = {
				{1,1,1,1,1},
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,0,0,0},
				{1,0,0,0,0}
		} ;
		assertTrue(bingoCheck(arr)==2);
	}
	
	@Test
	public void test4() {
		int[][] arr = {
				{1,1,1,1,1},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0}
		} ;
		assertTrue(bingoCheck(arr)==1);
	}

}
/*
 * 
   int bingoCnt = 0;
   int garoCnt = 0;
   int seroCnt = 0;
   int daegakCnt = 0;
   int daegakCnt2 = 0;
 
 	for(int i=0;i<arr.length;i++) {
 		for(int j=0;j<arr[i].length;j++) { 
 				if(arr[i][j]==1)
 					garoCnt++;
 				if(arr[j][i]==1
 					seroCnt++;
 				if(arr[i][j] ==1 && i==j)
 					daegakCnt++;
 				if(arr[i][j]==1 && i+j==4)
 					daegakCnt2++;
 	}
 		if(garoCnt ==5) bingoCnt++;
 		if(seroCnt ==5) bingoCnt++;
 		
 		garoCnt = 0; 
 		seroCnt = 0
 	}
 	
 		if(daegakCnt ==5) bingoCnt++;
 		if(daegakCnt ==5) bingoCnt++;]
 		
 		return bingoCnt;
 }
 */
