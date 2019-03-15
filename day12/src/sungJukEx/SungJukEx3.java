package sungJukEx;

import java.util.*; 

class SungJukEx3 { 
      public static void main(String[] args) { 
            ArrayList<Student2> list = new ArrayList<Student2>(); 

             // 이름, 반, 번호, 국어, 수학, 영어 
            list.add(new Student2("남궁성", 3,2,100,100,100)); 
            list.add(new Student2("왕자바", 3,1,90,100,80)); 
            list.add(new Student2("자바왕", 3,3,70,100,100)); 
            list.add(new Student2("킹왕짱", 1,2,100,60,90)); 
            list.add(new Student2("자바짱", 1,1,100,100,100)); 
            list.add(new Student2("최고수", 1,3,100,80,60)); 
            list.add(new Student2("홍길동", 2,1,50,80,100)); 
            list.add(new Student2("일지매", 2,3,70,80,100)); 
            list.add(new Student2("변강쇠", 2,4,80,80,85)); 
            list.add(new Student2("이원구", 2,2,90,90,90)); 

            System.out.println("[반별 총점높은 순으로 정렬]"); 
            Collections.sort(list, new ClassTotalComparator()); // 반, 총점 순으로 정렬 
            printList(list); 

            System.out.println(); 

            System.out.println("[반, 번호 순으로 정렬]"); 
            Collections.sort(list, new ClassStudent2NoComparator()); // 반, 번호 순으로 정렬 
            printList(list); 
      } 

      public static void printList(List<Student2> list) { 
            System.out.println("이름\t학년\t반\t국어\t수학\t영어\t총점 "); 
            System.out.println("===================================================="); 

            for(Student2 s : list) { 
                  System.out.println(s); 
            } 

            System.out.println("===================================================="); 
      } 
} 

class Student2 implements Comparable<Student2> { 
      String name = ""; 
      int classNo = 0; 
      int Student2No = 0; 
      int koreanScore = 0; 
      int mathScore = 0; 
      int englishScore = 0; 

      int total = 0; 

      Student2(String name, int classNo, int Student2No, int koreanScore, int mathScore, int englishScore) { 
            this.name = name; 
            this.classNo = classNo; 
            this.Student2No = Student2No; 
            this.koreanScore = koreanScore; 
            this.mathScore = mathScore; 
            this.englishScore = englishScore; 

            total = koreanScore + mathScore + englishScore; 
      } 

      public String toString() { 
            return name + "\t" 
                  + classNo + "\t" 
                  + Student2No + "\t" 
                  + koreanScore + "\t" 
                  + mathScore + "\t" 
                  + englishScore + "\t" 
                  + total + "\t"; 
      } 

      public int compareTo(Student2 obj) { 
            return obj.total - this.total; 
//             return this.name.compareTo(obj.name); // 이름기준으로 오름차순 정렬 
      } 

/* 제네릭스(Generics) 사용하지 않은 버젼 
      public int compareTo(Object obj) { 
            int result = -1; 

            if(obj instanceof Student2) { 
                  Student2 tmp = (Student2)obj; 

                  result = tmp.total - this.total; 
            } 

            return result; 
      } 
*/ 
} // end of class Student2 

class ClassTotalComparator implements Comparator<Student2> { 
      public int compare(Student2 s1, Student2 s2) { 
          int result = -1;
          
          if(s1.classNo > s2.classNo) 
        	  return 1;
          
          else if(s1.classNo == s2.classNo)
        	  return s2.total - s1.total;
          
          else
        	  
            return result; 
      } 
} 

class ClassStudent2NoComparator implements Comparator<Student2> { 
      public int compare(Student2 s1, Student2 s2) { 
    	  int result = -1;

           if(s1.classNo > s2.classNo)
        	   return 1;
           
           else if(s1.classNo == s2.classNo)
        	   return s1.Student2No - s2.Student2No;
           
           else
            return result; 
      } 
} 

