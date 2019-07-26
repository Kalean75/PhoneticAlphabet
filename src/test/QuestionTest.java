package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import quiz.Question;

class QuestionTest {

	@Test
	void testAnswer1() {
		Question q1 = new Question("A","Alpha");
		assertTrue("Testing answer()",q1.answer("alpha"));
	}
	
	@Test
	void testAnswer2() {
		Question q1 = new Question("A","Alpha");
		assertFalse("Testing answer()",q1.answer("alphaa"));
	}

}
