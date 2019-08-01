package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;

/**
 * First Panel that asks user to selct a quiz
 * @author jerem
 *
 */
@SuppressWarnings("serial")
public class SelectQuizPanel extends JPanel {

	public JButton btnNato;
	public JButton btnCustom;

	/**
	 * Create the panel.
	 */
	public SelectQuizPanel() {
		setBorder(new EmptyBorder(20, 0, 0, 0));
		setLayout(new BorderLayout(0, 0));
		
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
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(new EmptyBorder(0, 0, 10, 0));

		
		createNatoBtn();
		createCustomBtn();
		
		buttonPanel.add(btnNato);
		buttonPanel.add(btnCustom);
		return buttonPanel;
	}
	
	/**
	 * Instansiates btnNato
	 */
	private void createNatoBtn() {
		btnNato = new JButton("NATO Alphabet");
		btnNato.setPreferredSize(new Dimension(120, 23));
	}
	
	/**
	 * Instansiates btnCustom
	 */
	private void createCustomBtn() {
		btnCustom = new JButton("Custom Quiz");
		btnCustom.setPreferredSize(new Dimension(120, 23));
	}

}
