package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.GridLayout;

public class ResultPanel extends JPanel {

	protected JButton btnMainMenu;
	protected JButton btnRetake;
	protected JButton btnLatest;
	protected JButton btnLast5;
	protected JTextPane textResults;
	protected JLabel lblTitle;
	protected JPanel controlPanel;
	protected JPanel panel;
	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setLayout(new BorderLayout(0, 0));
		setBounds(0, 0, 414, 228);
		
		lblTitle = new JLabel("Results");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblTitle, BorderLayout.NORTH);
		
		textResults = new JTextPane();
		textResults.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textResults.setText("Results");
		textResults.setEditable(false);
		add(textResults, BorderLayout.CENTER);
		
		controlPanel = new JPanel();
		add(controlPanel, BorderLayout.SOUTH);
		
		btnMainMenu = new JButton("Main menu");
		btnMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		controlPanel.add(btnMainMenu);
		
		btnRetake = new JButton("Take Again");
		btnRetake.setFont(new Font("Tahoma", Font.PLAIN, 12));
		controlPanel.add(btnRetake);
		
		btnLast5= new JButton("Last 5 Results");
		controlPanel.add(btnLast5);
		btnLast5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnLatest= new JButton("Latest Result");
		controlPanel.add(btnLatest);
		btnLatest.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		panel = new JPanel();
		add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

	}

}
