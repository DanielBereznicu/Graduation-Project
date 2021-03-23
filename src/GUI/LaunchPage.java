package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LaunchPage implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton manageMembers = new JButton("Manage members");
	JButton managePtrainers = new JButton("Manage trainers");

	public LaunchPage() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(450, 450);
		panel.setLayout(null);
		frame.setVisible(true);
		frame.add(panel);

		manageMembers.setBounds(120, 100, 200, 40);
		manageMembers.addActionListener(this);
		panel.add(manageMembers);

		managePtrainers.setBounds(120, 160, 200, 40);
		managePtrainers.addActionListener(this);
		panel.add(managePtrainers);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == manageMembers) {
			frame.dispose();
			ManageMembers members = new ManageMembers();
		}
		if (e.getSource() == managePtrainers) {
			frame.dispose();
			ManagePTrainers trainers = new ManagePTrainers();
		}

	}

}
