package day16;

import java.util.*;
import java.util.stream.*;

public class StreamEx5 {

	public static void main(String[] args) {
		String[] strArr = {
				"Inheritance", "Java" , "Lambda" , "stream",
				"OptionalDouble" , "IntStream", "count", "sum"
		};
		
		Stream.of(strArr).forEach(System.out::println);
		
		boolean noEmptyStr = Stream.of(strArr).noneMatch(s->s.length() ==0); // 길이가 0인 단어가 없는지
		Optional<String> sWord = Stream.of(strArr)
				.filter(s->s.charAt(0) == 's').findFirst(); // s로 시작하는 단어를 먼저 찾아라
		
		System.out.println("noEmptyStr=" +noEmptyStr); // true
		System.out.println("sWord=" +sWord.get()); // stream
		
		IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
		IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);
		
		int count = intStream1.reduce(0, (a,b) -> a+1);  // strArr 개수 count
		int sum = intStream2.reduce(0, (a,b) -> a+b); // 총 길이 수
		
		OptionalInt max = intStream3.reduce(Integer::max); // 가장 길이가 긴 수 - OptionalDouble
		OptionalInt min = intStream4.reduce(Integer::min); // 가장 길이가 짧은 수 - sum
		
		System.out.println("count="+count);
		System.out.println("sum="+sum);
		System.out.println("max="+max.getAsInt());
		System.out.println("min="+min.getAsInt());

	}

}
