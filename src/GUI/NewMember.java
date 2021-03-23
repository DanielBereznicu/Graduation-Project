package GUI;

import com.toedter.calendar.JDateChooser;
import ro.itschool.entity.Member;
import ro.itschool.entity.PTrainer;
import ro.itschool.service.MemberService;
import ro.itschool.service.PTrainerService;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class NewMember implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JLabel nameLabel = new JLabel("Name");
	JTextField nameField = new JTextField();

	JLabel surnameLabel = new JLabel("Surname");
	JTextField surnameField = new JTextField();

	JLabel dateOfBirthLabel = new JLabel("Date of birth");
	JDateChooser dateOfBirth = new JDateChooser();

	JLabel trainerLabel = new JLabel("Choose a trainer");
	JComboBox comboBox;

	JButton create = new JButton("Add");
	JButton back = new JButton("Back");
	List<PTrainer> trainers = new ArrayList<PTrainer>();

	JTable table = new JTable();

	List<Member> members = new ArrayList<Member>();
	JScrollPane scrollPane = new JScrollPane();

	JTextField search = new JTextField();
	JButton searchButton = new JButton("Search");

	JButton delete = new JButton("Delete");
	List<Member> memberFilter = new ArrayList<Member>();

	NewMember() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		panel.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().add(panel);

		// Name
		nameLabel.setBounds(9, 11, 61, 30);
		panel.add(nameLabel);

		nameField.setBounds(121, 11, 202, 30);
		panel.add(nameField);

		// Surname
		surnameLabel.setBounds(9, 52, 61, 30);
		panel.add(surnameLabel);

		surnameField.setBounds(121, 52, 202, 30);
		panel.add(surnameField);

		// DOB
		dateOfBirthLabel.setBounds(9, 93, 80, 30);
		panel.add(dateOfBirthLabel);

		dateOfBirth.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateOfBirth.setForeground(new Color(105, 105, 105));
		dateOfBirth.setBounds(123, 93, 200, 30);
		dateOfBirth.setDateFormatString("dd/MM/yyyy");
		panel.add(dateOfBirth);

		// Ptrainer
		trainerLabel.setBounds(9, 134, 102, 30);
		panel.add(trainerLabel);

		PTrainerService pTrainerService = new PTrainerService();

		trainers = (pTrainerService.findAllPTrainers());
		ArrayList<String> lista = new ArrayList<>();
		for (PTrainer s : trainers) {
			lista.add(s.getName() + " " + s.getSurname() + " " + " (" + s.getSpecializations() + ")");
		}

		comboBox = new JComboBox<>(lista.toArray());
		comboBox.setBounds(121, 134, 202, 30);
		panel.add(comboBox);
		// Create

		create.setBounds(243, 186, 80, 30);
		create.addActionListener(this);
		panel.add(create);
		// Back

		back.setBounds(9, 457, 80, 30);
		back.addActionListener(this);
		panel.add(back);

		// TABLE MEMBER
		MemberService memberService = new MemberService();
		members = (memberService.findAllMembers());

		memberFilter = members;
		updateTable(memberFilter);

		// Search field
		search.setBounds(9, 248, 150, 30);
		panel.add(search);

		searchButton.setBounds(243, 248, 80, 30);
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String text = search.getText();
				if (text.length() == 0) {
					memberFilter = members;
				} else {
					List<Member> memberFl = new ArrayList<Member>();
					for (Member i : members) {
						if (i.getName().contains(text) || i.getSurname().contains(text)
								|| i.getDateOfBirth().toString().contains(text)
								|| (i.getPTrainer() != null && i.getPTrainer().getName().contains(text)))

							memberFl.add(i);
					}
					memberFilter = memberFl;

				}

				updateTable(memberFilter);
			}

		});

		panel.add(searchButton);
//		table.setRowSorter(sorter);

		delete.setBounds(9, 186, 81, 30);
		panel.add(delete);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MemberService memberService = new MemberService();

				int row = table.getSelectedRow();
				int id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
				memberService.deleteById(id);
				NewMember newMember = new NewMember();
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {
			frame.dispose();
			ManageMembers manageMembers = new ManageMembers();

		}
		if (e.getSource() == create) {
			frame.dispose();
			if (nameField.getText().equals("") || surnameField.getText().equals("") || dateOfBirth.getDate().equals("")
					|| comboBox.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill up all the details");
				NewMember newMember = new NewMember();
			} else {

				MemberService memberService = new MemberService();
				PTrainerService pTrainerService = new PTrainerService();
				Member member = new Member();
				member.setName(nameField.getText());
				member.setSurname(surnameField.getText());
				member.setDateOfBirth(dateOfBirth.getDate());
				member.setPTrainer(trainers.get(comboBox.getSelectedIndex()));

				memberService.saveMember(member);
				JOptionPane.showMessageDialog(null, "Saved successfully");
				NewMember newMember = new NewMember();

			}

		}

	}

	private void updateTable(List<Member> memberList) {

		DefaultTableModel model = new DefaultTableModel();
		Object[] columnName = new Object[5];
		columnName[0] = "Id";
		columnName[1] = "Name";
		columnName[2] = "Surname";
		columnName[3] = "Date of birth";
		columnName[4] = "Trainer";
		model.setColumnIdentifiers(columnName);

		Object[] row = new Object[5];
		for (int i = 0; i < memberList.size(); i++) {
			row[0] = memberList.get(i).getId();
			row[1] = memberList.get(i).getName();
			row[2] = memberList.get(i).getSurname();
			row[3] = memberList.get(i).getDateOfBirth();
			PTrainer trainer = memberList.get(i).getPTrainer();
			if (trainer != null)
				row[4] = trainer.getId();
			else
				row[4] = "null";
			model.addRow(row);
		}

		table.setModel(model);
		scrollPane.setBounds(333, 11, 440, 434);
		scrollPane.setViewportView(table);
		panel.add(scrollPane);
		table.setAutoCreateRowSorter(true);

	}
}
