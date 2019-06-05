package guiProgramming;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class WindowExample08 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("������ ��� ���α׷�");
		frame.setPreferredSize(new Dimension(400, 200));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		String colNames[] = {"�̸�", "����", "����" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table),
				BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JTextField text1 = new JTextField(6);
		JTextField text2 = new JTextField(3);
		JTextField text3 = new JTextField(2);
		JButton button1 = new JButton("�߰�");
		JButton button2 = new JButton("����");
		panel.add(new JLabel("�̸�"));
		panel.add(text1);
		panel.add(new JLabel("����"));
		panel.add(text2);
		panel.add(new JLabel("����"));
		panel.add(text3);
		panel.add(button1);
		panel.add(button2);
		contentPane.add(panel, BorderLayout.SOUTH);
		button1.addActionListener(
				new AddActionListener(table, text1, text2, text3));
		button2.addActionListener(new RemoveActionListener(table));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}

class AddActionListener implements ActionListener { 
	JTable table;
	JTextField text1, text2, text3;
	AddActionListener(JTable table, JTextField text1, JTextField text2, JTextField text3) {
		this.table = table;
		this.text1 = text1;
		this.text2 = text2;
		this.text3 = text3;	
	}
	public void actionPerformed(ActionEvent e) {
		String arr[] = new String[3];
		arr[0] = text1.getText();
		arr[1] = text2.getText();
		arr[2] = text3.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(arr);
	}
}

class RemoveActionListener implements ActionListener {
	
	JTable table;
	RemoveActionListener(JTable table) {
		this.table = table;
	}
	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if(row == -1) {
			System.out.println("������ ���� �����ϴ�.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) 
				table.getModel();
		model.removeRow(row);
	}
}
