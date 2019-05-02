package sungJukProgram;


import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SungJuk {

	String hakbun, name, grade;
	int kor, eng, math, total;
	double avg;

	Scanner scanner = new Scanner(System.in);

	public void input() {
		// �й�, �̸�, ����, ����, ���� �Է� �޴� �޼���
		
		System.out.print("�й� �Է� =>");
		hakbun = scanner.nextLine();
		
		if(MainSungJukHash.sungJukMap.containsKey(hakbun)) {
			System.out.println("�̹� �����ϴ� �й��Դϴ�.");
			return;
		}

		
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

}
