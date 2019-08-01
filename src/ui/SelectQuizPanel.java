package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import quiz.Quiz;

import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * First Panel that asks user to selct a quiz
 * @author jerem
 *
 */
@SuppressWarnings("serial")
public class SelectQuizPanel extends JPanel {

	protected JButton btnNato;
	protected JButton btnCustom;


	/**
	 * Create the panel.
	 */
	public SelectQuizPanel() {
		setBorder(new EmptyBorder(5, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 414, 228);
		JLabel lblTitle = new JLabel("Select Quiz");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblTitle, BorderLayout.NORTH);
		JPanel buttonPanel = createButtonPanel();
		add(buttonPanel, BorderLayout.SOUTH);

	}

	/**
	 * Creates button panel
	 * @return
	 */
	private JPanel createButtonPanel() {
		JPanel controlPanel = new JPanel();
			
		createNatoBtn();
		createCustomBtn();
		
		controlPanel.add(btnNato);
		controlPanel.add(btnCustom);
		return controlPanel;
	}
	
	/**
	 * Create btnNato
	 */
	private void createNatoBtn() {
		btnNato = new JButton("NATO Alphabet");
		btnNato.setPreferredSize(new Dimension(120, 23));
	}
	
	/**
	 * Create btnCustom
	 */
	private void createCustomBtn() {
		btnCustom = new JButton("Custom Quiz");
		btnCustom.setPreferredSize(new Dimension(120, 23));
	}

}
