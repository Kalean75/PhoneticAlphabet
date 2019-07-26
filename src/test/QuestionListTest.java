package test;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import quiz.Question;
import quiz.QuestionList;

class QuestionListTest {

	@Test
	void testQuestionList() {
		QuestionList qList = new QuestionList("src/files/PhoneticQuestions.txt", "src/files/PhoneticAnswers.txt");
		Question q1 = new Question("B", "Bravo");
		assertTrue("Testing Constructor",qList.get(1).equals(q1));

	}

	@Test
	void testQuestionListException() {
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			QuestionList qList = new QuestionList("src/files/PhoneticQuestionsEXTRALINE.txt", "src/files/PhoneticAnswers.txt");
		});
	}
}
