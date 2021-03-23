package GUI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ro.itschool.entity.Member;
import ro.itschool.entity.PTrainer;
import ro.itschool.service.MemberService;

public class SearchMember {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	List<Member> members = new ArrayList<Member>();
	JScrollPane scrollPane = new JScrollPane();

	SearchMember() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650, 650);
		panel.setLayout(null);
		frame.setVisible(true);
		frame.add(panel);
		
		
		
		
        //Table members
		MemberService memberService = new MemberService();
		members = (memberService.findAllMembers());

		Object[] columnName = new Object[5];
		columnName[0] = "Id";
		columnName[1] = "Name";
		columnName[2] = "Surname";
		columnName[3] = "Date of birth";
		columnName[4] = "Trainer";
		model.setColumnIdentifiers(columnName);

		Object[] row = new Object[5];
		for (int i = 0; i < members.size(); i++) {
			row[0] = members.get(i).getId();
			row[1] = members.get(i).getName();
			row[2] = members.get(i).getSurname();
			row[3] = members.get(i).getDateOfBirth();
			PTrainer trainer = members.get(i).getPTrainer();
			if(trainer != null) 
				row[4] = trainer.getName() ;
			else row[4] = "null";
				
			
			
			

			model.addRow(row);

		}
		table.setModel(model);
		scrollPane.setBounds(20, 50, 500, 300);
		scrollPane.setViewportView(table);
		panel.add(scrollPane);

	}
}
