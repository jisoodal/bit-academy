package program;

import java.util.ArrayList;

public class Example {
	
	static ArrayList<SungJuk> sungJukList = new ArrayList<SungJuk>(); // 이걸 메인 메서드 안에서 정의하면 안됨!!!!!!!!
	static ArrayList<PersonInfo> personList = new ArrayList<PersonInfo>();

	public static void main(String[] args) {
//		static final int MAX = 100;
		inputSungjuk();
		inputPerson();
		printSungjuk();
		printPerson();
	}
public static void inputSungjuk() {
	SungJuk sungjuk = new SungJuk();
	int MAX = 100;
	
	System.out.println("\t*** 성적입력 ***\t");
	
	for(int i=0;i<100;i++) {
		sungjuk.input();
		if(sungjuk.hakbun.equals("exit")) {
			break;
		}
		sungJukList.add(i,sungjuk);
	
	}
}

public static void inputPerson() {
	PersonInfo person = new PersonInfo();
	int MAX = 100;
	
	System.out.println("\t*** 정보입력 ***\t");
	
	for(int i=0;i<100;i++) {
		person.input();
		if(person.hakbun.equals("exit")) {
			break;
		}
		personList.add(person);
	}
}
	
public static void printSungjuk() {
	SungJuk sungjuk = new SungJuk();
	System.out.println("\t*** 성적표 ***\t");
	System.out.println("=======================================");
	System.out.println("학번\t이름\t국어\t영어\t수학\t총점\t평균\t등급\t");
	
	for(int i=0;i<sungJukList.size();i++) {
		sungJukList.get(i).output();
	}
}
	
public static void printPerson() {
	PersonInfo person = new PersonInfo();
	System.out.println();
	System.out.println("\t*** 개인정보 ***\t");
	System.out.println("==========================");
	System.out.println("학번\t이름\t전화번호\t주소");
	
	for(int i=0;i<personList.size();i++) {
		personList.get(i).output();
	}
}

}