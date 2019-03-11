package day11;

// ctrl+shift+f -> 복사해온 소스 한번에 들여쓰기

import java.awt.*;
import java.awt.event.*;

class GraphicsEx1 extends Frame {
	public static void main(String[] args) {

		new GraphicsEx1("GraphicsEx1");
	}

	public void paint(Graphics g) { // 자동 호출 (화면에 나타날 때 호출)AWT 스레드(일꾼)가 확인하고 그림 . 최소화 됐다가 다시 켰을때 등등
		g.setFont(new Font("Serif", Font.PLAIN, 15));
		g.drawString("Graphics .", 10, 50); // 를 이용해서 그림을 그립니다
		g.drawOval(50, 100, 50, 50);
		g.setColor(Color.blue);
		g.fillOval(100, 100, 50, 50);
		g.setColor(Color.red);
		g.drawLine(100, 100, 150, 150);
		g.fillRoundRect(200, 100, 120, 80, 30, 30);
		g.setColor(Color.orange);
		g.fillPolygon(new int[] { 50, 100, 150, 200 }, new int[] { 250, 200, 200, 250 }, 4);
		g.setColor(Color.cyan);
		g.fillArc(250, 200, 100, 100, 0, 120);
	}

	public GraphicsEx1(String title) {
		super(title);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
// Frame (100,100) width 400, height 300 . 을 의 위치에 크기로 보이게 한다
		setBounds(100, 100, 400, 300);
		setVisible(true);
	}
} // class
