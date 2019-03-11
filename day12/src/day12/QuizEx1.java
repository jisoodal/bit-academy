package day12;

class QuizEx1 { 
    public static void main(String[] args) { 
          String[] data = { 
                "다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
                "다음 중 자바의 연산자가 아닌 것은?`5`&`|`++`!=`/`^", 
                "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false" 
          }; 
          
       // 문제배열, 답배열, 선택지 배열
          String[] Question = new String[data.length],
        		   Choice 	= new String[data.length],
        		   tmp 		= new String[data.length];	
          
       // 1. String클래스의 String[] split(String regex, int limit)를 사용해서 문제와 선택지를 나누세요.

          for(int i=0;i<(data.length);i++) {
        	  //Question[0] = data[0] 의 0번째
              //Question[1] = data[1] 의 0번째
              //Question[2] = data[2] 의 0번째
        	  tmp = data[i].split("`",3);

        	  Question[i] = tmp[0];
        	  
        	// 2. 문제를 출력하세요.
        	  System.out.println("["+(i+1)+"]"+Question[i]);
        	  
        	// 3. 선택지를 나누기 위해 String[] split(String regex)를 사용하세요.
        	  Choice = tmp[2].split("`");
        	// 4.반복문을 이용해서 선택지를 출력하세요.
//        	  System.out.println(tmp[2]);
        	  for(int j=0;j<Choice.length;j++) {
        		  System.out.print((j+1)+"."+Choice[j]+" ");
        	  }
        	  System.out.println();
          }
    } // main 
} 


