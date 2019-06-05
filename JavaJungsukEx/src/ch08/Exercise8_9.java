package ch08;

public class Exercise8_9 {

	public static void main(String[] args) throws Exception{
		
		throw new UnsupportedFunctionException("�������� �ʴ� ����Դϴ�.",100);

	}

}

class UnsupportedFunctionException extends RuntimeException {
	
	final private int ERR_CODE = 100;
	String message;
	
	UnsupportedFunctionException(){
		
	}
	
	UnsupportedFunctionException(String message, int err_code){
		this.message = message;
	}
	
	public int getErrorCode() {
		// �����ڵ�(ERR_CODE)�� ��ȯ�Ѵ�
		return ERR_CODE;
	}
	
	public String getMessage() {
		
		return "["+ERR_CODE+"]"+message;
		
	}
}