package quiz;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Devin White
 *
 */
public class Result {
	int totalQuestions;
	int incorrect;
	private Quiz quiz;
	ArrayList<Question> incorrectQuestions;
	//Time time;
	//QuestionList wrongQList;
	
	public Result(int totalQuestions, int incorrect, ArrayList<Question> incorrectQuestions) {
		
		this.incorrectQuestions = incorrectQuestions;
		this.totalQuestions = totalQuestions;
		this.incorrect = incorrect;
		
	}

	//TODO
	public void writeToFile() throws IOException 
	{
		//TODO: fill in 
	}
	
	@Override
	public String toString() {
		return String.format("%d/%d correct", (totalQuestions - incorrect), totalQuestions);
	}

}
