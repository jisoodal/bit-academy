package Thread;

public class MultithreadExample5 {

	public static void main(String[] args) {
		
		SharedArea2 sharedArea = new SharedArea2();
		
		sharedArea.leeAccount = new Account("111-111-1111","이몽룡",20000000);
		sharedArea.sungAccount = new Account("123-1234-1235","성춘향",10000000);
	}

}

class PrintThread2 extends Thread{
	
	// withdraw - 인줄, deposit - 입금 메서드 작성할 것
	// 둘이 동시에 진행되면 안됨
	// run에서는 withdraw와 deposit이후 둘을 합친 결과가 나와야 함
	
	public void run() {
	
		// 이몽룡, 성춘향 계좌 잔액(balance) 출력
		// 이몽룡+성춘향의 잔액 출력
	}
}

class TransferThread extends Thread{
	
	SharedArea2 sharedArea;
	
	public void run() {
		
		// 이몽룡의 withdraw() 실행
		// 성춘향의 deposit() 실행
	}
	
}

class SharedArea2{
	
	Account leeAccount;
	Account sungAccount;
	
}

class Account {
	
	String accountNo, name;
	int balance;
	
	SharedArea2 sharedArea;
	
	Account() {
		
	}
	
	Account(String accountNo, String name, int balance){
		this.accountNo = accountNo;
		this.name = name;
		this.balance = balance;
	}
	
	public void withdraw() {
		
		sharedArea.leeAccount.balance -= 1000000;
		System.out.print("이몽룡 계좌: 100만원 인출,");
		
	}
	
	public void deposit() {
		
		sharedArea.sungAccount.balance += 1000000;
		System.out.println("성춘향 계좌: 100만원 입금");
		
	}
}
