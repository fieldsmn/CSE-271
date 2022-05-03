/**
 * Defines a NumericResponse object that extends the Question class
 * 
 * @author Mason Fields
 * @version 1.0
 */
public class NumericResponse extends Question {

	/**
	 * Constructs a NumericResponse object with a specified question and answer
	 * 
	 * @param question the question on the quiz
	 * @param answer   the answer to the question
	 */
	public NumericResponse(String question, double answer) {
		super(question);
		setAnswer(answer + "");
	}

	/**
	 * Returns whether the user specified answer is correct or not
	 * 
	 * @param userAnswer the answer specified by the user
	 * @return whether or not the user answer is correct
	 */
	public boolean isCorrect(String userAnswer) {
		double numAnswer = Double.parseDouble(getAnswer());
		double userNumAnswer = 0;
		try {
			userNumAnswer = Double.parseDouble(userAnswer);
		} catch (NumberFormatException e) {
			return false;
		}
		return (numAnswer - 0.01) <= userNumAnswer && userNumAnswer <= (numAnswer + 0.01);
	}

}
