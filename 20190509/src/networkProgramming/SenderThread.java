package networkProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class SenderThread extends Thread { // 송신에 사용되는 thread
	
	Socket socket;
	
	SenderThread() {
	}
	
	SenderThread(Socket socket){
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader( // 키보드로 입력한 내용을 socket객체를 통해서 수신하겠다.
					new InputStreamReader(System.in));
			PrintWriter writer = new PrintWriter(socket.getOutputStream()); // 송신용 객체.(byteStream 방식) Writer로 끝나면 문자 Stream
			while(true) {
				String str = reader.readLine(); // 키보드로부터 입력받은 입력 객체.(readLine으로 읽음)
				if(str.equals("bye"))
					break;
				writer.println(str); // 송신용 객체 writer
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
