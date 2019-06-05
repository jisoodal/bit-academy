package ch07;

public class Exercise7_26 {

	public static void main(String[] args) {
		Outer3.Inner in = new Outer3.Inner();
		
		System.out.println(in.iv);

	}

}

class Outer3{
	static class Inner{
		int iv = 200;
	}
}
