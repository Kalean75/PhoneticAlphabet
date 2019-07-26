package quiz;


import java.time.Duration;
import java.util.Iterator;
import java.util.Scanner;

public class Quiz {
	
	//private Duration time;			//Timer for the quiz
	private QuestionList qList;			//Question List of all questions
	//private QuestionList qListWrong;	//Question List of missed questions
	private int incorrect;				//Count of Incorrect questions
	private Scanner sc = new Scanner(System.in);
	
	public Quiz(QuestionList qList) {
		
		this.qList = qList;

		incorrect = 0;
	}
	
	public void startQuiz() {
		for(Question q: qList) {
			System.out.printf("\n%s: ",q.getQuestion());
			if (!(q.answer(sc.next()))){
				incorrect++;
			}
		}
		System.out.printf("You got %d/%d correct", qList.size() - incorrect, qList.size());
	}
	
	public static void main(String[] args) {
		QuestionList qList = new QuestionList("src/files/PhoneticQuestions.txt", "src/files/PhoneticAnswers.txt");
		Quiz q1 = new Quiz(qList);
		q1.startQuiz();
	}

}
