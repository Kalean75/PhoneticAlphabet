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
	private JTextField txtAnswer;

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
		contentPane.setBorder(new LineBorder(Color.BLUE, 4, true));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Question");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JButton btnBack = new JButton("<=");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBack.setActionCommand("<=");
		panel_1.add(btnBack);
		
		JButton btnFwd = new JButton("=>");
		btnFwd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFwd.setActionCommand("=>");
		panel_1.add(btnFwd);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2);
		
		txtAnswer = new JTextField();
		panel_2.add(txtAnswer);
		txtAnswer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAnswer.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		txtAnswer.setHorizontalAlignment(SwingConstants.LEFT);
		txtAnswer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		txtAnswer.setText("Answer");
		txtAnswer.setColumns(17);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnSubmit);
		btnSubmit.setHorizontalAlignment(SwingConstants.RIGHT);
	}

}
