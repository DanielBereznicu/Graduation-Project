package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
import javax.swing.table.DefaultTableModel;

import ro.itschool.entity.PTrainer;
import ro.itschool.enums.Specializations;
import ro.itschool.service.PTrainerService;

public class ManagePTrainers {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JLabel nameLabel;
	JTextField nameText;

	JLabel surnameLabel;
	JTextField surnameText;

	JLabel specializationLabel;
	JComboBox specializationBox;

	JTable table;
	DefaultTableModel model;
	JScrollPane scrollPane;

	JButton delete;
	JButton add;
	JButton back;

	ManagePTrainers() {

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		panel.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().add(panel);

		// NAME
		nameLabel = new JLabel("Name");
		nameLabel.setBounds(9, 11, 61, 30);
		panel.add(nameLabel);

		nameText = new JTextField();
		nameText.setBounds(121, 11, 202, 30);
		panel.add(nameText);

		// SURNAME
		surnameLabel = new JLabel("Surname");
		surnameLabel.setBounds(9, 52, 61, 30);
		panel.add(surnameLabel);

		surnameText = new JTextField();
		surnameText.setBounds(121, 52, 202, 30);
		panel.add(surnameText);

		// SPECIALIZATION
		specializationLabel = new JLabel("Specialization");
		specializationLabel.setBounds(9, 93, 80, 30);
		panel.add(specializationLabel);

		List<Specializations> specializations = new ArrayList<Specializations>(Arrays.asList(Specializations.values()));

		specializationBox = new JComboBox<>(specializations.toArray());
		specializationBox.setBounds(123, 93, 200, 30);
		panel.add(specializationBox);

		// TABLE
		table = new JTable();
		model = new DefaultTableModel();
		PTrainerService trainerService = new PTrainerService();
		List<PTrainer> trainers = new ArrayList<PTrainer>();
		trainers = (trainerService.findAllPTrainers());

		Object[] columnName = new Object[4];
		columnName[0] = "Id";
		columnName[1] = "Name";
		columnName[2] = "Surname";
		columnName[3] = "Specialization";
		model.setColumnIdentifiers(columnName);

		Object[] row = new Object[4];
		for (int i = 0; i < trainers.size(); i++) {
			row[0] = trainers.get(i).getId();
			row[1] = trainers.get(i).getName();
			row[2] = trainers.get(i).getSurname();
			row[3] = trainers.get(i).getSpecializations();
			model.addRow(row);
		}
		table.setModel(model);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(333, 11, 440, 434);
		scrollPane.setViewportView(table);
		panel.add(scrollPane);
		table.setAutoCreateRowSorter(true);
		
		//ADD 
		add = new JButton("Add");
		add.setBounds(129, 186, 80, 30);
		panel.add(add);
		add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameText.getText().equals("") || surnameText.getText().equals("") || 
						specializationBox.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Please fill up all the details");
				}else {
					PTrainerService trainerService = new PTrainerService();
					PTrainer trainer = new PTrainer();
					trainer.setName(nameText.getText());
					trainer.setSurname(surnameText.getText());
					trainer.setSpecializations((Specializations) specializationBox.getSelectedItem());
					
					trainerService.savePTrainer(trainer);
					JOptionPane.showMessageDialog(null, "Saved successfully");
					frame.dispose();
					ManagePTrainers manageTrainer = new ManagePTrainers();
				}
				
			}
		});
		//BACK
		back = new JButton("Back");
		back.setBounds(9, 186, 80, 30);
		panel.add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LaunchPage launchpage = new LaunchPage(); 
				
			}
		});
		
		//DELETE
		delete = new JButton("Delete");
		delete.setBounds(243, 186, 80, 30);
		panel.add(delete);
		
	}

}
