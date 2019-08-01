package quiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import ui.UserInterface;

public class QuizController {

	UserInterface ui; // view
	Quiz quiz; // model

	public QuizController(UserInterface ui) {
		this.ui = ui;
	}

	/*********************************************************************/

	/**
	 * Listener will set the quiz to the phonetic alphabet quiz
	 */
	class SelectQuizListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				quiz = new Quiz();
				ui.selectQuizPanel();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	/**
	 * Listener will switch the ui to customQuizPanel
	 */
	class CustomQuizListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ui.customQuizPanel();
		}
		
	}
	
	
	class NextListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

}
