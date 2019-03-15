package textToolEx;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set; 

public class TextTool extends Frame implements WindowListener,Comparator 
{ 
      TextArea ta; 
      TextField tfParam1, tfParam2; 
      Panel pNorth, pSouth; 
      Label lb1, lb2; 

      String[] btnName = { 
            "Undo",         // 작업이전 상태로 되돌림 
            "Erase Even Line(s)", // 짝수줄을 삭제하는 기능 
            "Erase Words",    // Param1에 지정된 문자들을 삭제하는 기능 
            "Substring2",           // 라인의 앞뒤 공백을 제거 
            "Distinct",   // 빈 줄 삭제 
            "Distinct2",  // Param1과 Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능 
            "ClipBoard",       // Param1과 Param2에 지정된 문자열을 각 라인에서 제거하는 기능 
            "File DownLoad"
      }; 

      Button[] btn = new Button[btnName.length];
      
      Checkbox option = new Checkbox("option"); // 인스턴스 변수를 사용해야 함. 지역변수에 선언하면 안됨.
      
      private final String CR_LF = System.getProperty("line.separator"); // 줄바꿈문자 

      private String prevText =""; 

      private void registerEventHandler() { 
            addWindowListener(this); 

            int n = 0; // 버튼순서 

            btn[n++].addActionListener(new ActionListener() { // Undo - 작업이전 상태로 되돌림 
                  public void actionPerformed(ActionEvent ae) { 
                        String curText = ta.getText(); 

                        if(!prevText.equals("")) { 
                              ta.setText(prevText);                         
                        } 

                        prevText = curText; 
                  } 
            }); 
           
            btn[n++].addActionListener(new ActionListener() { // 짝수줄삭제 
                  public void actionPerformed(ActionEvent ae) { 
                	  
                      String get = ta.getText();
                      int count = 0;
                     
                      String param2 = tfParam1.getText();

                      StringBuffer sb = new StringBuffer(get.length());

                      Scanner scanner = new Scanner(get);

                      if(!(option.getState())) {                	  	
                       for(int i=0;scanner.hasNextLine();i++) {
                           String line = scanner.nextLine();
                             if(i%2 == 0) {
                                sb.append(line).append(CR_LF); // 줄바꿈까지 인식하고 있어야 함
                             	  	}
                             	  }
                             	ta.setText(sb.toString());
                          }
                      else {
                    	  int param1 = Integer.parseInt(tfParam1.getText());
                    	  
                    	  for(int i=1;scanner.hasNextLine();i++) {
                    		  String line = scanner.nextLine();
                    		  
                    		  if(i != param1)
                    			  sb.append(line).append(CR_LF);
                    	  }
                    	  ta.setText(sb.toString());
                      }           	 
                  }                  
            });

            btn[n++].addActionListener(new ActionListener() { // 문자삭제  
                  public void actionPerformed(ActionEvent ae) { 
                	  
                      String curText = ta.getText(); 
                      StringBuffer sb = new StringBuffer(curText.length()); 

                      prevText = curText; 

                      String delText = tfParam1.getText();
                      
                   if(!(option.getState())) {   
                      for(int i=0;i<curText.length();i++) {
                      	char c = curText.charAt(i);

                      	if(delText.indexOf(c) == -1)
                      		sb.append(c);
                      }
   
                      ta.setText(sb.toString());
                   }
                   else {
                	   for(int i=0;i<curText.length();i++) {
                		   char c = curText.charAt(i);
                		   
                		   if(!(delText.indexOf(c) == -1))
                			   sb.append(c);
                	   }
                	   ta.setText(sb.toString());
                   }

                } 
          }); 

            btn[n++].addActionListener(new ActionListener() { // substring2 
                  public void actionPerformed(ActionEvent ae) { 
                      String curText = ta.getText(); 
                      StringBuffer sb = new StringBuffer(curText.length()); 

                      prevText = curText; 
                    
                      String from = tfParam1.getText(); 
                      String to = tfParam2.getText(); 
                   
                      Scanner scanner = new Scanner(curText);
                      
                      if(!(option.getState())) {
                      
                      for(int i=0;scanner.hasNextLine();i++) {
                      	String line = scanner.nextLine();
           	
                      	int a1 = line.indexOf(from);
                      	int a2 = line.lastIndexOf(to);
                      	
                      	a1 += from.length(); // from이 시작한 지점부터 from의 길이만큼
                      	
                      	sb.append(line.substring(a1, a2)).append(CR_LF);
                      }
                      ta.setText(sb.toString());
                     }
                     else {
                      if(from.length()<2) {
                    	  for(int i=0;i<curText.length();i++) {
                    		  char c = curText.charAt(i);
                    		  System.out.println(from.length());
               		   
                   			  if(!(from.indexOf(c) == -1) || !(to.indexOf(c) == -1))
                   				  sb.append(c);
                    	  }
                   	   }
                      else {
                    	  for(int i=0;scanner.hasNextLine();i++) {
                    		  String line = scanner.nextLine();
                    		  int a1 = line.indexOf(from);
                              int a2 = line.lastIndexOf(to);
                            	
                              sb.append(line.substring(a1, a1+from.length()));
                              sb.append(line.substring(a2, a2+to.length()));  
                              sb.append(CR_LF);
                    	  }
                      }
                    }
                      ta.setText(sb.toString());
             } 
          }); 

            btn[n++].addActionListener (new ActionListener() { // distinct
                  public void actionPerformed(ActionEvent ae) { 
                      String curText = ta.getText(); 
                      StringBuffer sb = new StringBuffer(curText.length()); 

                      prevText = curText; 

                      Set hash = new HashSet();
                      
                      ArrayList al = new ArrayList();
                      
                      Scanner scanner = new Scanner(curText);
                      
                      if(!(option.getState())) {
                      
                    	  for(int i=0;scanner.hasNextLine();i++) {
                    		  String line = scanner.nextLine();                        	
                    		  hash.add(line);
                    	  }
                      	 
                    	  ArrayList list = new ArrayList(hash); 
                      
                    	  Collections.sort(list); // 여기서 중복이 제거됨 
                      	
                    	  for(int i=0;i<list.size();i++)
                    		  sb.append(list.get(i)).append(CR_LF); // 중복이 제거된 list 저장
   
                    	  ta.setText(sb.toString());
                      }
                      
                      else {
                    	  for(int i=0;scanner.hasNextLine();i++) {
                    		  String line = scanner.nextLine();
                    		  
                    		  al.add(line);
                    		                    		  
                    		  
                    	  }
                    	  ta.setText(sb.toString());
                    	  
                      }
                } 
          }); 
            
            btn[n++].addActionListener(new ActionListener() { // distinct2 
                public void actionPerformed(ActionEvent ae) { 
                         /* 내용 생략 */
                } 
          }); 

            btn[n++].addActionListener(new ActionListener() { // clipboard
                  public void actionPerformed(ActionEvent ae) { 
                      
                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // File DownLoad
                  public void actionPerformed(ActionEvent ae) { 
                	  
                  } 
            }); 

      }       // end of registerEventHandler() 
      
      

      public static void main(String[] args)  { 
            TextTool win = new TextTool("Text Tool"); 
            win.show(); 
      } 

      public TextTool(String title) { 
            super(title); 
            
            lb1 = new Label("param1:", Label.RIGHT); 
            lb2 = new Label("param2:", Label.RIGHT); 
            tfParam1 = new TextField(15); 
            tfParam2 = new TextField(15); 

            ta = new TextArea(); 
            pNorth = new Panel(); 
            pSouth = new Panel();

            for(int i=0;i < btn.length;i++) {

                  btn[i] = new Button(btnName[i]); 
            } 

            pNorth.setLayout(new FlowLayout()); 
            pNorth.add(option);
            pNorth.add(lb1); 
            pNorth.add(tfParam1); 
            pNorth.add(lb2); 
            pNorth.add(tfParam2); 

            pSouth.setLayout(new GridLayout(2,10)); 

            for(int i=0;i < btn.length;i++) {  // 버튼배열을 하단 Panel에 넣는다. 
                  pSouth.add(btn[i]); 
            } 

            add(pNorth,"North"); 
            add(ta,"Center"); 
            add(pSouth,"South"); 

            setBounds(100, 100, 600, 300); 
            ta.requestFocus(); 
            registerEventHandler(); 
            setVisible(true); 
      } // public TextTool(String title) { 

      public void windowOpened(WindowEvent e) {} 
      public void windowClosing(WindowEvent e) { 
            e.getWindow().setVisible(false); 
            e.getWindow().dispose(); 
            System.exit(0); 
      } 
      public void windowClosed(WindowEvent e) {} 
      public void windowIconified(WindowEvent e) {} 
      public void windowDeiconified(WindowEvent e) {} 
      public void windowActivated(WindowEvent e) {} 
      public void windowDeactivated(WindowEvent e) {} 
} // end of class 