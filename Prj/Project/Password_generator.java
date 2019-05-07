import java.util.*;

public class Password_generator{
	
	public static String userInput;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		passwordDFA dfa = new passwordDFA();
		
		System.out.println("Enter a password that meets the following criteria: \n"
							+ "Must contain a digit\n"
							+ "Must contain a special character (I.E !@#$)\n"
							+ "Must contain an uppercase letter\n"
							+ "Must contain a lowercase letter\n"
							+ "Must be at least 8 characters long");
		userInput = input.nextLine();
		dfa.reset();
		dfa.process(userInput);
		
	}
}