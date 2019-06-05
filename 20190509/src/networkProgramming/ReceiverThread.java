package networkProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

class ReceiverThread extends Thread{
	
	Socket socket;
	
	ReceiverThread() {
	}
	
	ReceiverThread(Socket socket) { // socket ��ü ���޹���
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader reader = new BufferedReader( 
					new InputStreamReader(socket.getInputStream())); 
			// socket.getInputStream -> byteStream���� ����
			// InputStreamReader -> ���� Stream���� ����
			while(true) {
				String str = reader.readLine();
				if(str == null)
					break;
				System.out.println("����>"+str);
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
