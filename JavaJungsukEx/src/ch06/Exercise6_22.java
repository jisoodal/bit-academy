package ch06;

public class Exercise6_22 {

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str+"�� �����Դϱ�? "+isNumber(str));
		
		str = "1234o";
		System.out.println(str+"�� �����Դϱ�? "+isNumber(str));

	}
	
	public static boolean isNumber(String str) {
		
		boolean isNum = false;
		
		for(int i=0;i<str.length();i++) {
			// �� �̰� �ϳ��ϳ��� ������ ����������?
			// ĳ���Ͱ� ������ �װ� �������� ��� �Ǵ�����??
			if(0<= str.charAt(i)-'0' && str.charAt(i)-'0' <= 9) {
				isNum = true;
			} else
				isNum = false;
		}
		
		return isNum;	
	}
}
