import java.util.ArrayList;
import java.util.Collections;

/**
 * Defines a multiple choice question with one potential answer. The
 * MultipleChoice1Ans extends the Question class
 * 
 * @author Mason Fields
 * @version 1.0
 */
public class MultipleChoice1Ans extends Question {
	private ArrayList<String> answers;
	
	/**
	 * Constructs a MultipleChoice1Ans objects with a specified question and answer.
	 * It also stores the answer options in an ArrayList
	 * 
	 * @param question the question on the quiz
	 * @param answers  answer options
	 * @param answer   the correct answer to the question
	 */
	public MultipleChoice1Ans(String question, ArrayList<String> answers) {
		super(question);
		this.answers = answers;
		Collections.shuffle(this.answers);
		String ans = "";
		char letter = 'A';
		for (String s : answers) {
			if (s.substring(0, 1).equals("+")) {
				ans = letter + "";
			}
			letter++;
		}
		setAnswer(ans.strip().toUpperCase());
		ArrayList<String> temp = new ArrayList<>();
		for (String s : this.answers) {
			temp.add(s.substring(1));
		}
		this.answers = temp;
	}
	
	/**
	 * Returns the question and answer options for the question
	 * 
	 * @return the question and answer options
	 * 
	 */
	@Override
	public String toString() {
		String output = super.toString();
		char letter = 'A';
		for (String string : answers) {
			output += String.format("\n   %s. %s", letter, string);
			letter += 1;
		}
		return output;
	}

	/**
	 * Returns whether the user specified answer is correct or not
	 * 
	 * @param userAnswer the answer specified by the user
	 * @return whether or not the user answer is correct
	 */
	public boolean isCorrect(String userAnswer) {
		userAnswer = userAnswer.toUpperCase();
		return getAnswer().equals(userAnswer.strip());
	}
}
