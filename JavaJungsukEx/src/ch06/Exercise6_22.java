package ch06;

public class Exercise6_22 {

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"는 숫자입니까? "+isNumber(str));

	}
	
	public static boolean isNumber(String str) {
		
		boolean isNum = false;
		
		for(int i=0;i<str.length();i++) {
			// 아 이거 하나하나씩 돌리면 뭐가나오지?
			// 캐릭터가 나오면 그게 숫자인지 어떻게 판단하지??
			if(0<= str.charAt(i)-'0' && str.charAt(i)-'0' <= 9) {
				isNum = true;
			} else
				isNum = false;
		}
		
		return isNum;	
	}
}
