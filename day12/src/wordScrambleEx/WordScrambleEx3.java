package wordScrambleEx;

import java.util.*; 

class WordScrambleEx3 { 
      public static void main(String[] args) { 
    	  
            String[] strArr = { "CHANGE", "LOVE", "HOPE", "VIEW"}; 
             
            // 코드를 넣어 완성하세요.
            // hint : while문을 중첩해서(2개의 while문) 작성하세요.            
            while(true) { 
            	
                String answer = getAnswer(strArr); 
                String question = getScrambledWord(answer); 
                
           while(true) {
                System.out.println("Question :" + question); 
                System.out.print("Your answer is :");
               
                Scanner scanner = new Scanner(System.in);
                
                String input = scanner.nextLine();
                
                if(input.equals("Q") || input.equals("q")) {
              	  System.out.println("프로그램을 종료합니다.");
              	  System.exit(0);
              	  
                }
                
                else if (input.toUpperCase().equals(answer)
              		  || input.toLowerCase().equals(answer)) {
                	System.out.println("정답입니다.");
              	  break;
                }
                
                else
              	  System.out.println(input+"은/는 정답이 아닙니다. 다시 시도해보세요.");
            	}
          }
      } // main 

      public static String getAnswer(String[] strArr) { 
            int idx = (int)(Math.random()*strArr.length); 
            return strArr[idx]; 
      } 
      
      public static String getScrambledWord(String str) { 
            char[] chArr = str.toCharArray(); 

            for(int i=0;i < str.length();i++) {
                   

                  int idx = (int)(Math.random()*str.length()); 
                  
                  char tmp = chArr[i]; 
                  chArr[i] = chArr[idx]; 
                  chArr[idx] = tmp; 
            } 

            return new String(chArr); 
      } // scramble(String str) 
} 


