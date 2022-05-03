/**
 * Defines a TrueFalse object that extends the Question class
 * 
 * @author Mason Fields
 * @version 1.0
 */
public class TrueFalse extends Question {

	/**
	 * Constructs a TrueFalse object with a specified question and answer
	 * 
	 * @param question the question on the quiz
	 * @param answer   the answer to the question
	 */
	public TrueFalse(String question, String answer) {
		super(question);
		setAnswer(answer.strip().toLowerCase());
	}

	/**
	 * Returns whether the user specified answer is correct or not
	 * 
	 * @param userAnswer the answer specified by the user
	 * @return whether or not the user answer is correct
	 */
	public boolean isCorrect(String userAnswer) {
		userAnswer = userAnswer.strip().toLowerCase();
		return userAnswer.equals(this.getAnswer());
	}
}
