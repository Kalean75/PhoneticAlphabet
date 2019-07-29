package phoneticgui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class Quizgui extends JFrame {

	private JPanel contentPane;
	private JTextField answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quizgui frame = new Quizgui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Quizgui() {
		setMinimumSize(new Dimension(500, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 6, true));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel questionPanel = new JPanel();
		questionPanel.setOpaque(false);
		contentPane.add(questionPanel, BorderLayout.CENTER);
		
		/**
		* Panel for displaying the Questions and other information
		* TODO: implement functionality to update content based on navigation, etc.
		**/
		JLabel questionsl = new JLabel("Question");
		questionsl.setBackground(Color.WHITE);
		questionsl.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		questionsl.setHorizontalTextPosition(SwingConstants.CENTER);
		questionsl.setHorizontalAlignment(SwingConstants.CENTER);
		questionPanel.setLayout(new GridLayout(0, 1, 0, 0));
		questionPanel.add(questionsl);
		
		/**
	 	* Bottom control panel for answers/Navigation
		* TODO: add functionality/ actionlisteners
	 	*/
		JPanel controlPanel = new JPanel();
		contentPane.add(controlPanel, BorderLayout.SOUTH);
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
		
		JButton btnBack = new JButton("<");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setActionCommand("<");
		controlPanel.add(btnBack);
		
		JButton btnFwd = new JButton(">");
		btnFwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFwd.setActionCommand(">");
		controlPanel.add(btnFwd);
		
		JPanel answerPanel = new JPanel();
		answerPanel.setBackground(Color.WHITE);
		controlPanel.add(answerPanel);
		
		answer = new JTextField();
		answer.setBorder(null);
		answerPanel.add(answer);
		answer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		answer.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		answer.setText("Answer");
		answer.setColumns(21);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		controlPanel.add(btnSubmit);
		btnSubmit.setHorizontalAlignment(SwingConstants.RIGHT);
	}

}
