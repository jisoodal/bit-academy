package networkProgramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientExample1 {

	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1", 9000); // 127.0.0.1 -> 컴퓨터 내부에서 사용하는 IP주소
			InputStream in = socket.getInputStream(); // 수신용 객체
			OutputStream out = socket.getOutputStream(); // 송신용 객체
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
