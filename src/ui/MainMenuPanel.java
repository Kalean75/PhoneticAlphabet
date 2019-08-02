package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class MainMenuPanel extends JPanel {

	protected JButton btnQuiz;
	protected JButton btnStudy;

	/**
	 * Create the panel.
	 */
	public MainMenuPanel() {
		setBorder(new EmptyBorder(5, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 414, 228);
		
		JLabel lblTitle = new JLabel("Main Menu");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblTitle, BorderLayout.NORTH);
		
		JPanel controlPanel = new JPanel();
		add(controlPanel, BorderLayout.SOUTH);
		
		JButton btnStudy = createStudyBtn();
		controlPanel.add(btnStudy);
		
		JButton btnQuiz = createQuizBtn();
		controlPanel.add(btnQuiz);

	}

	private JButton createQuizBtn() {
		btnQuiz = new JButton("Quiz");
		btnQuiz.setPreferredSize(new Dimension(120, 23));
		return btnQuiz;
	}

	private JButton createStudyBtn() {
		btnStudy = new JButton("Study");
		btnStudy.setPreferredSize(new Dimension(120, 23));
		return btnStudy;
	}

}
