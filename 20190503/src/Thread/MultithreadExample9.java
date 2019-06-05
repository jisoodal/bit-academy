package Thread;

public class MultithreadExample9 {

	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		MonitorThread thread3 = new MonitorThread(thread1);
		// MonitorThread thread3 = new MonitorThread(thread2);
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj;
		thread2.sharedArea = obj;
		thread1.start();
		thread2.start();
		thread3.start();

	}

}

class CalcThread2 extends Thread{
	SharedArea3 sharedArea;
	public void run() {
		double total = 0.0;
		for(int cnt=1;cnt<1000;cnt+=2)
			if(cnt / 2 % 2 == 0)
				total += 1.0 / cnt;
			else
				total -= 1.0/cnt;
		sharedArea.result = total * 4;
		sharedArea.isReady = true;
		synchronized (sharedArea) {
			sharedArea.notify();
		}
	}
}

class SharedArea3{
	
	double result;
	boolean isReady;
}

class PrintThread3 extends Thread{
	
	SharedArea3 sharedArea;
	public void run() {
		if(sharedArea.isReady != true) {
			synchronized (sharedArea) {
				try {
					sharedArea.wait();
				}
				catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		System.out.println(sharedArea.result);
	}
}

class MonitorThread extends Thread {
	Thread thread;
	MonitorThread(Thread thread) {
		this.thread = thread;
	}
	public void run( ) {
		while(true) {
			Thread.State state = thread.getState();
			System.out.println("쓰레드의 상태: "+state);
			if(state == Thread.State.TERMINATED)
				break;
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}