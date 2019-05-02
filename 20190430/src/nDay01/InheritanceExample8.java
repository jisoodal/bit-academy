package nDay01;

public class InheritanceExample8 {

	public static void main(String[] args) {
		EMailSender obj1 = new EMailSender("������ �����մϴ�", "������", "admin@dukeeshop.co.kr", "10% ���������� ����Ǿ����ϴ�.");
		SMSSender obj2 = new SMSSender("������ �����մϴ�.", "������", "02-000-0000", "10% ���������� ����Ǿ����ϴ�.");
		send(obj1, "hatman@yeyeye.com");
		send(obj1, "stickman@hahaha.com");
		send(obj2, "010-000-0000");
	}

	static void send(MessageSender obj, String recipient) {
		obj.sendMessage(recipient);
	}
}

abstract class MessageSender {
	String title;
	String senderName;

	MessageSender(String title, String senderName) {
		this.title = title;
		this.senderName = senderName;
	}

	abstract void sendMessage(String recipient);
}

class EMailSender extends MessageSender {
	String senderAddr;
	String emailBody;

	EMailSender(String title, String senderName, String senderAddr, String emailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emailBody;
	}

	void sendMessage(String recipient) {
		System.out.println("------------------------------");
		System.out.println("����: " + title);
		System.out.println("������ ���: " + senderName + " " + senderAddr);
		System.out.println("�޴� ���: " + recipient);
		System.out.println("����: " + emailBody);
	}
}

class SMSSender extends MessageSender {
	String returnPhoneNo;
	String message;

	SMSSender(String title, String senderName, String returnPhoneNo, String message) {
		super(title, senderName);
		this.returnPhoneNo = returnPhoneNo;
		this.message = message;
	}

	void sendMessage(String recipient) {
		System.out.println("------------------------------");
		System.out.println("����: " + title);
		System.out.println("������ ���: " + senderName);
		System.out.println("��ȭ��ȣ: " + recipient);
		System.out.println("ȸ�� ��ȭ��ȣ: " + returnPhoneNo);
		System.out.println("�޽��� ����: " + message);
	}
}
