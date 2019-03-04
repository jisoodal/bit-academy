package day5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RankCheck {
	// Q. 포커 게임의 순위(RANK)를 판별하는 메서드 작성
	// String rankCheck(Card[] cards)
	// 5장의 카드를 받아서, 순위를 문자열로 반환
	// 예) 카드 5장이 모두 같은 무늬 - "flush"
	// 카드 5장이 연속, 1,2,3,4,5 - "straight"
	
	 String rankCheck(Card1[] cards) {
		 
		 boolean straight = false, // 초기화할때는 ,로 묶는게 아니라 따로따로 해야함!!!! boolean straight,flush = false 안됨!!
		 flush= false; // 카드가 straight인지 flush인지 판별
		 
		 for(int i=1;i<cards.length;i++) { // cArr 배열 길이만큼 돈다
			 if((cards[i-1].num)+1 != cards[i].num) { // 전의 카드 숫자 +1이 다음 카드 숫자가 아니면. 즉, 연속이 아니면
				 straight = false; // straight가 아니다
				 break; // for문을 빠져나온다
			 }
			 else 
				 straight = true; // 숫자가 연속인 경우
		 }
		 
		 for(int i=1;i<cards.length;i++) {
			 if(!(cards[i-1].kind.equals(cards[i].kind))) { // 전의 카드 종류와 다음 카드 종류가 같지 않으면. 즉, 모든 종류가 같지 않으면
				 flush = false; // flush가 아니다
				 break; // for문을 빠져나온다
			 }
			 else
				 flush = true; // 모든 패턴이 같은 경우
		 }
		 
		 if(straight)
			 return "straight"; // straight인 경우 문자열 반환
		 else if(flush)
		 	return "flush"; // flush인 경우 문자열 반환
		 else
			 return "nothing";
	 }


	@Test
	void test1() {
		Card1[] cArr = { new Card1(1, "S"),new Card1(2, "S"),new Card1(3, "D"),new Card1(4, "H"),new Card1(5, "S")};
		assertTrue(rankCheck(cArr).equals("straight")); // true
	}
	
	@Test
	void test2() {
		Card1[] cArr = { new Card1(2, "S"),new Card1(2, "S"),new Card1(3, "S"),new Card1(4, "S"),new Card1(5, "S")};
		assertTrue(rankCheck(cArr).equals("flush")); // true
	}
	
	@Test
	void test3() {
		Card1[] cArr = { new Card1(1, "S"),new Card1(2, "K"),new Card1(3, "D"),new Card1(4, "H"),new Card1(5, "S")};
		assertTrue(rankCheck(cArr).equals("flush")); // false
	}
	
	@Test
	void test4() {
		Card1[] cArr = { new Card1(2, "S"),new Card1(2, "S"),new Card1(3, "D"),new Card1(4, "H"),new Card1(5, "S")};
		assertTrue(rankCheck(cArr).equals("straight")); //false
	}
	
	@Test
	void test5() {
		Card1[] cArr = { new Card1(1, "D"),new Card1(2, "D"),new Card1(3, "D"),new Card1(4, "D"),new Card1(5, "D")};
		assertTrue(rankCheck(cArr).equals("straight")); // true
	}

}

class Card1 {
	int num;
	String kind;
	
	Card1(){this(1,"S");}
	Card1(int num, String kind) {
		this.num = num;
		this.kind = kind;
	}
}
