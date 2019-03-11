//package day11;
//
//import java.util.TreeSet;
//
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.TreeSet;
//
//class Student3 implements Comparable {
//	String name;
//	int	   ban;
//	int	   no;
//	int    kor, eng, math;
//	
//	Student3(String name, int ban, int no, int kor, int eng, int math) {
//		this.name = name;
//		this.ban = ban;
//		this.no= no;
//		this.kor = kor;
//		this.eng = eng;
//		this.math = math;
//	}
//	
//	int getTotal() {
//		return kor+eng+math;
//	}
//	float getAverage() {
//		return (int) ((getTotal()/3f)*10+0.5)/10f;
//	}
//	public String toString() {
//		return name
//				+","+ban
//				+","+no
//				+","+kor
//				+","+eng
//				+","+math
//				+","+getTotal()
//				+","+getAverage()
//				;		
//	}
//	
//	public int compareTo(Object o) {
//		if(o instanceof Student3) {
//			Student3 tmp = (Student3)o;
//			
//			return name.compareTo(tmp.name);
//			} else {
//				return -1;
//			}
//	}
//}
//
//public class TreeTest {
//
//	public static void main(String[] args) {
//		
//		TreeSet set = new TreeSet();
//		
//		set.add(new Student("홍길동",1,1,100,100,100));
//		set.add(new Student("남궁성",1,2,90,70,80));
//		set.add(new Student("김자바",1,3,80,80,90));
//		set.add(new Student("이자바",1,4,70,90,70));
//		set.add(new Student("안자바",1,5,60,100,80));
//		
//		
//		
//	static int getGroupCount (TreeSet tset, int from, int to) {
//		// 범위를 from과 to로 넘겨받는다.
//		// tset의 평균이 from과 to 사이에 있으면 count, 그 사이에 있지 않으면 count 하지 않는다.
//		// tset의 평균을 어떻게 빼오지?		
//		Object[] obj = tset.toArray();
//		int count = 0;
//		
//		System.out.println(tset.);
//		
//		
//		System.out.println("[60~69] :"+getGroupCount(set,60, 70));
//		System.out.println("[70~79] :"+getGroupCount(set,70, 80));
//		System.out.println("[80~89] :"+getGroupCount(set,80, 90));
//		System.out.println("[90~100] :"+getGroupCount(set,90, 101));
//
//	}
//
//}
