package day12;

import java.util.*; 

class TypingGameEx2 { 
      Vector words = new Vector(); 
      String[] data = {"�¿�","����","����","ȿ��","����","����","Ƽ�Ĵ�","���","����ī"};             
      int interval = 2 * 1000; // 2�� 

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
                  
                  Object obj = game.words;
                  int leftTime = 0;

                  // ȭ�����κ��� ���δ����� �Է¹޴´�. 
                  Scanner s = new Scanner(System.in); 
                  String input = s.nextLine().trim(); 

//                       1. �ݺ����� �̿��ؼ� ����ڰ� �Է��� �ܾ words�� �ִ��� Ȯ���Ѵ�.
//                  for(int i=0;i<words.size();i++) {
//                	  Word tmp = (Word)words.get(i);
//
////                    2. ������ words���� �����ϰ� '��~'�Ҹ��� ���� �Ѵ�.
////                    (java.awt.Toolkit.getDefaultToolkit().beep()���)
//                  		if(input.equals(tmp.word)) {
//                  			java.awt.Toolkit.getDefaultToolkit().beep();
//                  			words.remove(i);
//                  		game.score += tmp.y * input.length() * 50;
////                        3. ����(score)�� ���� ����ؼ� ������Ų��.
////                  		(�Է��� �ܾ��� ���ڼ� * �����ð� * 50���� ������ ����Ѵ�.)
//                  		}
//                  	}
//            } // while(true) 
                  for(int i=0;i<words.size();i++) {
                	  
                	  if(input.equals(words)) {
                		  
//                        2. ������ words���� �����ϰ� '��~'�Ҹ��� ���� �Ѵ�.

//                        (java.awt.Toolkit.getDefaultToolkit().beep()���)
                		  
                		  System.out.println(words.get(i));
                		  words.remove(i);
                		  java.awt.Toolkit.getDefaultToolkit().beep();
                	  }
                	  
                	  System.out.println("�Ϳ�");
                	  
                	  if(obj instanceof Word) {
                		  System.out.println("���");
                		 obj = (Word)obj;
                		 leftTime = ((Word) obj).y;
                		 System.out.println("���� �ð�:" + leftTime);
                	  }
                	  System.out.println("���2");
                  }
//                       3. ����(score)�� ���� ����ؼ� ������Ų��.
                  game.score = input.length() * leftTime * 50;

//                          (�Է��� �ܾ��� ���ڼ� * �����ð� * 50���� ������ ����Ѵ�.)

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

//                     1. words�� ����� ��� �ܾ�(Word�ν��Ͻ�)�� y���� 1 ���ҽ�Ų��.
            	 TypingGameEx2 game = new TypingGameEx2();           	
            	 Object obj = game.words;
            	 
            	 for(int i=0;life!=0;i++) {
            		 if(obj instanceof Word) {
            			 obj = (Word)obj;
            			 ((Word) obj).y --;
            		 
//                   2. y�� ���� 0���� �۰ų� ������, words���� �ܾ �����ϰ� life�� 1 ���ҽ�Ų��.
            		 
            			 if(((Word) obj).y<=0)
            				 words.remove(i);
            			 life --;
            		 }
//                     3. life�� ���� 0�� �Ǹ� life�� ������ ����ϰ� ������ �����Ѵ�.
            	 
            		 if(life == 0) {
            			 System.out.println("life:"+life+"score:"+score);
            			 System.exit(0);
            		 }
//               4. 1�ʰ� �ð��� ������Ų��.(delay()���)           	 
            		 delay(1000);
//                     5. �ݺ����� �̿��ؼ� 1~4�� �۾��� �ݺ��Ѵ�.
            	 }
            	 
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
