package networkProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

class ReceiverThread extends Thread{
	
	Socket socket;
	
	ReceiverThread() {
	}
	
	ReceiverThread(Socket socket) { // socket 객체 전달받음
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader( 
					new InputStreamReader(socket.getInputStream())); 
			// socket.getInputStream -> byteStream으로 읽음
			// InputStreamReader -> 문자 Stream으로 읽음
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				System.out.println("수신>"+str);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
