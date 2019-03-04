package day7;

import javax.swing.text.html.parser.Parser;

interface Parseable { // 추상메서드
	public abstract void parse(String fileName); // 파일 이름을 String 타입으로 받는 메서드
}

class ParserManager { 
	public static Parseable getParser(String type) { // getParser는 공유하는 내용이므로 class 타입
		if(type.equals("XML")) { // 타입이 XML인 경우
			return new XMLParser(); // XMLParser 클래스 실행
		} else {
			Parseable p = new HTMLParser(); // 타입이 HTML인 경우
			return p; // HTMLParser의 반환값을 내보냄
		}
	}
}

class XMLParser implements Parseable { 
	public void parse(String fileName) {  // 재정의 하지 않아도 됨
		System.out.println(fileName + "- XML parsing completed."); // 선언부만 정의해줬던 추상 메서드의 구현부를 적어줌.
	}
}

class HTMLParser implements Parseable {
	public void parse(String fileName) {
		System.out.println(fileName + "-HTML parsing completed.");
	}
}

public class ParserTest {

	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML"); // 클래스 메서드이므로 별다른 정의 없이 사용 가능.
		parser.parse("document.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html");
	}

}
