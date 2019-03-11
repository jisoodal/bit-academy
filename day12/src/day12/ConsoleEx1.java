package day12;

import java.util.*; 

class ConsoleEx1 { 
      public static void main(String[] args) { 
            while(true) { 
                  String prompt = ">>"; 
                  System.out.print(prompt); 
             //  1. 화면으로부터 라인단위로 입력받는다.  - java.util.Scanner클래스 사용
                  Scanner scanner = new Scanner(System.in);
                  String input = scanner.nextLine();
                     
             //  2. q 또는 Q를 입력하면 실행종료한다.
                 if(input.equalsIgnoreCase("q"))
                	 System.exit(0);
                 
                 else
                 System.out.println(input);

             } // while(true) 
      } // main 
} // class 
