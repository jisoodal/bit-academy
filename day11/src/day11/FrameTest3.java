package day11;

import java.awt.*;
import java.awt.event.*;

class FrameTest3 {
	public static void main(String args[]) {
		Frame f = new Frame("Login"); // Frame . 객체를 생성한다
		f.setSize(300, 200); // Frame . 의 크기를 설정한다
		// EventHandler Frame WindowListener . 클래스의 객체를 생성해서 의 로 등록한다
		f.addWindowListener(new EventHandler()); // 이벤트 소스와 이벤트 처리기 연결
		f.addKeyListener(new KeyEventHandler());
		f.addMouseListener(new MouseEventHandler());
		f.setVisible(true); // Frame . 생성한 을 화면에 보이도록 한다
		Button b = new Button("ok");
		f.add(b);
		
		b.addActionListener(new ActionEventHandler());
	}
}

class ActionEventHandler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("button clicked !!!!");
		
	}
}
// 1. 이벤트 처리기 작성
// 2. 이벤트 처리기(MouseEventHandler)를 생성해서 이벤트 소스(Frame)와 연결.
class MouseEventHandler implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse button clicked!!");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class KeyEventHandler implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Keypressed");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
// 창에 x자를 누르는 것이므로 f, 즉 프레임에 연결
class EventHandler implements WindowListener { // 이벤트 처리기
	// 이벤트가 발생하면 수행될 코드
	public void windowOpened(WindowEvent e) {}
	public void windowClosing(WindowEvent e) { // Frame . 의 닫기 버튼을 눌렀을 때 호출된다
		e.getWindow().setVisible(false); // Frame을 화면에서 보이지 않도록 하고
		e.getWindow().dispose(); // . 메모리에서 제거한다
		System.exit(0); // . 프로그램을 종료한다
}
	public void windowClosed(WindowEvent e) {} // 아무내용도 없는 메서드 구현
	public void windowIconified(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowActivated(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
}
