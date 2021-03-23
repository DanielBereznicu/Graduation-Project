package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ManageMembers implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton newMember = new JButton("Add new member");
	JButton searchMember = new JButton("Search member");
	JButton back = new JButton("Back");

	ManageMembers() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 450);
		panel.setLayout(null);
		frame.setVisible(true);
		frame.add(panel);

		newMember.setBounds(120, 120, 200, 40);
		newMember.addActionListener(this);
		panel.add(newMember);


		searchMember.setBounds(120, 180, 200, 40);
		searchMember.addActionListener(this);
		panel.add(searchMember);

		back.setBounds(180, 260, 80, 30);
		back.addActionListener(this);
		panel.add(back);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newMember) {
			frame.dispose();
			NewMember newMembers = new NewMember();
		}
		if (e.getSource() == searchMember) {
			frame.dispose();
			SearchMember searchMembers = new SearchMember();
		}
		if (e.getSource() == back) {
			frame.dispose();
			LaunchPage launchPage = new LaunchPage();

		}

	}
}
