package day9;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyVectorTest02 {

	public static void main(String[] args) {
		MyVector v = new MyVector();
		
		v.add("a"); //0
		v.add("2"); //1
		v.add("3"); //2
		v.add("tt"); //3 삭제
		v.add("hihi"); //4 - 3	
		v.add("z"); //5 - 4
		v.add("z1"); //6 - 5
		v.add("z2"); //7 삭제
		v.add("z3"); //8 삭제
		
		System.out.println(v.toString());
		
		v.remove("z3"); // size - 8
		v.remove("z2"); // size - 7
		v.remove("tt"); // size - 6
		
		System.out.println(v.toString());
		
		System.out.println(v.indexOf("z"));
		
		
		
	}

}
