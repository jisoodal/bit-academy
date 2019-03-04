package day5;

public class DeckTest {

	public static void main(String[] args) {
		Deck d = new Deck();		// 카드 한 벌(Deck)을 만든다.
		Card c = d.pick(0);			// 섞기 전에 제일 위의 카드를 뽑는다.
		System.out.println(c);		// System.out.println(c.toString());과 같다.
		
		d.shuffle();				// 카들ㄹ 섞는다.
		c = d.pick(0);				// 섞은 후에 제일 위의 카드를 뽑는다.
		System.out.println(c);
	}
}
	class Deck {
		final int CARD_NUM = 52;		// 카드의 개수
		Card cardArr[] = new Card[CARD_NUM];
		
		Deck () {
			int i=0;
			
			for(int k=Card.KIND_MAX; k>0;k--)
				for(int n=0; n<Card.NUM_MAX;n++)
					cardArr[i++] = new Card(k, n+1);
		}
		
		Card pick(int index) {
			return cardArr[index];
		}
		
		Card pick() {
			int index = (int)(Math.random()*CARD_NUM);
			return pick(index);
		}
		
		void shuffle() { 
			for(int i=0; i<cardArr.length;i++) {
				int r = (int)(Math.random() * CARD_NUM);
				
				Card temp = cardArr[i];
				cardArr[i] = cardArr[r];
				cardArr[r] = temp;
			}
		}
	}
	
class Card {
	static final int KIND_MAX = 4; // 카드 종류 : 클로버, 하트, 다이아몬드, 스페이드
	static final int NUM_MAX = 13;
	
	static final int SPADE = 4; // kinds 배열의 자리수
	static final int DIAMONE = 3;
	static final int HEART = 2;
	static final int CLOVER = 1;
	int kind;
	int number;
	
	Card() {
		this(SPADE, 1); // 1 스페이드로 초기화
	}
	
	Card(int kind, int number) {
		this.kind = kind; // 값이 들어올 때 변경
		this.number = number;
	}
	
	public String toString() {
		String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"}; // 위에서 정의한 클래스 변수들 String 타입으로 변환
		String numbers = "0123456789XJQK"; // 
		
		return "kind : " + kinds[this.kind]
								+ ", number : " + numbers.charAt(this.number); // 카드 종류와 숫자 출력
	}
}
