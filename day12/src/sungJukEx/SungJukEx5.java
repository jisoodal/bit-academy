package sungJukEx;

import java.util.*; 

class SungJukEx5 { 
      public static void main(String[] args) { 
            ArrayList<Student4> list = new ArrayList<Student4>(); 

            // 이름, 반, 번호, 국어, 수학, 영어 
            list.add(new Student4("남궁성", 3,2,100,100,100)); 
            list.add(new Student4("왕자바", 3,1,90,100,80)); 
            list.add(new Student4("자바왕", 3,3,70,100,100)); 
            list.add(new Student4("킹왕짱", 1,2,100,60,90)); 
            list.add(new Student4("자바짱", 1,1,100,100,100)); 
            list.add(new Student4("최고수", 1,3,100,80,60)); 
            list.add(new Student4("홍길동", 2,1,50,80,100)); 
            list.add(new Student4("일지매", 2,3,70,80,100)); 
            list.add(new Student4("변강쇠", 2,4,80,80,85)); 
            list.add(new Student4("이원구", 2,2,90,90,90)); 

            calculateSchoolRank(list); // 전교등수를 계산한다.

            calculateClassRank(list);  // 반등수를 계산한다.
            printList(list); 
      } 

      public static void printList(List<Student4> list) { 
            System.out.println("이름\t반\t번호\t국어\t수학\t영어\t총점\t전교등수 "); 
            System.out.println("================================================================="); 

            for(Student4 s : list) { 
                  System.out.println(s); 
            } 

            System.out.println("================================================================="); 
      } 


 

      public static void calculateSchoolRank(List<Student4> list) { 
            Collections.sort(list); 

            int prevRank = -1; 
            int prevTotal = -1; 
            int length = list.size(); 

            for(int i=0;i < length; i++) { 
                  Student4 s = list.get(i); 

                  if(s.total==prevTotal) { 
                        s.schoolRank = prevRank; 
                  } else { 
                        s.schoolRank = i + 1; 
                  } 

                  prevRank = s.schoolRank; 
                  prevTotal = s.total; 
            } 
      } // public static void calculateSchoolRank(List<Student4> list) { 

      public static void calculateClassRank(List<Student4> list) { 
            Collections.sort(list, new ClassTotalComparator2()); // 먼저 반별 총점기준 내림차순으로 정렬한다.

            int prevClassNo = -1; 
            int prevRank = -1; 
            int prevTotal = -1; 
            int length = list.size(); 
            int count = 0;
            
            //  1. 반복문을 이용해서 list에 저장된 Student4객체를 하나씩 읽는다.
            
            for(int i=0;i<list.size();i++) {
            	Student4 s = list.get(i);
            	
            	if(s.classNo != prevClassNo) { // 
//            	     1.1 반이 달라지면,(classNo와 prevClassNo가 다르면)
//        			 이전등수(prevRank)와 이전총점(prevTotal)을 초기화 한다. 
//            		prevTotal = s.total;
            		s.classRank = 1;
            		prevRank = s.classRank;
//             1.3 현재 반과 총점과 등수를 이전반(prevClassNo)와 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
               // 이건 반이 다른 경우만 계산해도 되니까 여기에 작성.
//            		prevClassNo = s.classNo;
            		count = 1;
            	}
            	else {
//                  1.1 총점(total)이 이전총점(prevTotal)과 같으면
//                  이전 등수(prevRank)를 등수(schoolRank)로 한다.
            		if(s.total == prevTotal) {
            		s.classRank = prevRank;
//            		prevTotal = s.total;
            		count++; // 총점이 같은 경우, 다음 등수를 낼 때는 총점이 같은 경우의 수만큼 반 등수를 더해야 하므로 count++!
            		}
            		else {
//                      1.2 총점이 서로 다르면,
//            			등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
//            			이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해서 계산되어야한다. -> count를 이용!
            			s.classRank = prevRank+count;
            			prevRank = s.classRank;
//            			prevTotal = s.total;
            		}	
            	}	
            	prevTotal = s.total; // 겹치는 부분 밖으로 빼주기 -> 코드 간소화!
            	prevClassNo = s.classNo;
            }
      } // public static void calculateClassRank(List<Student4> list) { 
} 

class Student4 implements Comparable<Student4> { 
      String name = ""; 
      int classNo = 0; 
      int Student4No = 0; 
      int koreanScore = 0; 
      int mathScore = 0; 
      int englishScore = 0; 

      int total = 0; 

      int schoolRank = 0; // 전교등수

      int classRank = 0;  // 반등수

      Student4(String name, int classNo, int Student4No, int koreanScore, int mathScore, int englishScore) { 
            this.name = name; 
            this.classNo = classNo; 
            this.Student4No = Student4No; 
            this.koreanScore = koreanScore; 
            this.mathScore = mathScore; 
            this.englishScore = englishScore; 

            total = koreanScore + mathScore + englishScore; 
      } 

      public String toString() { 
            return name + "\t" 
                  + classNo + "\t" 
                  + Student4No + "\t" 
                  + koreanScore + "\t" 
                  + mathScore + "\t" 
                  + englishScore + "\t" 
                  + total + "\t" 
                  + schoolRank + "\t"

                  + classRank + "\t";
      } 

 

       public int compareTo(Student4 obj) { 
            return obj.total - this.total; 
//             return this.name.compareTo(obj.name); // 이름기준으로 오름차순 정렬 
      } 

/* 제네릭스(Generics) 사용하지 않은 버젼 
      public int compareTo(Object obj) { 
            int result = -1; 

            if(obj instanceof Student4) { 
                  Student4 tmp = (Student4)obj; 

                  result = tmp.total - this.total; 
            } 

            return result; 
      } 
*/ 
} // end of class Student4 

class ClassTotalComparator2 implements Comparator<Student4> { 
      public int compare(Student4 s1, Student4 s2) { 
            int result = s1.classNo - s2.classNo; 

            if(result==0) 
                  result = s2.total - s1.total; 

            return result; 
      } 
} 

class ClassStudent4NoComparator implements Comparator<Student4> { 
      public int compare(Student4 s1, Student4 s2) { 

            int result = s1.classNo - s2.classNo; 

            if(result==0) 
                  result = s1.Student4No - s2.Student4No; 

            return result; 
      } 
} 

