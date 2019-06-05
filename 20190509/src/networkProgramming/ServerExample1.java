package networkProgramming;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {
	
	// 패키지 안에 파일을 만들었을 경우 cmd창에서 실행 시 패키지의 부모 디렉터리(이 클래스의 경우 src)로 올라가서 java 패키지명.파일명으로 실행해야 함!!

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(9000);
			socket = serverSocket.accept(); // 1. 클라이언드에서 out.write하는 순간 accept로 서버에서 받음
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			byte arr[] = new byte[100];
			in.read(arr); // 3.
			System.out.println(new String(arr));
			String str = "Hello, Client";
			out.write(str.getBytes()); // 4. 클라이언트의 in.read가 수신
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
