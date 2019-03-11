package day11;

import java.util.ArrayList;

public class Ex01 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		ArrayList kyo = new ArrayList();
		ArrayList cha = new ArrayList();
		ArrayList hap = new ArrayList();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		// kyo
		
		for(int i=0;i<list1.size();i++) {
			for(int j=0;j<list2.size();j++) {
			if(list1.get(i) == list2.get(j)) // 일치하면 add
				kyo.add(list1.get(i));
			}
		}
		
		// cha
		

		for(int i=0;i<cha.size();i++) {
			System.out.println(cha.get(i));
		}
		
		// hap
//		
//		for(int i=0;i<list1.size();i++) {
//			System.out.println(list1.get(i));
//		}
////		
//		for(int i=0;i<list1.size();i++) {
//			hap.add());
//		}
//		
		
		
		
	}
}
