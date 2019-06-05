package guiProgramming;

import java.awt.*;
import javax.swing.*;

class WindowExample02 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Hello Program"); // Hello Program�� Ÿ�̺�ٷ� ���� ������ ����
		frame.setPreferredSize(new Dimension(200, 70)); // ������ ũ�� ����
		frame.setLocation(800, 400); // ���� �� �������� ��ġ�� �� ����
		Container contentPane = frame.getContentPane(); // contentPane ����
		JTextField text = new JTextField(); 
		JButton button = new JButton("Ȯ��"); // Ȯ�ι�ư ����
		JLabel label = new JLabel("Hello"); // Hello �� ����
		contentPane.add(text, BorderLayout.CENTER); // �߰��� �ؽ�Ʈ ��ġ
		contentPane.add(button, BorderLayout.EAST); // �����ʿ� ��ư ��ġ
		contentPane.add(label, BorderLayout.SOUTH); // �Ʒ�(����)�� �� ��ġ
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // xǥ ������ �������� ������ ����
		frame.pack(); // �������� ������ ũ��� ����
		frame.setVisible(true); // �� �κ��� ������ �����ص� ��������
	}
}