package ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class CustomQuizPanel extends JPanel {
	private JTextField txtQuestionpath;
	private JTextField txtAnswerpath;

	/**
	 * Create the panel.
	 */
	public CustomQuizPanel() {
		setBorder(new EmptyBorder(20, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Custom Quiz");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblTitle, BorderLayout.NORTH);
		
		JPanel buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnBack = new JButton("Back");
		btnBack.setPreferredSize(new Dimension(120, 23));
		buttonPanel.add(btnBack);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setPreferredSize(new Dimension(120, 23));
		buttonPanel.add(btnSubmit);
		
		JPanel textFieldPanel = createTextFieldPanel();
		add(textFieldPanel, BorderLayout.CENTER);


	}

	private JPanel createTextFieldPanel() {
		JPanel textFieldPanel = new JPanel();
		textFieldPanel.setBorder(new EmptyBorder(50, 0, 0, 0));

		textFieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		createTxtQuestionPath();
		createTxtAnswerPath();
		textFieldPanel.add(txtQuestionpath);
		textFieldPanel.add(txtAnswerpath);
		return textFieldPanel;
	}

	private void createTxtAnswerPath() {
		txtAnswerpath = new JTextField();
		txtAnswerpath.setHorizontalAlignment(SwingConstants.CENTER);
		txtAnswerpath.setText("filepath for <answers>.txt");
		txtAnswerpath.setColumns(30);
	}

	private void createTxtQuestionPath() {
		txtQuestionpath = new JTextField();
		txtQuestionpath.setHorizontalAlignment(SwingConstants.CENTER);
		txtQuestionpath.setText("filepath for <questions>.txt");
		txtQuestionpath.setColumns(30);
	}

}
