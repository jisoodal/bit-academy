package networkProgramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {
	
	// ��Ű�� �ȿ� ������ ������� ��� cmdâ���� ���� �� ��Ű���� �θ� ���͸�(�� Ŭ������ ��� src)�� �ö󰡼� java ��Ű����.���ϸ����� �����ؾ� ��!!

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept(); // 1. Ŭ���̾�忡�� out.write�ϴ� ���� accept�� �������� ����
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			byte arr[] = new byte[100];
			in.read(arr); // 3.
			System.out.println(new String(arr));
			String str = "Hello, Client";
			out.write(str.getBytes()); // 4. Ŭ���̾�Ʈ�� in.read�� ����
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				socket.close();
			}
			catch (Exception ignored) {
			}
			try {
				serverSocket.close();
			}
			catch (Exception ignored) {
			}
		}

	}

}
