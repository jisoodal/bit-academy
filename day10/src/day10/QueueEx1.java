package day10;

import java.util.*;

public class QueueEx1 {

	static Queue q = new LinkedList();
	static final int MAX_SIZE = 5; // Queue에 최대 5개까지만 저장되도록 한다
	
	public static void main(String[] args) {
		System.out.println("help를 입력하면 도움말을 볼 수 있습니다.");
		
		while(true) {
			System.out.println(">>");
			try {
				Scanner s = new Scanner(System.in);
				String input = s.nextLine().trim();
				
				if("".equals(input)) continue; // 아무것도 입력하지 않았을 때 
				
				if(input.equalsIgnoreCase("q")) { // 무조건 비교
					System.exit(0); // q 입력시 종료
				} else if(input.equalsIgnoreCase("help")) { // help 입력 시 syso
					System.out.println("help - 도움말을 보여줍니다.");
					System.out.println("q 또는 Q - 프로그램을 종료합니다.");
					System.out.println("history - 최근에 입력한 명령어를 "+MAX_SIZE+"개 보여줍니다.");
				} else if(input.equalsIgnoreCase("history")) {
					int i=0;
					save(input); // 입력값 저장
					
					LinkedList tmp = (LinkedList)q;
					ListIterator it = tmp.listIterator();

				while(it.hasNext())
						System.out.println(++i+"."+it.next());
			} else {
				save(input);
				System.out.println(input);
			}//if(input.equalsIgnoreCase("q")) {
			}catch(Exception e) {
				System.out.println("입력오류입니다.");
			}
		} //while(true)
	}
			public static void save(String input) {
				if(!"".equals(input)) // 아무것도 입력되지 않은게 아니라면
					q.offer(input); // queue에 객체를 저장. 성공하면 true 실패하면 false
				
				if(q.size() > MAX_SIZE) // queue의 크기가 최대 저장값보다 커지면
					q.remove(); // Queue에서 객체를 꺼내 반환. 큐니까 제일 먼저 입력한거!
	}
}
