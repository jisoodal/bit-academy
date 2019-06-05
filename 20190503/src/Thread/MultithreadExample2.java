package Thread;

public class MultithreadExample2 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread2();
		Thread thread2 = new DigitThread2();
		Thread thread3 = new AlphabetThread();
		thread1.start();
		thread2.start();
		thread3.start();

	}
}

class DigitThread2 extends Thread {
	public void run() {
		for(int cnt = 0; cnt<10;cnt++) {
			System.out.println(cnt);
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

class AlphabetThread extends Thread{
	public void run() {
		for(char ch = 'A'; ch<= 'Z'; ch++) {
			System.out.println(ch);
		}
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
