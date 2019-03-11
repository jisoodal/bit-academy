package day12;

import java.util.*; 

class SungJukEx4 { 
      public static void main(String[] args) { 
            ArrayList<Student3> list = new ArrayList<Student3>(); 

            // 이름, 반, 번호, 국어, 수학, 영어 
            list.add(new Student3("남궁성", 3,2,100,100,100)); 
            list.add(new Student3("왕자바", 3,1,90,100,80)); 
            list.add(new Student3("자바왕", 3,3,70,100,100)); 
            list.add(new Student3("킹왕짱", 1,2,100,60,90)); 
            list.add(new Student3("자바짱", 1,1,100,100,100)); 
            list.add(new Student3("최고수", 1,3,100,80,60)); 
            list.add(new Student3("홍길동", 2,1,50,80,100)); 
            list.add(new Student3("일지매", 2,3,70,80,100)); 
            list.add(new Student3("변강쇠", 2,4,80,80,85)); 
            list.add(new Student3("이원구", 2,2,90,90,90)); 

            calculateSchoolRank(list); // 전교등수를 계산한다.
            printList(list); 
      } 

      public static void printList(List<Student3> list) { 
            System.out.println("이름\t반\t번호\t국어\t수학\t영어\t총점\t전교등수 "); 
            System.out.println("================================================================="); 

            for(Student3 s : list) { 
                  System.out.println(s); 
            } 

            System.out.println("================================================================="); 
      } 

      public static void calculateSchoolRank(List<Student3> list) { 
            Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.

            int prevRank = -1;       // 이전 전교등수
            int prevTotal = -1;       // 이전 총점
            int length = list.size(); 
            int count = 0;
            
            // list가 이미 총점순으로 정렬되어 있기 때문에... 이전 데이터하고만 총점을 비교하면 된다.
            // 1. 반복문을 이용해서 list에 저장된 Student3객체를 하나씩 읽는다.
            
            Student3 s = (Student3)list.get(0);
        	s.schoolRank = 1;
        	prevRank = s.schoolRank;
        	prevTotal =s.total;
        	count++;
            
            for(int i=1;i<list.size();i++) {        	
            	// Student에 토탈을 한줄씩 불러오려면 형변환 후 하나씩 get하기.!
            	Student3 s1 = (Student3)list.get(i);
            	// 1.1 총점(total)이 이전총점(prevTotal)과 같으면
                // 이전 등수(prevRank)를 등수(schoolRank)로 한다.
            	if(s1.total == prevTotal) {
            		// 1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
            		s1.schoolRank = prevRank;
            		prevTotal = s1.total;
            		count++;
            		System.out.println("count"+i+"="+count);
            		System.out.println("prevTotal"+i+"="+prevTotal);
            		System.out.println("prevRank"+i+"="+prevRank);
            	}
            	else {
            		 // 1.2 총점이 서로 다르면,
                    // 등수(schoolRank)의 값을 알맞게 계산해서 저장한다.
            		// 이전에 동점자 였다면, 그 다음 등수는 동점자의 수를 고려해서 계산되어야한다.
            		s1.schoolRank = s.schoolRank+count;
            		// 1.3 현재 총점과 등수를 이전총점(prevTotal)과 이전등수(prevRank)에 저장한다.
            		prevRank = s1.schoolRank;
            		prevTotal = s1.total;
            		count++;
            		System.out.println("count"+i+"="+count);
            		System.out.println("prevTotal"+i+"="+prevTotal);
            		System.out.println("prevRank"+i+"="+prevRank);
            	}    	
            }

      } // public static void calculateSchoolRank(List<Student3> list) { 
} 

class Student3 implements Comparable<Student3> { 
      String name = ""; 
      int classNo = 0; 
      int Student3No = 0; 
      int koreanScore = 0; 
      int mathScore = 0; 
      int englishScore = 0; 

      int total = 0; 

      int schoolRank = 0; // 전교등수

      Student3(String name, int classNo, int Student3No, int koreanScore, int mathScore, int englishScore) { 
            this.name = name; 
            this.classNo = classNo; 
            this.Student3No = Student3No; 
            this.koreanScore = koreanScore; 
            this.mathScore = mathScore; 
            this.englishScore = englishScore; 

            total = koreanScore + mathScore + englishScore; 
      } 

      public String toString() { 
            return name + "\t" 
                  + classNo + "\t" 
                  + Student3No + "\t" 
                  + koreanScore + "\t" 
                  + mathScore + "\t" 
                  + englishScore + "\t" 
                  + total + "\t" 
                  + schoolRank + "\t"; 
      } 

 

       public int compareTo(Student3 obj) { 
            return obj.total - this.total; 
//             return this.name.compareTo(obj.name); // 이름기준으로 오름차순 정렬 
      } 

/* 제네릭스(Generics) 사용하지 않은 버젼 
      public int compareTo(Object obj) { 
            int result = -1; 

            if(obj instanceof Student3) { 
                  Student3 tmp = (Student3)obj; 

                  result = tmp.total - this.total; 
            } 

            return result; 
      } 
*/ 
} // end of class Student3 

class ClassTotalComparator1 implements Comparator<Student3> { 
      public int compare(Student3 s1, Student3 s2) { 
            int result = s1.classNo - s2.classNo; 

            if(result==0) 
                  result = s2.total - s1.total; 

            return result; 
      } 
} 

class ClassStudent3NoComparator implements Comparator<Student3> { 
      public int compare(Student3 s1, Student3 s2) { 

            int result = s1.classNo - s2.classNo; 

            if(result==0) 
                  result = s1.Student3No - s2.Student3No; 

            return result; 
      } 
} 
