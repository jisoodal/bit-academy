package textToolEx;

import java.awt.*; 
import java.awt.event.*; 
import java.util.*; 

public class TextToolEx07 extends Frame implements WindowListener 
{ 
      TextArea ta; 
      TextField tfParam1, tfParam2; 
      Panel pNorth, pSouth; 
      Label lb1, lb2; 

      String[] btnName = { 
            "Undo",                // 작업이전 상태로 되돌림 
            "짝수줄삭제",        // 짝수줄을 삭제하는 기능 
            "문자삭제",           // Param1에 지정된 문자들을 삭제하는 기능 
            "trim",                  // 라인의 앞뒤 공백을 제거 
            "빈줄삭제",          // 빈 줄 삭제 
            "접두사추가",       // Param1과 Param2의 문자열을 각 라인의 앞뒤에 붙이는 기능 
            "substring",         // Param1과 Param2에 지정된 문자열을 각 라인에서 제거하는 기능 
            "substring2",       // Param1과 Param2에 지정된 문자열로 둘러싸인 부분을 남기고 제거하는 기능 
      }; 

      Button[] btn = new Button[btnName.length]; 

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

            btn[n++].addActionListener(new ActionListener() { // 짝수줄삭제 - 짝수줄을 삭제하는 기능 
                  public void actionPerformed(ActionEvent ae) { 
                           /*  내용 생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // 문자삭제 - Param1에 지정된 문자를 삭제하는 기능 
                  public void actionPerformed(ActionEvent ae) { 
                           /*  내용 생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // trim - 라인의 좌우공백을 제거하는 기능 
                  public void actionPerformed(ActionEvent ae) { 
                           /*  내용 생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // 빈줄삭제 - 빈 줄 삭제 
                  public void actionPerformed(ActionEvent ae) { 
                           /*  내용 생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // 접두사 - 각 라인에 접두사, 접미사 붙이기 
                  public void actionPerformed(ActionEvent ae) { 
                           /*  내용 생략 */

                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // substring - 문자열 자르기 
                  public void actionPerformed(ActionEvent ae) { 
                        String curText = ta.getText(); 
                        StringBuffer sb = new StringBuffer(curText.length()); 

                        prevText = curText; 

                        int from = tfParam1.getText().length(); 
                        int to = tfParam2.getText().length(); 

                        Scanner s = new Scanner(curText); 

                        for(int i=0;s.hasNextLine();i++) { 
                              String line = s.nextLine(); 

                              if(line.length() < from + to) return; 

                              sb.append(line.substring(from, line.length()-to)); 
                              sb.append(CR_LF); 
                        } 

                        ta.setText(sb.toString()); 
                  } 
            }); 

            btn[n++].addActionListener(new ActionListener() { // substring2 - 지정된 문자를 찾아서 그 위치까지 잘라내기 
                  public void actionPerformed(ActionEvent ae) { 
                        String curText = ta.getText(); 
                        StringBuffer sb = new StringBuffer(curText.length()); 

                        prevText = curText; 
//                       1. param1과 param2의 값을 가져온다.(getText()사용)
                        
                        String from = tfParam1.getText(); 
                        String to = tfParam2.getText(); 
                        

//                       2. Scanner클래스와 반복문을 이용해서 curText를 라인단위로 읽는다.
                        
                        Scanner scanner = new Scanner(curText);
                        
                        for(int i=0;scanner.hasNextLine();i++) {
                        	String line = scanner.nextLine();
                        	
//                          3. 각 라인에서 param1, param2과 일치하는 문자열의 위치를 찾는다.

//                          (param1은 라인의 왼쪽끝부터, param2는 라인의 오른쪽끝부터 찾기 시작한다.)

//                           param1과 param2로 둘러쌓인 부분을 sb에 저장한다.
                        	
                        	int a1 = line.indexOf(from);
                        	int a2 = line.lastIndexOf(to);
                        	
                        	a1 += from.length(); // from이 시작한 지점부터 from의 길이만큼
                        	
                        	sb.append(line.substring(a1, a2)).append(CR_LF);
                        }
                        ta.setText(sb.toString());
//                       4. sb의 내용을 TextArea에 보여준다.


                  } 
            }); 
      }       // end of registerEventHandler() 

      public static void main(String[] args) { 
            TextToolEx07 win = new TextToolEx07("Text Tool"); 
            win.show(); 
      } 

      public TextToolEx07(String title) { 
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
            pNorth.add(lb1); 
            pNorth.add(tfParam1); 
            pNorth.add(lb2); 
            pNorth.add(tfParam2); 

            pSouth.setLayout(new GridLayout(2,10)); 

            for(int i=0; i < btn.length;i++) {             // 버튼배열을 하단 Panel에 넣는다. 
                  pSouth.add(btn[i]); 
            } 

            add(pNorth,"North"); 
            add(ta,"Center"); 
            add(pSouth,"South"); 

            setBounds(100, 100, 600, 300); 
            ta.requestFocus(); 
            registerEventHandler(); 
            setVisible(true); 
      } // public TextToolEx1(String title) { 

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
