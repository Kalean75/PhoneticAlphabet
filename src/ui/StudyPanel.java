package ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudyPanel extends JPanel {

	protected JButton btnFwd;
	protected JButton btnBack;
	protected JLabel lblTitle;
	protected JLabel lblQuestion;
	protected JPanel controlPanel;
	protected JButton btnMenu;
	protected JButton btnQuiz;
	/**
	 * Create the panel.
	 */
	public StudyPanel() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 414, 228);
		
		lblTitle = new JLabel("Study");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTitle, BorderLayout.NORTH);
		
		lblQuestion = new JLabel("Question appears here");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblQuestion, BorderLayout.CENTER);
		
		controlPanel = new JPanel();
		add(controlPanel, BorderLayout.SOUTH);
		
		createMenubtn(controlPanel);
		
		createBackBtn(controlPanel);
		createFwdBtn(controlPanel);
		
		createQuizbtn(controlPanel);
	}
	private void createMenubtn(JPanel controlPanel) {
		btnMenu = new JButton("Main Menu");
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		controlPanel.add(btnMenu);
	}
	private void createQuizbtn(JPanel controlPanel) {
		btnQuiz = new JButton("Take Quiz");
		btnQuiz.setFont(new Font("Tahoma", Font.PLAIN, 12));
		controlPanel.add(btnQuiz);
	}
	private void createBackBtn(JPanel controlPanel) {
		btnBack = new JButton("  <");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		controlPanel.add(btnBack);
	}
	private void createFwdBtn(JPanel controlPanel) {
		btnFwd = new JButton("   >");
		btnFwd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		controlPanel.add(btnFwd);
	}

}
