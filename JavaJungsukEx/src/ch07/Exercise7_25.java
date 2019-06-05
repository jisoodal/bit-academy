package ch07;

import ch07.Outer.Inner;

public class Exercise7_25 {

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		Outer.Inner in = outer.new Inner();
		
		System.out.println(in.iv);
		

	}

}

class Outer {
	class Inner {
		int iv = 100;
	}
}