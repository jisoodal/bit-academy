package day10;

import java.util.Stack;

public class StackEx1 {
	public static Stack back 	 = new Stack(); // 뒤로가기를 했을 때 객체를 담을 스택
	public static Stack forward  = new Stack(); // 앞으로 버튼을 눌렀을 때 객체를 담을 스택

	public static void main(String[] args) {
		goURL("1.네이트"); // back 스택에 url 입력
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");
		
		printStatus(); // 현재 상태 출력
		
		goBack(); // 맨 위에있던 다응url객체가 back 스택의 첫번째로 push
		System.out.println("= 뒤로가기 버튼을 누른 후 =");
		printStatus();
		
		goBack(); // 그 다음으로 위게 있던 네이버url객체가 back 스택의 첫 번째로 push된다(다음위)
		System.out.println("= '뒤로' 버튼을 누른 후 =");
		printStatus();
		
		goForward(); // 앞으로 버튼을 누르면
		System.out.println("= '앞으로' 버튼을 누른 후 =");
		printStatus(); // forward stack에 맨 위의 값인 네이버가 출력된다
		
		goURL("codechobo.com"); // codechobo url back stack에 push된다
		System.out.println("= 새로운 주소로 이동 후 =");
		printStatus(); // 
	}
	
	public static void printStatus() { // 현재 상태를 출력해주는 메서드
		System.out.println("back:"+back); // back 스택 출력
		System.out.println("forward:"+forward); // forward 스택 출력
		System.out.println("현재화면은 '" + back.peek()+"'입니다."); // stack의 맨 위에 저장된 객체를 반환(객체를 꺼내지는 않음)
		System.out.println();
	}
	public static void goURL(String url) { // 입력받은 url을 push해주는 메서드
		back.push(url);
		if(!forward.empty()) // forward 스택이 비어있지 않으면
			forward.clear(); // forward 스택을 비워준다
	}
	
	public static void goForward() {
		if(!forward.empty()) // forward스택에 값이 있으면
			back.push(forward.pop()); // forward stack의 맨 위에 있는 객체를 pop하여 back stack에 push한다.
	}
	public static void goBack() {
		if(!back.empty()) // back 스택에 값이 있으면
			forward.push(back.pop()); // back stack에서 맨 위에 저장된 객체를 꺼내서 forward에 push한다
	}

}
