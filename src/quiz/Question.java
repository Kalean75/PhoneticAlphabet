package quiz;

/**
 * The Question class is a a question object that has a String question and
 * String answer. It is pretty much a key value pair with both the Key and Value
 * being Strings
 * 
 * @author Devin White
 *
 */
public class Question {

	private String question;
	private String answer;

	/**
	 * Constructor that needs a question value and answer
	 * @param question
	 * @param answer
	 */
	public Question(String question, String answer) 
	{
		this.question = question;
		this.answer = answer;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}
	
	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Checks to see if a given answer is correct
	 * @param a answer attempt
	 * @return boolean
	 */
	public boolean answer(String a) {
		if (a.equalsIgnoreCase(answer)) {
			return true;
		}
		else {
			return false;
		}
	}

}
