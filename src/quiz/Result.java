package quiz;

import java.util.ArrayList;

/**
 * 
 * @author Devin White
 *
 */
public class Result {
	
	int totalQuestions;
	int incorrect;
	ArrayList<Question> incorrectQuestions;
	//Time time;
	//QuestionList wrongQList;
	
	public Result(int totalQuestions, int incorrect, ArrayList<Question> incorrectQuestions) {
		
		this.incorrectQuestions = incorrectQuestions;
		this.totalQuestions = totalQuestions;
		this.incorrect = incorrect;
		
	}
	
	//TODO
	public void writeToFile() {
		
	}
	
	@Override
	public String toString() {
		return String.format("%d/%d correct", (totalQuestions - incorrect), totalQuestions);
	}

}
