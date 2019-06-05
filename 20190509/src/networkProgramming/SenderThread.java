package networkProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SenderThread extends Thread { // �۽ſ� ���Ǵ� thread
	
	Socket socket;
	
	SenderThread() {
	}
	
	SenderThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader( // Ű����� �Է��� ������ socket��ü�� ���ؼ� �����ϰڴ�.
					new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); // �۽ſ� ��ü.(byteStream ���) Writer�� ������ ���� Stream
			while(true) {
				String str = reader.readLine(); // Ű����κ��� �Է¹��� �Է� ��ü.(readLine���� ����)
				if(str.equals("bye"))
					break;
				writer.println(str); // �۽ſ� ��ü writer
				writer.flush();
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch(Exception ignored) {
			}
		}
	}
	
	
}
