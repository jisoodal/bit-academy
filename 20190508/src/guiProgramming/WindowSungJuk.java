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

public class WindowSungJuk {

	public static void main(String[] args) {
		JFrame frame = new JFrame("성적 관리 프로그램");
		frame.setPreferredSize(new Dimension(900, 300));
		frame.setLocation(500, 300);
		Container contentPane = frame.getContentPane();
		String colNames[] = { "학번", "이름", "국어", "영어", "수학" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel panel = new JPanel();
		JTextField id = new JTextField(9);
		JTextField name = new JTextField(5);
		JTextField kor = new JTextField(2);
		JTextField eng = new JTextField(2);
		JTextField math = new JTextField(2);
		JButton add = new JButton("추가");
		JButton del = new JButton("삭제");
		JButton mod = new JButton("수정");
		JButton sel = new JButton("보기");

		panel.add(new JLabel("학번"));
		panel.add(id);
		panel.add(new JLabel("이름"));
		panel.add(name);
		panel.add(new JLabel("국어"));
		panel.add(kor);
		panel.add(new JLabel("영어"));
		panel.add(eng);
		panel.add(new JLabel("수학"));
		panel.add(math);
		panel.add(add);
		panel.add(del);
		panel.add(mod);
		panel.add(sel);

		contentPane.add(panel, BorderLayout.SOUTH);
		add.addActionListener(new AddActionListener2(table, id, name, kor, eng, math));
		del.addActionListener(new RemoveActionListener2(table));
		mod.addActionListener(new ModifyActionListener(table, id, name, kor, eng, math));
		sel.addActionListener(new SelectActionListener(table, id, name, kor, eng, math));

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}

class AddActionListener2 implements ActionListener {
	JTable table;
	JTextField id, name, kor, eng, math;

	AddActionListener2(JTable table, JTextField id, JTextField name, JTextField kor, JTextField eng, JTextField math) {
		this.table = table;
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void actionPerformed(ActionEvent e) {
		String arr[] = new String[5];
		arr[0] = id.getText();
		arr[1] = name.getText();
		arr[2] = kor.getText();
		arr[3] = eng.getText();
		arr[4] = math.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(arr);
		
		id.setText("");
		name.setText("");
		kor.setText("");
		eng.setText("");
		math.setText("");
	}
}

class RemoveActionListener2 implements ActionListener {

	JTable table;

	RemoveActionListener2(JTable table) {
		this.table = table;
	}

	public void actionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row == -1) {
			System.out.println("삭제할 행이 없습니다.");
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.removeRow(row);
	}
}

class ModifyActionListener implements ActionListener {

	JTable table;
	JTextField id, name, kor, eng, math;

	ModifyActionListener(JTable table, JTextField id, JTextField name, JTextField kor, JTextField eng,
			JTextField math) {
		this.table = table;
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void actionPerformed(ActionEvent e) {
		// 누르면 그 행의 값을 TextField에 불러와야 함
		// 불러온 값을 변경하면 그게 적용이 되어야 함.

//		// TextField에 불러오기
		int select = table.getSelectedRow();

		// 불러오고 -> 새로운 값 넣고 -> 추가x 원래 있던 자리에 넣기
		String arr[] = new String[5];
		arr[0] = id.getText();
		arr[1] = name.getText();
		arr[2] = kor.getText();
		arr[3] = eng.getText();
		arr[4] = math.getText();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setValueAt(arr[0], select, 0);
		model.setValueAt(arr[1], select, 1);
		model.setValueAt(arr[2], select, 2);
		model.setValueAt(arr[3], select, 3);
		model.setValueAt(arr[4], select, 4);
		
		id.setText("");
		name.setText("");
		kor.setText("");
		eng.setText("");
		math.setText("");

	}
}

class SelectActionListener implements ActionListener {

	JTable table;
	JTextField id, name, kor, eng, math;

	SelectActionListener(JTable table, JTextField id, JTextField name, JTextField kor, JTextField eng,
			JTextField math) {
		this.table = table;
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public void actionPerformed(ActionEvent e) {
		int select = table.getSelectedRow();

		if (select != -1) {
			id.setText((table.getValueAt(select, 0)).toString());
			name.setText((table.getValueAt(select, 1)).toString());
			kor.setText((table.getValueAt(select, 2)).toString());
			eng.setText((table.getValueAt(select, 3)).toString());
			math.setText((table.getValueAt(select, 4)).toString());
		}
	}

}
