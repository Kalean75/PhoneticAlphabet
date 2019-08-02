package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import quiz.Question;
import quiz.Quiz;
import quiz.QuizException;

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
	 * instansites fields
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
			switchPanel(studyPanel);
			studyPanel.btnBack.setVisible(false);
			maxIndex = quiz.size() - 1;	
			quizIndex = 0;
			studyPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));
		});
		
		//quizPanel===========================================
		quizPanel.btnStart.addActionListener(e -> {
			quizPanel.controlPanel.removeAll();									//remove start button
			quizPanel.controlPanel.add(quizPanel.answerField);					//add answerField
			quizPanel.answerField.requestFocus();								//request focus so user doesn't have to click on textfield to type
			quizIndex = 0;														//index of first object
			quizPanel.lblQuestion.setText(quiz.getQuestion(quizIndex));			//gets the first question
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
				quizPanel.answerField.setText("this is when the result panel would show");	//remove this once switchPanel is implemented
				quizPanel.repaint();
				switchPanel(resultPanel);
			}
		});
		
		//StudyPanel===========================================
		studyPanel.btnFwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(quizIndex == maxIndex - 1) {
					studyPanel.btnFwd.setVisible(false);
				}
				
				studyPanel.lblQuestion.setText(quiz.getQuestion(nextIndex()));
				
				if(hasPreviousIndex())
				{
					studyPanel.btnBack.setVisible(true);
				}
				
				
				//TODO: figure out how to cycle through Answers
			}
		});
		
		studyPanel.btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studyPanel.lblQuestion.setText(quiz.getQuestion(lastIndex()));
				if(!hasPreviousIndex())
				{
					studyPanel.btnBack.setVisible(false);
				}
				
				if(hasNextIndex()) {
					studyPanel.btnFwd.setVisible(true);
				}
				
				//TODO: figure out how to cycle through answers
			}
		});
		
		//resultsPanel===========================================
		//TODO: implement reult actions
		/*resultPanel.btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		resultPanel.btnRetake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
	}

}
