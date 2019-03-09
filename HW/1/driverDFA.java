import java.util.*;

public class driverDFA {
	public static String input;
	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // Standard input
		ManWolf m = new ManWolf(); // The DFA
		m.reset();
		m.process(args[0]);
	}
}
