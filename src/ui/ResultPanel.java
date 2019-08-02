package ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultPanel extends JPanel {

	protected JButton btnMenu;
	protected JButton btnRetake;
	/**
	 * Create the panel.
	 */
	public ResultPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("Results");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		add(lblTitle, BorderLayout.NORTH);
		
		JLabel lblResults = new JLabel("Results");
		lblResults.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblResults.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblResults, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel();
		add(controlPanel, BorderLayout.SOUTH);
		
		JButton btnMenu = new JButton("Main menu");
		controlPanel.add(btnMenu);
		
		JButton btnRetake = new JButton("Take Again");
		controlPanel.add(btnRetake);

	}

}
