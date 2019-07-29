package quiz;

/**
 * 
 * @author Devin White
 *
 */
public class Result {
	
	int totalQuestions;
	int incorrect;
	//Time time;
	//QuestionList wrongQList;
	
	public Result(int totalQuestions, int incorrect) {
		
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
