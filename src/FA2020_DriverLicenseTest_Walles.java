import java.util.*;

//FA2020_DriverLicenseTest_Walles.java
public class FA2020_DriverLicenseTest_Walles {
	public static char[] keyset = { 'A', 'C', 'B', 'B', 'D', 'B', 'C', 'D', 'A', 'B', 'C', 'A', 'B', 'C', 'A', 'B', 'A',
			'C', 'A', 'D', 'B', 'C', 'A', 'D', 'B' };
	public static char[] answerArray = new char[25];
	private static Scanner input = new Scanner(System.in);
	private static CandidateDriver_Walles dataClassObj = new CandidateDriver_Walles();

	// collects user info, accepts test input, compares user answers with test key,
	// prints results
	public static void main(String[] args) {
		CandidateDriver_Walles.userInfo();
		testInput();
		answerCheck(answerArray, keyset);
		System.out.println(getResults());
	}

	// allows user input for test
	public static char[] testInput() {
		System.out.println("DRIVER LICENSE TEST");
		System.out.println("THERE ARE 25 MULTIPLE CHOICE QUESTIONS");
		System.out.println("YOU HAVE TO GET AT LEAST 20 CORRECT ANSWERS TO PASS");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Enter A, B, C, or D for each question");
		int i = 0;
		while (i < 25) {
			System.out.println("Question: " + (i + 1));
			answerArray[i] = input.next().charAt(0);
			if (answerArray[i] == 'A' || answerArray[i] == 'B' || answerArray[i] == 'C' || answerArray[i] == 'D'
					|| answerArray[i] == 'a' || answerArray[i] == 'b' || answerArray[i] == 'c'
					|| answerArray[i] == 'd') {
				i++;
			} else {
				System.out.println("Invalid key – Retype");
			}
		}
		input.close();
		return answerArray;
	}

	// checks user answers against test key array
	public static void answerCheck(char[] answerArray, char[] keyset) {
		CandidateDriver_Walles.evaluateResult(answerArray, keyset);
	}

	// get methods
	public char[] getAnswerArray() {
		return answerArray;
	}

	public char[] getKeySetArray() {
		return keyset;
	}

	public static String getResults() {
		String results = dataClassObj.toString();
		return results;
	}
}