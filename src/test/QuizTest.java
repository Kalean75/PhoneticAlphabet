package test;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import quiz.Question;
import quiz.Quiz;
import quiz.QuizException;
/**
 * 
 * @author Devin White
 *
 */
class QuestionListTest {

	@Test
	void testQuestionList() {
		Quiz quiz = null;
		try {
			quiz = new Quiz("src/files/PhoneticQuestions.txt", "src/files/PhoneticAnswers.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QuizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Question q1 = new Question("B", "Bravo");
		assertTrue("Testing Constructor",quiz.get(1).equals(q1));

	}

	@Test
	void testQuestionListException() {
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			Quiz quiz = new Quiz("src/files/PhoneticQuestionsEXTRALINE.txt", "src/files/PhoneticAnswers.txt");
		});
	}
}
