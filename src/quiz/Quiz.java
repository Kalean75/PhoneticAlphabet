package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * QuestionList is a class that extends ArrayList. It was created so that many
 * Questions/Answers could be imported from 2 different files
 * 
 * @author Jeremy
 *
 */
@SuppressWarnings("serial")
public class Quiz extends ArrayList<Question> {
	
	private String quizName;						//Name of quiz
	private ArrayList<Question> incorrectQuestions; //A list of incorrect questions
	private int incorrect;							//Number of incorrect answers
	private Result result;							//Results post quiz
	private Iterator iter;							//Allows traversal of questions

	/**
	 * Constructs a Quiz with questions from the phonetic alphabet
	 * 
	 * @throws FileNotFoundException
	 */
	public Quiz() throws FileNotFoundException {
		this("src/files/PhoneticQuestions.txt", "src/files/PhoneticAnswers.txt");
		iter = this.iterator();
	}

	/**
	 * Constructs a QuestionList with 2 txt files with each question and answer per
	 * line. There must be the same amount of lines in both files
	 * 
	 * @param questionPath
	 * @param answerPath
	 */
	public Quiz(String questionPath, String answerPath) throws FileNotFoundException {
		ArrayList<String> question = fileToArray(questionPath);
		ArrayList<String> answer = fileToArray(answerPath);

		if (question.size() == answer.size()) {
			for (int i = 0; i < question.size(); i++) {
				this.add(new Question(question.get(i), answer.get(i)));
			}
		} else {
			throw new IndexOutOfBoundsException("The question file and answer file do not have the same number of lines");
		}
	}

	/**
	 * Asks a question from the quiz
	 * @param i
	 * @return String
	 */
	public String getQuestion(int i) {		
		return this.get(i).getQuestion();
	}
	
	/**
	 * Answers a question from the quiz
	 * @param i
	 * @param answer
	 * @return boolean
	 */
	public boolean answerQuestion(int i,String answer) {
		if(!this.get(i).answer(answer)) {
			incorrect++;
		}
		return this.get(i).answer(answer);
	}
	
	/**
	 * Sets result; score, and list of incorrect questions
	 */
	public void setResult() {
		result = new Result(this.size(),incorrect,incorrectQuestions);
	}
		
	
	/**
	 * Creates an ArrayList with each line from a filepath
	 * 
	 * @param filepath
	 * @return
	 * @throws FileNotFoundException
	 */
	private ArrayList<String> fileToArray(String filepath) throws FileNotFoundException {

		ArrayList<String> list = new ArrayList<>();

		Scanner sc = new Scanner(new File(filepath));

		while (sc.hasNextLine()) {
			list.add(sc.nextLine());
		}
		return list;

	}

	
}
