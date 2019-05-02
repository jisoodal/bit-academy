package linkedList;

import java.util.*;

public class HashMapExample2 {

	public static void main(String[] args) {
		HashMap<Name, Integer> hashtable = new HashMap<Name, Integer>();
		Name name = new Name("�츣�̿´�","�׷�����");
		hashtable.put(new Name("�ظ�", "����"), new Integer(95));
//		hashtable.put(new Name("�츣�̿´�", "�׷�����"), new Integer(100));
		hashtable.put(name, new Integer(100));
		hashtable.put(new Name("��", "����"), new Integer(85));
		hashtable.put(new Name("�巹����", "������"), new Integer(93));
		hashtable.put(new Name("�׺�", "�չ���"), new Integer(70));
		Integer num = hashtable.get(name);
		System.out.println("�츣�̿´� �׷������� ������? "+num);

	}
}

class Name{
	String firstName;
	String lastName;
	Name(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
//	public boolean equals(Object obj) { // Object�� equals�� �ּҰ����� ����(���� �ֿ��� ��) �������̵� �����ν� ��� �����Ѿ��� ���ϴ� ����� ����
//		if(!(obj instanceof Name)) // ���� �뿡 ���� �����Ͱ� ��������� ��� �����͸� ���Ұ�����.
//			return false;
//		Name name = (Name) obj;
//		if(firstName.equals(name.firstName) && lastName.equals(name.lastName))
//			return true;
//		else
//			return false;
//	}
	public int hashCode() { // �������̵����� �ʴ´ٸ� Object�� �ִ� hashcode ��� hashcode�� ����
		 return firstName.hashCode() + lastName.hashCode();
	 }
}
