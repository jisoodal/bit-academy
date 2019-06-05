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

public class WindowExample09 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("성적 프로그램");
		frame.setPreferredSize(new Dimension(600,300));
		frame.setLocation(600, 400);
		Container contentPane = frame.getContentPane();
		
		String colNames[] = {"학번", "이름", "국어", "영어", "수학", "총점", "평균", "등급"};
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel textPanel = new JPanel();
		JTextField idText = new JTextField(6);
		JTextField nameText = new JTextField(6);
		JTextField korText = new JTextField(3);
		JTextField engText = new JTextField(3);
		JTextField mathText = new JTextField(3);
		
		JButton createButton = new JButton("추가");
		JButton deleteButton = new JButton("삭제");
		JButton updateButton = new JButton("수정");
		textPanel.add(new JLabel("학번"));
		textPanel.add(idText);
		textPanel.add(new JLabel("이름"));
		textPanel.add(nameText);
		textPanel.add(new JLabel("국어"));
		textPanel.add(korText);
		textPanel.add(new JLabel("영어"));
		textPanel.add(engText);
		textPanel.add(new JLabel("수학"));
		textPanel.add(mathText);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(createButton);
		buttonPanel.add(deleteButton);
		buttonPanel.add(updateButton);
		buttonPanel.setSize(500, 200);
		
		JPanel textButtonPanel = new JPanel(new BorderLayout());
		
		textButtonPanel.add(textPanel, BorderLayout.CENTER);
		textButtonPanel.add(buttonPanel, BorderLayout.SOUTH);
		contentPane.add(textButtonPanel, BorderLayout.SOUTH);
		
		createButton.addActionListener(new CreateActionListener(table, idText, nameText, korText, engText, mathText));
		deleteButton.addActionListener(new DeleteActionListener(table));
		updateButton.addActionListener(new UpdateActionListener(table, idText, nameText, korText, engText, mathText));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}

class CreateActionListener implements ActionListener {
	
	JTable table;
	JTextField idText;
	JTextField nameText;
	JTextField korText;
	JTextField engText;
	JTextField mathText;
	
	CreateActionListener(JTable table, JTextField idText, JTextField nameText, JTextField korText, JTextField engText,JTextField mathText){
		this.table = table;
		this.idText = idText;
		this.nameText = nameText;
		this.korText = korText;
		this.engText = engText;
		this.mathText = mathText;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String id = idText.getText();
		String name = nameText.getText();
		
		int kor = Integer.parseInt(korText.getText());
		int eng = Integer.parseInt(engText.getText());
		int math = Integer.parseInt(mathText.getText());
		
		
		SungJuk newSungjuk  = new SungJuk(id, name, kor, eng, math);
		
		Object[] arr = new Object[8];
		arr[0] = newSungjuk.getHakbun();
		arr[1] = newSungjuk.getName();
		arr[2] = newSungjuk.getKor();
		arr[3] = newSungjuk.getEng();
		arr[4] = newSungjuk.getMath();
		arr[5] = newSungjuk.getTotal();
		arr[6] = newSungjuk.getAvg();
		arr[7] = newSungjuk.getGrade();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(arr);
		
		idText.setText("");
		nameText.setText("");
		korText.setText("");
		engText.setText("");
		mathText.setText("");	
	}
}

class UpdateActionListener implements ActionListener {
	
	JTable table;
	JTextField idText;
	JTextField nameText;
	JTextField korText;
	JTextField engText;
	JTextField mathText;
	
	UpdateActionListener(JTable table, JTextField idText, JTextField nameText, JTextField korText, JTextField engText,JTextField mathText){
		this.table = table;
		this.idText = idText;
		this.nameText = nameText;
		this.korText = korText;
		this.engText = engText;
		this.mathText = mathText;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int row = table.getSelectedRow();
		
		if(row == -1) 
			return;
		
		String id = String.valueOf(table.getValueAt(row, 0));
		String name = String.valueOf(table.getValueAt(row, 1));
		
		int kor = Integer.parseInt(korText.getText());
		int eng = Integer.parseInt(engText.getText());
		int math = Integer.parseInt(mathText.getText());
		
		SungJuk newSungjuk  = new SungJuk(id, name, kor, eng, math);
		
		Object[] arr = new Object[8];
		arr[0] = newSungjuk.getHakbun();
		arr[1] = newSungjuk.getName();
		arr[2] = newSungjuk.getKor();
		arr[3] = newSungjuk.getEng();
		arr[4] = newSungjuk.getMath();
		arr[5] = newSungjuk.getTotal();
		arr[6] = newSungjuk.getAvg();
		arr[7] = newSungjuk.getGrade();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);
		model.insertRow(row, arr);
		
		korText.setText("");
		engText.setText("");
		mathText.setText("");
	}
}

class DeleteActionListener implements ActionListener {
	
	JTable table;
	
	DeleteActionListener(JTable table){
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		int row = table.getSelectedRow();
		
		if(row == -1)
			return;
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);
	}
}
