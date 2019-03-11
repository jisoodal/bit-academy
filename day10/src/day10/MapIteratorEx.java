package day10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapIteratorEx {

	public static void main(String[] args) {
		Map map = new HashMap();
		
		Iterator list = map.keySet().iterator();
		
		map.put(1, "1234");
		map.put(2, "1234");
		map.put("id3", "5678");
		map.put("id4", "9999");
		
		System.out.println(map.get(1));
		
		while(list.hasNext()) {	// 읽어오려면 어떻게해야..?
			Object obj = list.next();
			System.out.println(obj);
		}

	}

}
