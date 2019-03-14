import java.util.*;

public class driverDFA {
	public static void main(String[] args) {
		ManWolf m = new ManWolf(); // The DFA
		m.reset();
		m.process(args[0]);
	}
}
