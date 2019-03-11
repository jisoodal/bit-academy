package day11;

import java.awt.*;
import java.awt.event.*;

class GraphicsEx2 extends Frame implements MouseMotionListener {
	int x = 0;
	int y = 0;

	public static void main(String[] args) {
		new GraphicsEx2("GraphicsEx2");
	}

	public GraphicsEx2(String title) {
		super(title);
		addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {

				System.exit(0);
			}
		});
		// Frame (100, 100) width 500, height 500 . 을 의 위치에 크기로 보이게 한다
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}

	public void paint(Graphics g) {
		g.drawString("마우스를 움직여보세요", 10, 50); // 마우스를 움직여보세요
		g.drawString("*", x, y);
	}

	public void mouseMoved(MouseEvent me) {
		x = me.getX();
		y = me.getY();
		repaint(); // repaint를 삭제하면 데이터는 바뀌고 있는데 찍어야할지를 모름
		System.out.printf("x=%d, y=%d \n" , x, y);
	}

	public void mouseDragged(MouseEvent me) {
	}
} // class
