package day8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PokerGame {
		
	 String rankCheck(Card[] cards) {
			 
		 boolean straightFlush = false,
		 fourCard = false,
		 fullHouse = false,
		 flush = false,
		 straight = false,
		 threeCard = false,
		 twoPair = false,
		 onePair = false,
		 highCard = false,
		 nothing = true;
		 
		 int count2 = 0;
		 
		 int[] count = new int[11];
		 int[] count3 = new int [11];
		 
//		 
		// 포/쓰리카드 & 원페어	 
		 for(int i=0;i<cards.length;i++) {
			 count[cards[i].num]++; // 각 카드 자리의 해당 숫자의 count 증가
		 }
		 
		 for(int i=1;i<(Card.CARDNUM)+1;i++) { // 1부터 10까지
			 if(count[i] == 4) // 같은 숫자가 4개인 경우
				 fourCard = true; // 포카드
			 else if(count[i] == 3) // 같은 숫자가 3개인 경우
				 threeCard = true; // 쓰리카드
			 else if(count[i] == 2) // 같은 숫자가 2개인 경우
				 onePair = true; // 원페어
			 else
				 nothing = true; // 아무것도 아닌 경우
		 }
		 System.out.println(threeCard);
//		 
//		 // 2pair
		 
//		 for(int i=1;i<cards.length;i++) {
//			 count3[cards[i].num]++; // 같은 숫자가 몇개인지 count3 배열로 세어본다
//		 }
//		 
//		 for(int i=1; i<count3.length;i++) {
//			 if(count3[i] == 2)
//				 count2++; // 같은 숫자가 2개인 경우 count2를 증가
//			 else
//				 continue;
//		 }
//		 
//		 if(count2 == 2) // 같은 숫자가 2개인 경우가 2개이면
//			 twoPair = true; // 2페어
//		 else
//			 nothing = true; // 아무것도 아니면 nothing
//		 
		 // flush
		 
		 for(int i=1;i<cards.length;i++) {
			 if(!(cards[i-1].kind.equals(cards[i].kind))) { // 전 카드의 무늬가 다음 카드의 무늬와 다르면
				 flush = false; // 즉, 모든 카드가 같은 무늬가 아니면 flush가 아니다.
				 break; 			
			 }
			 else
				 flush = true;  // 모든 카드 무늬가 같은 무늬면 flush이다.
		 }
		 System.out.println(flush);
			 
		 // straight
		 
		 for(int i=1;i<cards.length;i++) { 
			 if((cards[i-1].num)+1 != cards[i].num) { // 전의 카드와 다음 카드가 연속이 아니면 (3,4,5,6,7)
				 straight = false; 
				 break; 
			 }
			 else {
				 straight = true; // 숫자가 연속이면 straight이다
			 }
		 }
		 
		 if(straight == flush)
			 return "straight flush"; 
//		 else if(fourCard)
//		 	return "four card"; 
//		 else if(threeCard == onePair)
//			 return "full house";
//		 else if(flush)
//			 return "flush";
//		 else if(straight)
//			 return "straight";
		 else if(threeCard)
			 return "three card";
//		 else
//			 return "nothing";
//		 else if(twoPair)
//			 return "two pair";
//		 else if(onePair)
//			 return "one pair";
		 else
			 return "no rank";
	 }

//	 @Test
//	 void test() {  // 같은 숫자가 2개면, 1 pair
//	  Card[] cArr = { new Card(2, "S"), new Card(2, "S")
//	           ,new Card(3, "D"), new Card(4, "H")
//	           ,new Card(5, "S")};
//	  assertTrue(rankCheck(cArr).equals("1 pair"));
//	 }
//
//	 @Test
//	 void test2() {  // 같은 숫자가 2개인개 2개면, 2 pair
//	  Card[] cArr = { new Card(2, "S"), new Card(2, "S")
//	           ,new Card(4, "D"), new Card(4, "H")
//	           ,new Card(5, "S")};
//	  assertTrue(rankCheck(cArr).equals("2 pair"));
//	 }

	 @Test
	 void test3() {  // 같은 숫자가 3개이면, Three Card
	  Card[] cArr = { new Card(2, "S"), new Card(2, "S")
	           ,new Card(2, "D"), new Card(4, "H")
	           ,new Card(5, "S")};
	  assertTrue(rankCheck(cArr).equals("three card"));
	 }

//	 @Test
//	 void test4() {  // 같은 숫자가 4개이면, Four Card
//	  Card[] cArr = { new Card(2, "S"), new Card(2, "S")
//	           ,new Card(2, "D"), new Card(2, "H")
//	           ,new Card(5, "S")};
//	  assertTrue(rankCheck(cArr).equals("four card"));
//	 }
//
//	 @Test
//	 void test5() {  // three card와 1 pair가 같이 있으면, full house
//	  Card[] cArr = { new Card(2, "S"), new Card(2, "S")
//	           ,new Card(2, "D"), new Card(4, "H")
//	           ,new Card(4, "S")};
//	  assertTrue(rankCheck(cArr).equals("full house"));
//	 }
//
//	 @Test
//	 void test6() {  // 같은 무늬 5장이면 flush
//	  Card[] cArr = { new Card(5, "S"), new Card(2, "S")
//	           ,new Card(7, "S"), new Card(4, "S")
//	           ,new Card(4, "S")};
//	  assertTrue(rankCheck(cArr).equals("flush"));
//	 }
//
//	 @Test
//	 void test1() {  // 숫자가 연속이면 straight. 3,4,5,6,7
//	  Card[] cArr = { new Card(1, "S"), new Card(2, "S")
//	           ,new Card(3, "D"), new Card(4, "H")
//	           ,new Card(5, "S")};
//	  assertTrue(rankCheck(cArr).equals("straight"));
//	 }
//
	 @Test
	 void test11() {  // straight이면서 flush이면 staight flush
	  Card[] cArr = { new Card(1, "S"), new Card(2, "S")
	           ,new Card(3, "S"), new Card(4, "S")
	           ,new Card(5, "S")};
	  assertTrue(rankCheck(cArr).equals("straight flush"));
	 }
//	 
//	 @Test
//	 void test12() {  // 아무것도 아니면 no rank
//	  Card[] cArr = { new Card(8, "S"), new Card(2, "S")
//	           ,new Card(3, "D"), new Card(4, "S")
//	           ,new Card(5, "S")};
//	  assertTrue(rankCheck(cArr).equals("no rank"));
//	 }

}

class Card {
	static final int CARDNUM = 10;
	int num;
	String kind;
	
	Card(){this(1,"S");}
	Card(int num, String kind) {
		this.num = num;
		this.kind = kind;
	}
}
