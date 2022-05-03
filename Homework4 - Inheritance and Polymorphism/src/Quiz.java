import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Implements the Question class and it's child classes to create a quiz that
 * users can interact with
 * 
 * @author Mason Fields
 * @version 1.0
 */
public class Quiz {
	public static ArrayList<Question> questions = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		do {
			try {
				System.out.print("Which quiz are you taking? ");
				Scanner input = new Scanner(System.in);
				String file = input.next();
				System.out.println();
				createQuiz(file);
				input.close();
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Not a valid file name. Please try again.\n");
			}
		} while (true);
	}

	private static void createQuiz(String file) throws FileNotFoundException {
		Scanner reader = new Scanner(new File(file));
		ArrayList<String> answers = new ArrayList<>();
		String question = "";
		do {
			String next = reader.nextLine();
			if (next.equals("S")) {
				questions.add(new ShortTextResponse(reader.nextLine(), reader.nextLine()));
			} else if (next.equals("T")) {
				questions.add(new TrueFalse(reader.nextLine(), reader.nextLine()));
			} else if (next.equals("N")) {
				questions.add(new NumericResponse(reader.nextLine(), reader.nextDouble()));
				reader.nextLine();
			} else if (next.equals("M1")) {
				question = reader.nextLine();
				answers = new ArrayList<>();
				do {
					String option = reader.nextLine();
					if (option.length() != 0) {
						if (!option.substring(0, 1).equals("+") && !option.substring(0, 1).equals("-")) {
							break;
						}
					} else {
						break;
					}
					answers.add(option);
				} while (reader.hasNextLine());
				questions.add(new MultipleChoice1Ans(question, answers));
			} else if (next.equals("MM")) {
				question = reader.nextLine();
				answers = new ArrayList<>();
				do {
					String option = reader.nextLine();
					if (option.length() != 0) {
						if (option.substring(0, 1).equals("+") || option.substring(0, 1).equals("-")) {
							answers.add(option);
						} else {
							break;
						}
					} else {
						break;
					}
				} while (reader.hasNextLine());
				questions.add(new MultipleChoiceMultiAns(question, answers));
			}
		} while (reader.hasNextLine());
		reader.close();
		giveQuiz(questions);
	}

	public static void giveQuiz(ArrayList<Question> questions) {
		Collections.shuffle(questions);
		int questNum = 0;
		int correctCount = 0;
		Scanner sc = new Scanner(System.in);
		for (Question q : questions) {
			questNum++;
			System.out.print(questNum + ". " + q + "\nYour answer: ");
			String userAnswer = sc.nextLine();
			if (q.isCorrect(userAnswer)) {
				System.out.println("Correct.");
				correctCount++;
			} else {
				System.out.println("Incorrect.");
			}
			System.out.println();
		}
		sc.close();
		System.out.println(String.format("You got %d of %d questions correct for a final percentage of %.1f%%",
				correctCount, questNum, ((float) correctCount / (float) questNum) * 100));

	}
}
