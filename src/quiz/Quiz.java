package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * QuestionList is a class that extends ArrayList. It was created so that many
 * Questions/Answers could be imported from 2 different files
 * 
 * @author Devin White
 *
 */
@SuppressWarnings("serial")
public class Quiz extends ArrayList<Question> {
	
	private ArrayList<Question> incorrectQuestions; //A list of incorrect questions
	private int incorrect;							//Number of incorrect answers
	private Result result;							//Results post quiz
	public Iterator iter;							//Allows traversal of questions
	private Scanner reader;
	private List<String> Results = new ArrayList<>();
	/**
	 * Constructs a Quiz with questions from the phonetic alphabet
	 * 
	 * @throws FileNotFoundException
	 * @throws QuizException 
	 */
	public Quiz() throws FileNotFoundException, QuizException 
	{
		this("./src/files/PhoneticQuestions.txt", "./src/files/PhoneticAnswers.txt");
		
	}

	/**
	 * Constructs a QuestionList with 2 txt files with each question and answer per
	 * line. There must be the same amount of lines in both files
	 * 
	 * @param questionPath
	 * @param answerPath
	 * @throws QuizException
	 * @throws FileNotFoundException
	 */
	public Quiz(String questionPath, String answerPath) throws FileNotFoundException, QuizException {
		ArrayList<String> question = fileToArray(questionPath);
		ArrayList<String> answer = fileToArray(answerPath);

		if (question.size() == answer.size()) {
			for (int i = 0; i < question.size(); i++) {
				this.add(new Question(question.get(i), answer.get(i)));
			}
		} else {
			throw new QuizException("The question file and answer file do not have the same number of lines");
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

	public String getAnswer(int i) {
		return this.get(i).getAnswer();
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
	 * @throws IOException 
	 */
	public void setResult() throws IOException {
		result = new Result(this.size(), incorrect, incorrectQuestions);
		FileWriter writer = new FileWriter("./src/files/Results.txt");
		Results.add(result.toString());
		if(Results.size() > 5) {
			Results.remove(0);
		}
		for(String str: Results) {
			  writer.write(str);
			  writer.write("\n");
			}
		writer.close();
		incorrect = 0;
	}
	
	public String getResult() {
		return result.toString();
	}

	public static String getLast5() throws FileNotFoundException {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(new File("./src/files/Results.txt"));
		String last5;
		for(int i = 0; i < 5; i++){
			if (sc.hasNextLine()){
				sb.append(sc.nextLine());
				sb.append(System.getProperty("line.separator"));
			}
		}
		return sb.toString();
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
