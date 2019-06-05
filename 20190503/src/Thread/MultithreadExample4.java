package Thread;

public class MultithreadExample4 {

	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj; // 같은 곳 가리킴
		thread2.sharedArea = obj;
		thread1.start();
		thread2.start();
	}
}

class CalcThread extends Thread {
	SharedArea sharedArea;
	public void run() {
		double total = 0.0;
		for(int cnt = 1;cnt<100;cnt +=2) {
			if(cnt/2 %2 == 0)
				total += 1.0/cnt;
			else
				total -= 1.0 / cnt;
			
		}
		sharedArea.result = total * 4;
		sharedArea.isFinished = true;
	}
}

class SharedArea{
	double result;
	
	boolean isFinished;
}

class PrintThread extends Thread{
	SharedArea sharedArea;
	
	public void run() {
		while(true) { // 끝날때까지 반복하면서 돌고있다가 CountThread가 끝날 때 break 하고 print를 실행함
			// if문을 사용하면 한 번만 돌기 때문에!!!!!
			if(sharedArea.isFinished) {
				break;
			}
		}
		
		System.out.println(sharedArea.result);
		
	}
}







