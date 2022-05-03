import java.util.ArrayList;
import java.util.Collections;

/**
 * Defines a multiple choice question with multiple correct answers. The
 * MultipleChoiceMultiAns class extends the Question class
 * 
 * @author Mason Fields
 * @version 1.0
 *
 */
public class MultipleChoiceMultiAns extends Question {
	private ArrayList<String> answers;
	private ArrayList<String> correctAnswers;

	/**
	 * Defines a MultipleChoiceMultiAns object with a specified question. It also
	 * stores an ArrayList of all answer options and an ArrayList of the correct
	 * answers
	 * 
	 * @param question       the question on the quiz
	 * @param answers        the answer options to the question
	 * @param correctAnswers the correct answers
	 */
	public MultipleChoiceMultiAns(String question, ArrayList<String> answers) {
		super(question);
		this.answers = answers;
		Collections.shuffle(this.answers);
		this.correctAnswers = new ArrayList<>();
		char letter = 'A';
		for (String ans : answers) {
			if (ans.substring(0, 1).equals("+")) {
				correctAnswers.add(letter + "");
			}
			letter++;
		}
		ArrayList<String> temp = new ArrayList<>();
		for (String ans : this.answers) {
			temp.add(ans.substring(1));
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
		for (String option : answers) {
			output += String.format("\n   %s. %s", letter, option);
			letter++;
		}
		return output;
	}

	/**
	 * Returns the answer of this MultipleChoiceMultiAns object
	 * 
	 * @return the answer
	 */
	@Override
	public String getAnswer() {
		String output = "";
		for (String s : correctAnswers) {
			output += s.strip().toUpperCase();
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
		String finalUserAnswer = "";
		for (int i = 0; i < userAnswer.length(); i++) {
			if (!userAnswer.substring(i, i + 1).equals(" ")) {
				finalUserAnswer += userAnswer.substring(i, i + 1).toUpperCase();
			}
		}
		return getAnswer().equals(finalUserAnswer.strip());
	}
}
