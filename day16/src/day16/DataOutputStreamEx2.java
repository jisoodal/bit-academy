package day16;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class DataOutputStreamEx2 {

	public static void main(String[] args) {
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		
		byte[] result = null;
		
		try {
			
			Properties sysProp = System.getProperties();
			
			sysProp.list(System.out);
					
//			Set<String> key = sysProp.keys();
//			Iterator<String> it = key.iterator();
//			
//			while(it.hasNext()) {
//				sysProp.get(it.next());
//			}
			
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
			result = bos.toByteArray();
			
			String[] hex = new String[result.length];
			
			for(int i=0;i<result.length;i++) {
				if(result[i]<0) {
					hex[i] = String.format("%o2x", result[i]+256);
				} else {
					hex[i] = String.format("%02x", result[i]);
				}
			}
			System.out.println("10진수 : " +Arrays.toString(result));
			System.out.println("16진수 : " +Arrays.toString(hex));
		
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
