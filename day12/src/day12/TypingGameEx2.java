package day12;

import java.util.*; 

class TypingGameEx2 { 
      Vector words = new Vector(); 
      String[] data = {"태연","유리","윤아","효연","수영","서현","티파니","써니","제시카"};             
      int interval = 2 * 1000; // 2초 

      int life = 3; 
      int score = 0; 

      WordGenerator wg = new WordGenerator(); 
      WordDropper wd = new WordDropper(); 

      public static void main(String args[]) { 
            TypingGameEx2 game = new TypingGameEx2(); 

            game.wg.start();  
            game.wd.start();

            Vector words = game.words; 

            while(true) { 
                  System.out.println("LIFE:" + game.life + " SCORE:"+ game.score); 
                  System.out.println(words); 

                  String prompt = ">>"; 
                  System.out.print(prompt);

                  // 화면으로부터 라인단위로 입력받는다. 
                  Scanner s = new Scanner(System.in); 
                  String input = s.nextLine().trim();  

//                1. 반복문을 이용해서 사용자가 입력한 단어가 words에 있는지 확인한다.
                  for(int i=0;i<words.size();i++) {
                	  Word tmp = (Word)words.get(i);

//                    2. 있으면 words에서 삭제하고 '삑~'소리가 나게 한다.
//                    (java.awt.Toolkit.getDefaultToolkit().beep()사용)
                  		if(input.equals(tmp.word)) {
                  			java.awt.Toolkit.getDefaultToolkit().beep();
                  			words.remove(i);
                  		game.score += tmp.y * input.length() * 50;
//                        3. 점수(score)의 값을 계산해서 증가시킨다.
//                  		(입력한 단어의 글자수 * 남은시간 * 50으로 점수를 계산한다.)
                  		}
                  	}
            } // while(true) 
      } // main 

      public void delay(int millis) { 
            try { 
                  Thread.sleep(millis); 
            } catch(Exception e) {} 
      } 

      class WordGenerator extends Thread { 
            public void run() { 
                  while(true) { 
                        int rand = (int)(Math.random()*data.length); 

                        words.add(new Word(data[rand])); 
                        delay(interval); 
                  } 
            } // run() 
      } // class WordGenerator 

      class WordDropper extends Thread { 
            public void run() { 
            	
//                     1. words에 저장된 모든 단어(Word인스턴스)의 y값을 1 감소시킨다.
            	// 벡터 words안의 값을들 하나씩 불러와서-> Word로 형변환 한 뒤-> y값을 불러와서 그것을 감소시킴
            	
            	for(int i=0;i<words.size();i++) {
            		Word tmp = (Word)words.get(i);
            		
            		tmp.y--;           			
//                      2. y의 값이 0보다 작거나 같으면, words에서 단어를 제거하고 life를 1 감소시킨다.
            			
            			if(tmp.y <=0) {
            				words.remove(tmp);
            				life--;
            			}
            		
                	if(life == 0) {
                		System.out.println("life: "+life+"score: "+score);
                		System.exit(0);
                	}
//                         4. 1초간 시간을 지연시킨다.(delay()사용)
                	delay(1000);
            	}
//              3. life의 값이 0이 되면 life와 점수를 출력하고 게임을 종료한다.
//                     5. 반복문을 이용해서 1~4의 작업을 반복한다.
            } // run() 
      } // class WordDropper 

      class Word { 
            String word = ""; 
            int y = 10; 

            Word(String word) { 
                  this(word, 10); 
            } 

            Word(String word, int y) { 
                  this.word = word; 
                  this.y = y; 
            } 

            public String toString() { 
            	return word+y;
            } 
      } // class Word 
} // TypingGameEx2

