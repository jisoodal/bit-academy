package ch11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Exercise11_5 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(new Student("ȫ�浿",1,1,100,100,100));
		list.add(new Student("���ü�",1,2,90,70,80));
		list.add(new Student("���ڹ�",1,3,80,80,90));
		list.add(new Student("���ڹ�",1,4,70,90,70));
		list.add(new Student("���ڹ�",1,5,60,100,80));
		
		Collections.sort(list); // String�̸� ������ ���� ���� ����!! Object�� ��� ���� ��������� ��.
		Iterator it = list.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
	}
}

class Student implements Comparator{
	String name;
	int		ban;
	int		no;
	int		kor,eng,math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int) ((getTotal()/3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name + "," + ban +","+no+"," +kor+","+eng+","+math
				+","+getTotal()+","+getAverage();
	}
	
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			return c1.compareTo(c2);
		}
		return -1;
	}
}
