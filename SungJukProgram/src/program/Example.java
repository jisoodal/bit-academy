package program;

import java.util.ArrayList;

public class Example {
	
	static ArrayList<SungJuk> sungJukList = new ArrayList<SungJuk>(); // �̰� ���� �޼��� �ȿ��� �����ϸ� �ȵ�!!!!!!!!
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
	
	System.out.println("\t*** �����Է� ***\t");
	
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
	
	System.out.println("\t*** �����Է� ***\t");
	
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
	System.out.println("\t*** ����ǥ ***\t");
	System.out.println("=======================================");
	System.out.println("�й�\t�̸�\t����\t����\t����\t����\t���\t���\t");
	
	for(int i=0;i<sungJukList.size();i++) {
		sungJukList.get(i).output();
	}
}
	
public static void printPerson() {
	PersonInfo person = new PersonInfo();
	System.out.println();
	System.out.println("\t*** �������� ***\t");
	System.out.println("==========================");
	System.out.println("�й�\t�̸�\t��ȭ��ȣ\t�ּ�");
	
	for(int i=0;i<personList.size();i++) {
		personList.get(i).output();
	}
}

}