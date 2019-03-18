package day17;

import java.net.*;
import java.io.*;

public class TcpIpClient {

	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			
			System.out.println(serverIp);
			
			Socket socket = new Socket(serverIp, 7777);
			
			InputStream in = socket.getInputStream();
			DataInputStream dis = new DataInputStream(in);
			
			System.out.println(dis.readUTF());
			
			dis.close();
			socket.close();
		} catch(ConnectException ce) {
			ce.getStackTrace();
		} catch(IOException ie) {
			ie.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
