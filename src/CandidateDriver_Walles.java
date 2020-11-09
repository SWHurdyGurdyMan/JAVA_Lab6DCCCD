import java.text.SimpleDateFormat;
import java.util.*;

//CandidateDriver_Walles.java
public class CandidateDriver_Walles {
	// instance variables
	private static String lastName;
	private static String firstName;
	private static String SSNumber;
	private static String driversLicenseNumber;
	private static String address;
	private static int missedQuestions = 0;
	private static int correctQuestions = 0;
	private static String grade;
	private static Scanner input = new Scanner(System.in);
	private static int MINIMUM_DNUMBER = 00000001;
	private static int MAXIMUM_DNUMBER = 99999999;
	private static Random dNumber = new Random();
	private static int randomNumber = 0;
	private static ArrayList<Integer> missedQArrayList = new ArrayList<Integer>();
	// date formatting
	String pattern = "MM/dd/yyyy";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String date = simpleDateFormat.format(new Date());

	// Allows user to enter name, address, Social Security number, etc.
	public static void userInfo() {
		System.out.println("Enter last name: ");
		lastName = input.nextLine();
		System.out.println("Enter first name: ");
		firstName = input.nextLine();
		System.out.println("Enter Social Security Number: ");
		SSNumber = input.nextLine();
		System.out.println("Driver's License Number is: ");
		dNumber(MINIMUM_DNUMBER, MAXIMUM_DNUMBER);
		System.out.println(driversLicenseNumber);
		System.out.println("Enter address: ");
		address = input.nextLine();
	}

	// checks answer array against key array
	public static int evaluateResult(char[] answerArray, char[] keyArray) {
		int counter = 0;
		while (counter < keyArray.length) {
			for (int i = 0; i < keyArray.length; i++) {
				if (answerArray[i] == keyArray[i]) {
					correctQuestions++;
					counter++;
				} else {
					missedQArrayList.add(i + 1);
					counter++;
				}
			}
		}
		if (correctQuestions >= 20) {
			grade = "PASSED";
		} else {
			grade = "FAILED";
		}
		return correctQuestions;
	}

	// prints results to string
	public String toString() {
		String output = ("FA2020_ DriverLicenseTest_Walles.java" + "\n" + "DRIVER TEST RESULT – SHELBY WALLES" + "\n"
				+ "-------------------------------------" + "\n" + "Driver’s name: " + lastName + ", " + firstName
				+ "\n" + "SS Number: " + SSNumber + "\n" + "Address: " + address + "\n" + "Driver’s License: "
				+ driversLicenseNumber + "\n" + "Test Date: " + date + "\n" + "Result: " + grade + "\n"
				+ "Missed Questions: " + missedQArrayList + "\n");

		return output;
	}

	// creates random drivers license number within min and max range
	public static String dNumber(int min, int max) {
		randomNumber = dNumber.nextInt((max - min) + 1) + min;
		driversLicenseNumber = String.valueOf(randomNumber);
		return driversLicenseNumber;
	}
}