package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class QuizPanel extends JPanel {

	protected JButton btnStart;
	protected JPanel controlPanel;
	protected JLabel lblQuestion;
	protected JTextField answerField;

	/**
	 * Create the panel.
	 */
	public QuizPanel() {

		setBorder(new EmptyBorder(50, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 414, 228);
		
		lblQuestion = new JLabel("The question will appear here. Type in your answer then press enter.");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblQuestion, BorderLayout.NORTH);
		
		btnStart = createStartButton();
		answerField = createAnswerField();
		
		controlPanel = new JPanel();
		controlPanel.add(btnStart);
		add(controlPanel, BorderLayout.SOUTH);
	}

	private JButton createStartButton() {
		btnStart = new JButton("Start");
		btnStart.setPreferredSize(new Dimension(120, 23));
		btnStart.setMaximumSize(btnStart.getPreferredSize());
		return btnStart;
	}
	
	private JTextField createAnswerField() {
		JTextField textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("");
		textField.setColumns(12);
		return textField;
	}
	

}
