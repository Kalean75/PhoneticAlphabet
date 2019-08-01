package ui;

public interface UserInterface {
	
	/**
	 * Initial menu that asks which quiz to do
	 */
	public default void selectQuizPanel() {
	}
	
	/**
	 * Panel that allows user to input filepaths for custom quiz
	 */
	public default void customQuizPanel() {
	}
	
	/**
	 * Panel that allows users to take quiz, practice, or look at previous results
	 */
	public default void mainMenuPanel() {		
	}
	
	/**
	 * Panel where the quiz is taken
	 */
	public default void quizPanel() {
	}
	
	/**
	 * Panel where user can review questions and answers
	 */
	public default void studyPanel() {
		
	}
	
	/**
	 * Panel where quiz results are displayed
	 */
	public default void resultPanel() {
		
	}
	
	

}
