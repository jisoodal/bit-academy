package wordScrambleEx;

public class WordScrambleEx1 {

	public static void main(String[] args) {
		String[] strArr = {"CHANGE", "LOVE", "HOPE", "VIEW"};
		
		String answer = getAnswer(strArr);
		String question = getScrambledWord(answer);
		
		System.out.println("Question:"+question);
		System.out.println("Answer:"+answer);
	} // main
	
	public static String getAnswer(String[]strArr) {
		// 배열 strArr의 요소 중 하나를 임의로 골라서 반환한다.(Math.random() 사용
		int i = (int)(Math.random()*strArr.length);
		return strArr[i];
	}
	
	public static String getScrambledWord(String str) {
		// 주어진 문자열 str의 각 문자의 순서를 뒤섰은 다음, 새로운 문자열로 반환한다.(Math.random())
		char[] c = str.toCharArray();
		
		// 한글자씩 섞기
		
		for(int i=0;i<str.length();i++) {
			int r= (int)(Math.random()*str.length());
			char tmp = c[0];
			c[0] = c[r];
			c[r] = tmp;
		}
		return str.valueOf(c);
	}
}
