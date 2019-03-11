package day12;

import java.util.*; 

class SungJukEx2 { 
      public static void main(String[] args) { 
            ArrayList<Student1> list = new ArrayList<Student1>(); 

                                       // 이름, 반, 번호, 국어, 수학, 영어 
            list.add(new Student1("남궁성", 3,2,100,100,100)); 
            list.add(new Student1("왕자바", 3,1,90,100,80)); 
            list.add(new Student1("자바왕", 3,3,70,100,100)); 
            list.add(new Student1("킹왕짱", 1,2,100,60,90)); 
            list.add(new Student1("자바짱", 1,1,100,100,100)); 
            list.add(new Student1("최고수", 1,3,100,80,60)); 
            list.add(new Student1("홍길동", 2,1,50,80,100)); 
            list.add(new Student1("일지매", 2,3,70,80,100)); 
            list.add(new Student1("변강쇠", 2,4,80,80,85)); 
            list.add(new Student1("이원구", 2,2,90,90,90)); 

            Collections.sort(list); 
            printList(list); 
      } 

      public static void printList(List<Student1> list) { 
            System.out.println("이름\t학년\t반\t국어\t수학\t영어\t총점 "); 
            System.out.println("===================================================="); 

            for(Student1 s : list) { 
                  System.out.println(s); 
            } 

            System.out.println("===================================================="); 
      } 
} 

class Student1 implements Comparable<Student1> { 
      String name = ""; 
      int classNo = 0; 
      int Student1No = 0; 
      int koreanScore = 0; 
      int mathScore = 0; 
      int englishScore = 0; 
      int total = 0; 

      Student1(String name, int classNo, int Student1No, int koreanScore, int mathScore, int englishScore) { 
            this.name = name; 
            this.classNo = classNo; 
            this.Student1No = Student1No; 
            this.koreanScore = koreanScore; 
            this.mathScore = mathScore; 
            this.englishScore = englishScore; 

            total = koreanScore + mathScore + englishScore; 
      } 

      public String toString() { 
            return name + "\t" 
                  + classNo + "\t" 
                  + Student1No + "\t" 
                  + koreanScore + "\t" 
                  + mathScore + "\t" 
                  + englishScore + "\t" 
                  + total + "\t"; 
      } 

      public int compareTo(Student1 obj) { 
      	return obj.total - this.total;
      } 
} // end of class Student1

