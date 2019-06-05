package ch06;

public class Exercise6_5 {

	public static void main(String[] args) {
		Student2 s = new Student2("ȫ�浿",1,1,100,60,76);
		
		System.out.println(s.info());

	}

}

class Student2 {
	
	String name;
	int ban, no, kor, eng, math, total;
	
	Student2() {
		
	}
	
	Student2(String name, int ban, int no, int kor, int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal() {

		return this.kor + this.eng + this.math;

	}

	public float getAverage() {

		return getTotal() / 3;
	}
	
	public String info() {
		return this.name+","+this.ban+","+this.no+","+this.kor+","+this.eng+","
				+this.math+","+getTotal()+","+getAverage();
	}
}
