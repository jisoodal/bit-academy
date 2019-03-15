package day12;

import java.util.*; 

class TypingGameEx1 { 
      Vector words = new Vector(); 
      String[] data = {"태연","유리","윤아","효연","수영","서현","티파니","써니","제시카"};             
      int interval = 2 * 1000; // 2초 

      WordGenerator wg = new WordGenerator(); 

      public static void main(String args[]) { 
            TypingGameEx1 game = new TypingGameEx1(); 

            game.wg.start(); 

            Vector words = game.words; 

            while(true) { 
                  System.out.println(words); 

                  String prompt = ">>"; 
                  System.out.print(prompt); 

                  // 화면으로부터 라인단위로 입력받는다. 
                  Scanner s = new Scanner(System.in); 
                  String input = s.nextLine().trim(); 
//                    1. 사용자가 입력한 값을 words에서 찾아 제거한다.
                  
                  for(int i=0;i<game.words.size();i++) {
                	  if(input.equals(game.words.get(i)))
                		  game.words.remove(i);
                  }
            } 
      } // main 

      public void delay(int millis) { 
            try { 
                  Thread.sleep(millis); 
            } catch(Exception e) {} 
      } 

      class WordGenerator extends Thread { 
            public void run() { 
//                        WordGenerator는 일정시간(interval) 간격으로 data배열의 한 요소를 골라서
//                        words(Vector인스턴스)에 저장하는 일을 수행한다.

            	while(true) {
//              1. 문자열 배열 data의 임의의 요소를 골라서 words(Vector인스턴스)에 저장한다.
            	int ran = (int)(Math.random()*data.length);
            	
            	if(words.contains(data[ran]))
            		ran = (int)(Math.random()*data.length);
            	
            	else
            	words.add(data[ran]);

//              2. 인스턴스 변수 interval의 값만큼 시간간격을 둔다.
            	try {
            	Thread.sleep(interval);
            	} catch(InterruptedException e) {}
            
//            3. 반복문을 이용해서 1,2의 작업이 반복적으로 이루어지게 한다.
            	}

            } // end of run() 
      } // class WordGenerator 
} // TypingGameEx1 
