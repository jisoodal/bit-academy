package ch08;

public class Exercise8_9 {

	public static void main(String[] args) throws Exception{
		
		throw new UnsupportedFunctionException("지원하지 않는 기능입니다.",100);

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
		// 에러코드(ERR_CODE)를 반환한다
		return ERR_CODE;
	}
	
	public String getMessage() {
		
		return "["+ERR_CODE+"]"+message;
		
	}
}