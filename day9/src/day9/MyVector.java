package day9;

public class MyVector {
	
	// Q1. Object배열 objArr을 인스턴스 변수로 갖는 MyVector클래스를 선언하시오.
	
	// Q3. MyVector클래스에 객체배열에 저장된 객체의 개수를 저장하기 위한 인스턴스 변수 size를 추가
	Object[] objArr = null; // 일단 비어있는 상태로 선언
	int size = 0;
	int capacity = 0;
	
	// Q2. MyVector클래스에 생성자  MyVector(int capacity)와 기본 생성자(capacity=16)를 추가하시오.
	MyVector(int capacity) { // capacity 값을 지정해준 경우
		this.capacity = capacity; // 그 값을 capacity에 넣어준다
		objArr = new Object[capacity]; // capacity 크기만큼 objArr배열의 크기를 늘려준다.
	}
	
	MyVector() { // 기본 생성자
		this(16);
		this.capacity = 16; // capacity값이 넘어오지 않은 경우 기본값으로 16을 준다.
		objArr = new Object[capacity];
	}
	
	// Q4. MyVector클래스의 객체배열 objArr에 객체를 추가하는 메서드 void add(Object obj)를 작성하시오.
	void add(Object obj) {
		// 저장할 공간이 있는지 확인. 있으면 저장, 없으면 공간 늘려주기
		
		if(size == capacity()) { // 공간이 부족하면
			// 1. 공간을 늘려준다.
			// 2. 저장한다.
			Object[] tmpArr = new Object[capacity()*2];
			
			// 기존 내용(objArr)을 새로운 배열(tmpArr)에 복사한다.
			System.arraycopy(objArr, 0, tmpArr, 0, size);
			
			// 배열의 참조를 새로운 배열로 변경한다.
			objArr = tmpArr;
		}
//		else {
//			//그냥 저장
//		}
		// 저장하는 부분이 겹치므로 밖으로 뺀다.
		
		// 배열에 obj를 저장
		objArr[size++] = obj; // objArr배열에 객체를 추가함.
		// size값을 증가
	}
	
	// Q5. MyVector클래스의 객체배열 objArr에 저장된 객체를 반환하는 Object get(index)를 작성하시오.
	Object get(int index) { 
		if(!(0<= index && index < size)) // 입력받은 범위가 유효하지 않으면
			throw new IllegalArgumentException("index의 범위가 유효하지 않습니다."+index); // 예외
		return objArr[index]; // 유효하면 return
	} // index 번째의 객체를 반환.

	public int size() { return size;} // 변수의 값을 반환하는 size();
	public int capacity() { return objArr.length;} // 배열 objArr의 길이를 반환하는 capacity();
	public boolean isEmpty() {return size == 0;} // size가 0이면 배열이 비어있는 것이므로 size == 0;
//		if(size == 0)			이걸 간결하게 한 것
//			return true;
//		else
//			return false;
	
	// Q6. MyVector클래스의 객체배열 objArr에 저장된 모든 객체를 문자열로 이어서 반환하도록 toString()을 오버라이딩하시오.
	public String toString() {
		String index = "["; // 문자열 index
		for(int i=0;i<size;i++) {
			index += objArr[i]+","; // 문자열 index에 objArr배열에 저장된 모든 객체를 더한다
		}
		return index+"]";
	}
	
	// Q7. MyVector클래스의 객체배열 objArr에서 지정된 객체가 저장되어 있는 위치(index)를 반환하는 int indexOf(Object obj)를 작성하시오.
	int indexOf(Object obj) {
			for(int i=0;i<size;i++) {
				
				// return i 가 겹치므로 이걸 줄일 방법을 찾아보자.
				
				if(obj == null &&objArr[i]==null) {
					return i;
				}
				if(obj!=null && obj.equals(objArr[i])) // 지정된 객체와 objArr 배열의 값이 일치하는 경우
					return i;
			}	
			return -1; // index값 반환	
	}
	
	// Q8. objArr에서 지정된 객체를 삭제하는 boolean remove(Object obj)를 작성하시오.
	boolean remove(Object obj) {
		boolean b = false; // 리턴값을 저장하기 위해 선언

		if(exist(obj) == true) {
			
		for(int i=indexOf(obj);i<(objArr.length)-1;i++) {
			objArr[i] = objArr[i+1]; // 삭제한 데이터의 값을 한 칸씩 복사해서 올려준다
		}
		
		objArr[size] = null; // 마지막 위치를 null로 변경해준다
		size--; // size 크기를 줄여준다
			
		if(indexOf(obj) == 0) { // 삭제한 데이터가 더이상 해당 배열에 존재하지 않는다면
			b = true;
			System.out.println("삭제되었습니다");
		}
		// 삭제가 제대로 되지 않았을 경우의 else
		else
			b = false;
		
			return b;
		}
		// 입력받은 값이 배열에 존재하지 않는 경우의 else
		else {
			System.out.println("존재하지 않는 객체입니다.");
			return b;
		}
	}
	
	/*
	 remove 강사님 풀이
	 int idx = indexOf(obj);
	 
	 못찾으면 false를 반환
	 if(idx==-1) return false;
	 
	 return true;
	 
	 -> 를 다 합친것 = return 
	 */
	// 입력된 값이 배열에 존재하는지 확인하는 메서드 
	
	boolean exist(Object obj) {
		boolean exist = false; 
		
		for(int i=0;i<objArr.length;i++) {
			if(obj != objArr[i]) { // 입력받은 객체가 배열 안에 존재하지 않는 경우
				exist = false; // false
			}
			else {
				exist = true; // 존재하는 경우 true
				break; // for문 빠져나가기
			}
		}
		return exist;
	}
	
}
