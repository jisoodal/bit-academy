package Thread;

public class MultithreadExample5 {

	public static void main(String[] args) {
		
		SharedArea2 sharedArea = new SharedArea2();
		
		sharedArea.leeAccount = new Account("111-111-1111","�̸���",20000000);
		sharedArea.sungAccount = new Account("123-1234-1235","������",10000000);
	}

}

class PrintThread2 extends Thread{
	
	// withdraw - ����, deposit - �Ա� �޼��� �ۼ��� ��
	// ���� ���ÿ� ����Ǹ� �ȵ�
	// run������ withdraw�� deposit���� ���� ��ģ ����� ���;� ��
	
	public void run() {
	
		// �̸���, ������ ���� �ܾ�(balance) ���
		// �̸���+�������� �ܾ� ���
	}
}

class TransferThread extends Thread{
	
	SharedArea2 sharedArea;
	
	public void run() {
		
		// �̸����� withdraw() ����
		// �������� deposit() ����
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
		System.out.print("�̸��� ����: 100���� ����,");
		
	}
	
	public void deposit() {
		
		sharedArea.sungAccount.balance += 1000000;
		System.out.println("������ ����: 100���� �Ա�");
		
	}
}
