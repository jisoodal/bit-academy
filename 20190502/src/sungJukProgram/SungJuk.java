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
		// 학번, 이름, 국어, 영어, 수학 입력 받는 메서드
		
		System.out.print("학번 입력 =>");
		hakbun = scanner.nextLine();
		
		if(MainSungJukHash.sungJukMap.containsKey(hakbun)) {
			System.out.println("이미 존재하는 학번입니다.");
			return;
		}

		
		System.out.print("이름 입력 =>");
		name = scanner.nextLine();

		System.out.print("국어  입력 =>");
		kor = Integer.parseInt(scanner.nextLine());

		System.out.print("영어 입력 =>");
		eng = Integer.parseInt(scanner.nextLine());

		System.out.print("수학 입력 =>");
		math = Integer.parseInt(scanner.nextLine());
		
		process();
	}

	public void process() {
		// 총점, 평균, 등급 계산하는 메서드

		// 총점 계산
		total = kor + eng + math;

		// 평균 계산
		avg = total / 3;

		// 등급 계산
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
		// 학번부터 등급까지 출력해주는 메서드
//		process();

		return hakbun + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + avg + "\t" + grade;
	}

	public String getEach() {
		
				return "학번:"+this.hakbun+"\n"
						+"이름:"+this.name+"\n"
						+"국어:"+this.kor+"\n"
						+"영어:"+this.eng+"\n"
						+"수학:"+this.math+"\n"
						+"총점:"+this.total+"\n"
						+"평균:"+this.avg+"\n"
						+"등급:"+this.grade+"\n";
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
