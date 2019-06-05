package guiProgramming;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SungJuk {

	String hakbun, name, grade;
	int kor, eng, math, total;
	double avg;

	Scanner scanner = new Scanner(System.in);
	
	SungJuk(){
	}
	
	SungJuk(String hakbun, String name, int kor, int eng, int math) {
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		process();
	}

	public void input() {
		// �й�, �̸�, ����, ����, ���� �Է� �޴� �޼���
		
		System.out.print("�й� �Է� =>");
		hakbun = scanner.nextLine();
		
		System.out.print("�̸� �Է� =>");
		name = scanner.nextLine();

		System.out.print("����  �Է� =>");
		kor = Integer.parseInt(scanner.nextLine());

		System.out.print("���� �Է� =>");
		eng = Integer.parseInt(scanner.nextLine());

		System.out.print("���� �Է� =>");
		math = Integer.parseInt(scanner.nextLine());
		
		process();
	}

	public void process() {
		// ����, ���, ��� ����ϴ� �޼���

		// ���� ���
		total = kor + eng + math;

		// ��� ���
		avg = total / 3;

		// ��� ���
		switch((int)avg/10) {
		
		case 10:
		case 9:
			grade = "A";
			break;
		
		case 8:
			grade = "B";
			break;
		
		case 7:
			grade = "C";
			break;
			
		case 6:
			grade = "D";
			break;
			
		default:
			grade = "F";
			break;
			
		}
	}

	public String toString() {
		// �й����� ��ޱ��� ������ִ� �޼���
//		process();

		return hakbun + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + avg + "\t" + grade;
	}

	public String getEach() {
		
				return "�й�:"+this.hakbun+"\n"
						+"�̸�:"+this.name+"\n"
						+"����:"+this.kor+"\n"
						+"����:"+this.eng+"\n"
						+"����:"+this.math+"\n"
						+"����:"+this.total+"\n"
						+"���:"+this.avg+"\n"
						+"���:"+this.grade+"\n";
	}
	
	public int hashCode() {
		return hakbun.hashCode();
	}
	
	public boolean equals(Object obj) {
		 if (!(obj instanceof SungJuk))
		 return false;
		 SungJuk sungjuk = (SungJuk) obj;
		 if (hakbun.equals(sungjuk.hakbun))
		 return true;
		 else
		 return false;
	} 
	
	public String getHakbun() {
		return this.hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

}
