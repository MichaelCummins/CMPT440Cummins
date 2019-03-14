//Homework 1 assignment by Michael Cummins 3/13/2019
//Formal Languages and Computability
//File contains main method to run program

import java.util.*;

public class driverDFA {
	public static void main(String[] args) {
		ManWolf m = new ManWolf(); // The DFA
		m.reset();
		m.process(args[0]); // Get argument from standard input
	}
}
