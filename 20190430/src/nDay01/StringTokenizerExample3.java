package nDay01;

import java.util.*;

class StringTokenizerExample3 {
	public static void main(String args[]) {
		StringTokenizer stok = new StringTokenizer("���=10|���ݷ�=3|������=1", "=|", true);
		while (stok.hasMoreTokens()) {
			String token = stok.nextToken();
			if (token.equals("="))
				System.out.print("==");
			else if (token.equals("|"))
				System.out.print("\n");
			else
				System.out.print(token);
		}
	}
}