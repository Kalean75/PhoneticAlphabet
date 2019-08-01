package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class QuizUserInterface  extends JFrame implements UserInterface{

	private SelectQuizPanel sqPanel;
	private CustomQuizPanel cqPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuizUserInterface frame = new QuizUserInterface();
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
	public QuizUserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		sqPanel = new SelectQuizPanel();
		cqPanel = new CustomQuizPanel();
		setContentPane(sqPanel);
	}

	@Override
	public void selectQuizPanel() {
		setContentPane(sqPanel);
	}

	@Override
	public void customQuizPanel() {
		setContentPane(cqPanel);
	}

	@Override
	public void mainMenuPanel() {
		// TODO Auto-generated method stub
		UserInterface.super.mainMenuPanel();
	}

	@Override
	public void quizPanel() {
		// TODO Auto-generated method stub
		UserInterface.super.quizPanel();
	}

	@Override
	public void studyPanel() {
		// TODO Auto-generated method stub
		UserInterface.super.studyPanel();
	}

	@Override
	public void resultPanel() {
		// TODO Auto-generated method stub
		UserInterface.super.resultPanel();
	}

}
