package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quiz.Question;
import quiz.Quiz;
import quiz.QuizException;
import quiz.Result;

import javax.swing.JLayeredPane;

public class QuizUserInterface extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private Quiz quiz;
	private SelectQuizPanel sqPanel;
	private CustomQuizPanel cqPanel;
	private MainMenuPanel mmPanel;
	private QuizPanel quizPanel;
	private ResultPanel resultPanel;
	private StudyPanel studyPanel;
	
	private int quizIndex;
	private int maxIndex;
	//private StudyPanel sPanel;
	
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
		
		instansiateFields();
		setUp();
	}

	/*
	 * SetUpJframe
	 */
	private void setUp() {
		// setup Jframe and content pane
		setTitle("Quiz\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 414, 239);

		contentPane.add(layeredPane);
		setContentPane(contentPane);
		switchPanel(sqPanel);
		
		setUpButtons();

	}

	/**
	 * instantiates fields
	 */
	private void instansiateFields() {
		sqPanel = new SelectQuizPanel();
		cqPanel = new CustomQuizPanel();
		mmPanel = new MainMenuPanel();
		quizPanel = new QuizPanel();
		studyPanel = new StudyPanel();
		resultPanel = new ResultPanel();
	}
	/**
	 * Switch to different panel
	 * @param panel
	 */
	private void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	//Iteration Methods =========================================================================
	/**
	 * index has next
	 * @return boolean
	 */
	private boolean hasNextIndex() {
		return (quizIndex < maxIndex && quizIndex != -1); 
	}
	
	/**
	 * index has previous
	 * @return boolean
	 */
	private boolean hasPreviousIndex() {
		return (quizIndex > 0);
	}
	
	/**
	 * increases quizIndex if not max index. sets quizIndex to -1 if max index
	 * @return int
	 */
	private int nextIndex() {
		if(hasNextIndex()) {
			return ++quizIndex;
		}
		return -1;
	}
	
	/**
	 * decreases quizIndex if greater than zero. sets quizIndex to -1 if 0
	 * @return int
	 */
	private int lastIndex() {
		if(hasPreviousIndex()) {
			return --quizIndex;
		}
		return -1;
	}

	//Add actionListeners to stuff===================================================================
	/**
	 * Add action listeners to buttons
	 */
	private void setUpButtons() {
		
		//sqPanel Buttons==================================
		sqPanel.btnNato.addActionListener(e -> {
			try {
				quiz = new Quiz();					//create nato quiz
				maxIndex = quiz.size() - 1;			//set max index for quizIndex
				setTitle("Quiz: Nato Alphabet");	//set title of app
				switchPanel(mmPanel);				//switch panel
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (QuizException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});
		
		sqPanel.btnCustom.addActionListener(e -> {
			switchPanel(cqPanel);
		});
		
		//cqPanelButtons====================================
		cqPanel.btnBack.addActionListener(e -> {
			switchPanel(sqPanel);
		});
		
		cqPanel.btnSubmit.addActionListener(e -> {
			try {
				quiz = new Quiz(cqPanel.txtQuestionpath.getText().trim(),
						cqPanel.txtAnswerpath.getText().trim()); 	//create quiz with files
				maxIndex = quiz.size() - 1;							//set max index for quizIndex
				setTitle("Quiz: Custom");							//set title of app
				switchPanel(mmPanel);								//switch to mmPanel
			} catch (FileNotFoundException e1) {
				//TODO print to status
				System.out.println(e1.getMessage());
			} catch (QuizException e2) {
				// TODO
				e2.printStackTrace();
			}
		});
		
		//mmPanelButton=======================================
		mmPanel.btnQuiz.addActionListener(e -> {
			switchPanel(quizPanel);				//switch panel
		});
		
		mmPanel.btnStudy.addActionListener(e -> {
			maxIndex = quiz.size() - 1;	
			quizIndex = 0;
			switchPanel(studyPanel);
			studyPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));
			studyPanel.btnQues.setEnabled(false);
			studyPanel.btnBack.setEnabled(false);
			studyPanel.btnFwd.setEnabled(true);
		});
		
		//quizPanel===========================================
		quizPanel.btnStart.addActionListener(e -> {
			quizPanel.controlPanel.removeAll();									//remove start button
			quizPanel.controlPanel.add(quizPanel.answerField);					//add answerField
			quizPanel.answerField.requestFocus();								//request focus so user doesn't have to click on textfield to type
			quizIndex = 0;
			quizPanel.lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 30));		//index of first object
			quizPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));		//gets the first question
			quizPanel.repaint();
		});
		
		quizPanel.answerField.addActionListener(e -> {
			quiz.answerQuestion(quizIndex, quizPanel.answerField.getText());	//answer current question
			
			if(hasNextIndex()) {	
				quizPanel.answerField.setText("");									//set answerField to blank
				quizPanel.lblQuestion.setText(quiz.getQuestion(nextIndex()));		//get next question
				quizPanel.repaint();												//repaint panel
			}
			else {
				try {
					quiz.setResult();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				resultPanel.textResults.setText(quiz.getResult());
				switchPanel(resultPanel);
				resultPanel.btnLast5.setVisible(true);
				resultPanel.btnLatest.setVisible(false);
			}
		});
		
		//StudyPanel===========================================
		studyPanel.btnFwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				quiz.getQuestion(nextIndex());
				studyPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));
				studyPanel.btnAns.setEnabled(true);
				studyPanel.btnQues.setEnabled(false);
				
				if(quizIndex == maxIndex - 1) {
					studyPanel.btnFwd.setEnabled(false);
				}
				if(hasPreviousIndex())
				{
					studyPanel.btnBack.setEnabled(true);
				}
				
			}
		});
		
		studyPanel.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quiz.getQuestion(lastIndex());
				studyPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));
				studyPanel.btnAns.setEnabled(true);
				studyPanel.btnQues.setEnabled(false);
				
				if(!hasPreviousIndex())
				{
					studyPanel.btnBack.setEnabled(false);
				}
				if(hasNextIndex()) {
					studyPanel.btnFwd.setEnabled(true);
				}
				
			}
		});
		
		studyPanel.btnQuiz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(quizPanel);		
			}
		});
		
		studyPanel.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyPanel.btnFwd.setEnabled(true);
				studyPanel.btnBack.setEnabled(true);
				switchPanel(sqPanel);
			}
		});
		
		studyPanel.btnQues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyPanel.btnAns.setEnabled(true);
				studyPanel.btnQues.setEnabled(false);
				studyPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));
			}
		});
		
		studyPanel.btnAns.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyPanel.btnQues.setEnabled(true);
				studyPanel.btnAns.setEnabled(false);
				studyPanel.lblQuestion.setText(quiz.getAnswer(quizIndex));
			}
		});
		
		//resultsPanel===========================================
		
		resultPanel.btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizIndex = 0;
				quizPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));	
				switchPanel(mmPanel);
			}
		});
		
		resultPanel.btnRetake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quizIndex = 0;
				quizPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));
				resultPanel.btnLatest.setVisible(true);
				switchPanel(quizPanel);
				quizPanel.answerField.setText("");
			}
		});
		
		resultPanel.btnLast5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPanel.btnLatest.setVisible(true);
				resultPanel.btnLast5.setVisible(false);
				try {
					resultPanel.textResults.setText(quiz.getLast5());
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
			}
		});
		
		resultPanel.btnLatest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resultPanel.btnLast5.setVisible(true);
				resultPanel.btnLatest.setVisible(false);
				resultPanel.textResults.setText(quiz.getResult());

			}
		});
	}

}
