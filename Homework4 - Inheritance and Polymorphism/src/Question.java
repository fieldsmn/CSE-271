/**
 * Defines a simple Question object that stores a question and determines if a
 * given answer is correct. This is an abstract class meant to define parameters
 * for child classes.
 * 
 * @author Mason Fields
 * @version 1.0
 */
public abstract class Question {
	private String question;
	private String answer;

	/**
	 * Constructs a Question with a specified question. The answer is set later
	 * within a child class
	 * 
	 * @param question the question on the quiz
	 */
	public Question(String question) {
		this.question = question;
	}

	/**
	 * Returns the answer of this Question object
	 * 
	 * @return the answer
	 */
	public String getAnswer() {
		return this.answer;
	}

	/**
	 * Sets the answer of this Question object
	 * 
	 * @param answer the user specified answer
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	//TODO ask about javadoc for abstract methods
	public abstract boolean isCorrect(String userAnswer);
	
	/**
	 * Returns the question of this Question object
	 * 
	 * @return the question
	 */
	@Override
	public String toString() {
		return this.question;
	}

}
