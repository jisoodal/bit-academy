package Thread;

public class MultithreadExample4 {

	public static void main(String[] args) {
		CalcThread thread1 = new CalcThread();
		PrintThread thread2 = new PrintThread();
		SharedArea obj = new SharedArea();
		thread1.sharedArea = obj; // ���� �� ����Ŵ
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
		while(true) { // ���������� �ݺ��ϸ鼭 �����ִٰ� CountThread�� ���� �� break �ϰ� print�� ������
			// if���� ����ϸ� �� ���� ���� ������!!!!!
			if(sharedArea.isFinished) {
				break;
			}
		}
		
		System.out.println(sharedArea.result);
		
	}
}







