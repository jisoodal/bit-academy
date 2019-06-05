package Thread;

public class MultithreadExample1 {

	public static void main(String[] args) {
		Thread thread = new DigitThread(); // �����带 ����
		thread.start(); // �����带 ���� -> DigitThreadŬ������ run �޼��带 ����
		for(char ch = 'A'; ch <= 'Z';ch++) {
			System.out.print(ch);
		}
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}

class DigitThread extends Thread {
	public void run() {
		for(int cnt = 0; cnt<10; cnt++) {
			System.out.print(cnt);
		}
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	} 
}
