package program;

import java.util.Scanner;

public class SungJuk extends Person implements Personable {

	int kor;
	int eng;
	int math;
	int total;
	double avg;
	String grade;

	Scanner scanner = new Scanner(System.in);

	@Override
	public void input() {
		System.out.print("학번:");
		hakbun = scanner.nextLine();

		System.out.print("이름 :");
		irum = scanner.nextLine();

		System.out.print("국어:");
		kor = Integer.parseInt(scanner.nextLine());

		System.out.print("영어:");
		eng = Integer.parseInt(scanner.nextLine());

		System.out.print("수학:");
		math = Integer.parseInt(scanner.nextLine());
		System.out.println();
	}

	@Override
	public void output() {
		process(kor, eng, math);
		System.out.print(hakbun + "\t" + irum + "\t" + kor + "\t" + eng + "\t" + math + "\t" + total + "\t" + avg + "\t"
				+ grade + "\t");
	}

	public void process(int kor, int eng, int math) {
		total = kor + eng + math;
		avg = (kor + eng + math) / 3;

		if (avg >= 90)
			grade = "A";

		else if (avg >= 80)
			grade = "B";

		else if (avg >= 70)
			grade = "C";

		else
			grade = "F";

	}
}
