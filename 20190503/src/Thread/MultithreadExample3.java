package Thread;

public class MultithreadExample3 {

	public static void main(String[] args) {
		Thread thread = new Thread(new SmallLetters());
		thread.start();
		char arr[] = {'��','��','��','��','��','��',
				'��','��','��','��','��','��','��','��'};
		
		for(char ch: arr)
			System.out.print(ch);

	}
}

class SmallLetters implements Runnable {
	public void run() {
		for(char ch = 'a' ;ch<= 'z'; ch++)
			System.out.print(ch);
	}
}
