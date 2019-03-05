package day8;

public class WrapperEx3 {

	public static void main(String[] args) {
		int i = 10;
		
		Integer intg = (Integer)i; // intg = 10
		Object obj = (Object)i; // 10
		
		Long	lng = 100L;
		
		int i2 = intg + 10; // 10+10  = 20 참조형과 기본형간의 연산 가능
		long l = intg + lng; // 10 +100L = 110 참조형 간의 덧셈도 가능
		
		Integer intg2 = new Integer(20);
		int i3 = (int)intg2; 
		
		Integer intg3 = intg2 + i3;
		
		System.out.println("i            = "+i);
		System.out.println("intg         = "+intg);
		System.out.println("obj          = "+obj);
		System.out.println("lng          = "+lng);
		System.out.println("intg+10      = "+i2);
		System.out.println("intg+lng     = "+l);
		System.out.println("intg2        = "+intg2);
		System.out.println("i3           = "+i3);
		System.out.println("intg2+i3     = "+intg3);
		

	}

}
