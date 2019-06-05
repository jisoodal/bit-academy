package networkProgramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample1 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9000); // 127.0.0.1 -> ��ǻ�� ���ο��� ����ϴ� IP�ּ�
			InputStream in = socket.getInputStream(); // ���ſ� ��ü
			OutputStream out = socket.getOutputStream(); // �۽ſ� ��ü
			String str = "Hello, Server";
			out.write(str.getBytes()); // 2.
			byte arr[] = new byte[100];
			in.read(arr); // 5.
			System.out.println(new String(arr));
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
		}

	}

}
