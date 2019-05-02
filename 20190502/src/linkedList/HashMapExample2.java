package linkedList;

import java.util.*;

public class HashMapExample2 {

	public static void main(String[] args) {
		HashMap<Name, Integer> hashtable = new HashMap<Name, Integer>();
		Name name = new Name("헤르미온느","그레인져");
		hashtable.put(new Name("해리", "포터"), new Integer(95));
//		hashtable.put(new Name("헤르미온느", "그레인져"), new Integer(100));
		hashtable.put(name, new Integer(100));
		hashtable.put(new Name("론", "위즐리"), new Integer(85));
		hashtable.put(new Name("드레이코", "말포이"), new Integer(93));
		hashtable.put(new Name("네빌", "롱버텀"), new Integer(70));
		Integer num = hashtable.get(name);
		System.out.println("헤르미온느 그레인져의 성적은? "+num);

	}
}

class Name{
	String firstName;
	String lastName;
	Name(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
//	public boolean equals(Object obj) { // Object의 equals는 주소값으로 비교함(같은 애여야 함) 오버라이딩 함으로써 어떻게 동일한앤지 비교하는 방법을 제공
//		if(!(obj instanceof Name)) // 같은 통에 여러 데이터가 담겨있을때 어떻게 데이터를 비교할것인지.
//			return false;
//		Name name = (Name) obj;
//		if(firstName.equals(name.firstName) && lastName.equals(name.lastName))
//			return true;
//		else
//			return false;
//	}
	public int hashCode() { // 오버라이드하지 않는다면 Object에 있는 hashcode 대로 hashcode를 생성
		 return firstName.hashCode() + lastName.hashCode();
	 }
}
