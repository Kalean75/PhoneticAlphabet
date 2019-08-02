package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;

public class StudyPanel extends JPanel {

	protected JButton btnBack;
	protected JButton btnFwd;
	/**
	 * Create the panel.
	 */
	public StudyPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Study");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle, BorderLayout.NORTH);
		
		JLabel lblQuestion = new JLabel("Question appears here");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblQuestion, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel();
		add(controlPanel, BorderLayout.SOUTH);
		
		btnFwd = new JButton("  <");
		btnFwd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		controlPanel.add(btnFwd);
		
		btnBack = new JButton("   >");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		controlPanel.add(btnBack);

	}

}