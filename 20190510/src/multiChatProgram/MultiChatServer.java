package multiChatProgram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiChatServer {
	
	// ���� ���ϰ� Ŭ���̾�Ʈ ���� ����
	private ServerSocket ss = null;
	private Socket s = null;
	
	// ����� Ŭ���̾�Ʈ �����带 �����ϴ� ArrayList
	ArrayList <ChatThread> chatlist = new ArrayList<ChatThread>();
	
	// ��Ƽê ���� ���α׷���
	public void start() {
		try {
			// ���� ���� ����
			ss = new ServerSocket(8888);
			System.out.println("server start");
			
			// ���ѷ����� ���鼭 Ŭ���̾�Ʈ ������ ��ٸ�
			while(true) {
				s = ss.accept();
				// ����� Ŭ���̾�Ʈ���� ������ Ŭ���� ����
				ChatThread chat = new ChatThread();
				// Ŭ���̾�Ʈ ����Ʈ �߰�
				chatlist.add(chat);
				// ������ ����
				chat.start();
			}
		} catch(Exception e) {
			// System.out.println(e);
			System.out.println("[MultiChatServer]start() Exception �߻�!!");
		}
	}
	
	public static void main(String[] args) {
		MultiChatServer server = new MultiChatServer();
		server.start();
	}
	
	// ����� ��� Ŭ���̾�Ʈ�� �޽��� �߰�
	void msgSendAll(String msg) {
		for(ChatThread ct : chatlist) {
			ct.outMsg.println(msg);
		}
	}
	
	// �� Ŭ���̾�Ʈ ������ ���� ������ Ŭ����
	class ChatThread extends Thread {
		
		// ���� �޽����� �Ľ� �޽��� ó���ϴ� ���� ����
		String msg;
		String[] rmsg;
		
		// ����� ��Ʈ�� ����
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;
		
		public void run() {
			
			boolean status = true;
			System.out.println("##ChatThread start...");
			try {
				// ����� ��Ʈ�� ����
				inMsg = new BufferedReader(
						new InputStreamReader(s.getInputStream()));
				outMsg = new
						PrintWriter(s.getOutputStream(), true);
				
				// ���������� true�� ������ ���鼭 ��������׼� ���ŵ� �޽��� ó��
				while(status) {
					// ���ŵ� �޽����� msg ������ ����
					msg = inMsg.readLine();
					// '/' �����ڸ� �������� �޽����� ���ڿ� �迭�� �Ľ�
					rmsg = msg.split("/");
					
					// �Ľ̵� ���ڿ� �迭�� �ι�° ��Ұ��� ���� ó��
					// �α׾ƿ� �޽����� ��
					if(rmsg[1].equals("logout")) {
						chatlist.remove(this);
						msgSendAll("server/" + rmsg[0] + "���� �����߽��ϴ�.");
						// �ش� Ŭ���̾�Ʈ ������ ����� ���� status�� false�� ����
						status = false;
					}
					// �α��� �޽����� ��
					else if(rmsg[1].equals("login")) {
						msgSendAll("server/"+rmsg[0]+"���� �α����߽��ϴ�.");
					}
					// �� ���� �Ϲ� �޽����� ��
					else {
						msgSendAll(msg);
					}
				} // while ����
				// ������ ����� Ŭ���̾�Ʈ ������ ����ǹǷ� ������ ���ͷ�Ʈ��
				this.interrupt();
				
				System.out.println("##" + this.getName() + "stop!!");
			} catch(IOException e) {
				chatlist.remove(this);
				// e.printStackTrace();
				System.out.println("[ChatThread]run() IOException �߻�!!");
			}
		}
		
	}

}
