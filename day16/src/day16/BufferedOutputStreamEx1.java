package day16;

import java.io.*;

public class BufferedOutputStreamEx1 {

	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
			
			for(int i='1';i<='9';i++) {
				bos.write(i);
			}
//			bos.flush();
//			fos.close();
			
			bos.close(); // 보조를 먼저 닫아야함. 얘가 flush도 해준다. 보조가 닫히면 기반도 닫힘. buffer문제 조심
//			fos.close(); // 기반 스트림을 닫는다
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
