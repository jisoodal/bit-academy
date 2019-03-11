package day12;

import java.util.*; 

class QuizEx3 { 
      public static void main(String[] args) { 
            String[] data = { 
                  "다음 중 키워드가 아닌 것은?`2`final`True`if`public", 
                  "다음 중 자바의 연산자가 아닌 것은?`6`&`|`++`!=`/`^", 
                  "다음 중 메서드의 반환값이 없음을 의미하는 키워드는?`1`void`null`false`", 
            }; 
            
            Scanner s = new Scanner(System.in); 
            int score = 0; 

            shuffle(data); // 문제를 섞는다.

            for(int i=0;i < data.length;i++) { 
                  String[] tmp = data[i].split("`",3); 

                  String question = tmp[0]; 
                  String answer = tmp[1]; 
                  String[] choices = tmp[2].split("`"); 

                  answer = choices[Integer.parseInt(answer)-1]; 

                  shuffle(choices); // 선택지를 섞는다.

                  System.out.println("["+(i+1)+"] "+question); 

                  for(int x=0;x < choices.length;x++) { 
                      System.out.print((x+1)+"."+choices[x]+" ");
                      
                      // 정답을 해당 선택지 번호로 변환 과정
                      if(choices[x].equals(answer))
                    	  answer = String.valueOf((x+1));
                  } 

                  System.out.println(); 
                  System.out.print("[답]"); 
                  String input = s.nextLine(); 
                  
                  if(input.equals(answer)) { 
                        score++; 
                  } 

                  System.out.println(); 
                  System.out.println(); 
            } 

            System.out.println("정답개수/전체문항수 :"+score+"/"+data.length); 
      } // main 

      public static void shuffle(String[] data) { 

           // 코드를 완성하세요.

           //  1. 배열data의 개수가 0보다 같거나 적으면 메서드 전체를 빠져나간다.
    	  if(data.length <= 0)
    		  return;
    	  
    	  else {
    		//  2. 선택지의 순서를 뒤바꾼다. 반복문과 Math.random()사용
    		  for(int i=0;i<data.length;i++) {
    			  int r = (int)((Math.random())*data.length);
    		  
    			  String tmp = data[0]; // tmp에 0번째의 값을 넣고
    			  data[0] = data[r]; // 0번째에 랜덤한 자리의 값을 넣고
    			  data[r] = tmp; // 랜덤한 자리에 0번째 값을 넣기를 반복하면 랜덤이 된다.
    		  }
    			  
    	  }
      } // shuffle() 
} 

