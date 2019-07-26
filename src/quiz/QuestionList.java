package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * QuestionList is a class that extends ArrayList. It was created so that many
 * Questions/Answers could be imported from 2 different files
 * 
 * @author Jeremy
 *
 */
@SuppressWarnings("serial")
public class QuestionList extends ArrayList<Question> {

	/**
	 * Constructs a QuestionList with 2 txt files with each question and answer per
	 * line. There must be the same amount of lines in both files
	 * 
	 * @param questionPath
	 * @param answerPath
	 */
	public QuestionList(String questionPath, String answerPath) {
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
	 * Creates an ArrayList with each line from a filepath
	 * 
	 * @param filepath
	 * @return
	 */
	private ArrayList<String> fileToArray(String filepath) {

		ArrayList<String> list = new ArrayList<>();

		try {
			Scanner sc = new Scanner(new File(filepath));

			while (sc.hasNextLine()) {
				list.add(sc.nextLine());
			}

		} catch (FileNotFoundException e) {
			System.out.println("WARNING: File not found.");
		}
		return list;

	}

}
