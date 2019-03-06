package day9;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {

	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		list1.add(new Integer(5));
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1,4)); // 1부터 4사이에 저장된 객체들을 반환한다. -> 4,2,0
		print(list1, list2);
		
		Collections.sort(list1); // list1과 list2를 정렬한다. (오름차순으로)
		Collections.sort(list2);
		print(list1,list2);
		
		System.out.println("list1.contatinsAll(list2):" // list1이 list2에 있는 값들을 포함하고 있는지
												+list1.containsAll(list2)); // true
		
		list2.add("B");
		list2.add("C");
		list2.add(3,"A");
		print(list1, list2);
		
		list2.set(3,  "AA");
		print(list1, list2);
		
		System.out.println("list1.retainAll(list2):"
											+list2.retainAll(list2));
		
		print(list1, list2);
		
		for(int i= list2.size()-1;i>=0;i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1, list2);

	}

	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}
}
