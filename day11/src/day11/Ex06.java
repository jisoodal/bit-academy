package day11;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Student implements Comparable {
	String name;
	int	   ban;
	int	   no;
	int    kor, eng, math;
	
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no= no;
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
		return name
				+","+ban
				+","+no
				+","+kor
				+","+eng
				+","+math
				+","+getTotal()
				+","+getAverage()
				;		
	}
	
	public int compareTo(Object o) {
		if(o instanceof Student) {
			Student tmp = (Student)o;
			
			return name.compareTo(tmp.name);
			} else {
				return -1;
			}
	}
}
//
public class Ex06 {
	static int getGroupCount (TreeSet tset, int from, int to) {
		// 범위를 from과 to로 넘겨받는다.
		// tset의 평균이 from과 to 사이에 있으면 count, 그 사이에 있지 않으면 count 하지 않는다.
		// tset의 평균을 어떻게 빼오지?
		
		Student s1 = new Student("",0,0,from,from,from);
		Student s2 = new Student("",0,0,to,to,to);
		// toString과 헷갈리지 말자!! from과 to사이의 객체를 나열하여 비교해주면 됨 기준만 주면!
		
		return tset.subSet(s1,s2).size();
		
	}
	public static void main(String[] args) {
		// 학생들의 평균을 기준으로 정렬하게끔 compare(Object o1, Object o2)와
		// 평균점수의 범위를 주면 해당 범위에 속한 학생의 수를 반환하는
		// 여기에는 정렬 기준을 내주면 된다.
		TreeSet set = new TreeSet
				(new Comparator() {
					// 정렬기준을 어떻게 낼 것인가?
					// 결과를 보니 평균 순으로 정렬해야 한다.
			public int compare(Object o1, Object o2) { // 두 객체를 비교한다
					if(o1 instanceof Student && o2 instanceof Student) {
						Student s1 = (Student)o1;
						Student s2 = (Student)o2;
						
						return (int)(s1.getAverage()-s2.getAverage());
						// int는 빼서 비교!!!!!!!!!!!!
						}
							return -1;
				}
		});
		
		set.add(new Student("홍길동",1,1,100,100,100));
		set.add(new Student("남궁성",1,2,90,70,80));
		set.add(new Student("김자바",1,3,80,80,90));
		set.add(new Student("이자바",1,4,70,90,70));
		set.add(new Student("안자바",1,5,60,100,80));
		
		Iterator it = set.iterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
		System.out.println("[60~69] :"+getGroupCount(set,60, 70));
		System.out.println("[70~79] :"+getGroupCount(set,70, 80));
		System.out.println("[80~89] :"+getGroupCount(set,80, 90));
		System.out.println("[90~100] :"+getGroupCount(set,90, 101));
	}

}
