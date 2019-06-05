package guiProgramming;

import java.awt.*;
import javax.swing.*;

class WindowExample02 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Program"); // Hello Program을 타이블바로 가진 프레임 생성
		frame.setPreferredSize(new Dimension(200, 70)); // 프레임 크기 조정
		frame.setLocation(800, 400); // 실행 시 프레임이 위치할 곳 지정
		Container contentPane = frame.getContentPane(); // contentPane 생성
		JTextField text = new JTextField(); 
		JButton button = new JButton("확인"); // 확인버튼 생성
		JLabel label = new JLabel("Hello"); // Hello 라벨 생성
		contentPane.add(text, BorderLayout.CENTER); // 중간에 텍스트 배치
		contentPane.add(button, BorderLayout.EAST); // 오른쪽에 버튼 배치
		contentPane.add(label, BorderLayout.SOUTH); // 아래(남쪽)에 라벨 배치
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x표 누르면 프레임이 닫히게 설정
		frame.pack(); // 프레임을 적절한 크기로 조정
		frame.setVisible(true); // 이 부분이 없으면 실행해도 뜨지않음
	}
}