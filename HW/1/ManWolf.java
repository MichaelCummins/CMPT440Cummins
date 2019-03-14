
public class ManWolf {
	public static final int q0 = 0;
	public static final int q1 = 1;
	public static final int q2 = 2;
	public static final int q3 = 3;
	public static final int q4 = 4;
	public static final int q5 = 5;
	public static final int q6 = 6;
	public static final int q7 = 7; // Goal state
	public static final int q8 = 8;
	public static final int q9 = 9;
	public static final int q10 = 10; //Error state
	
	public int state = q0; //Current state of the user
	public boolean solution = false;
	
	static public int[][] deltaTable = {
			//g   w    n    c
			{q1, q10, q10, q10}, //q0
			{q0, q10, q2, q10},  //q1
			{q10, q3, q1, q8}, //q2
			{q4, q2, q10, q10}, //q3
			{q3, q10, q10, q5}, //q4
			{q10, q9, q6, q4}, //q5
			{q7, q10, q5, q10}, // q6
			{q10, q10, q10, q10}, //q7
			{q9, q10, q10, q2}, //q8
			{q8, q5, q10, q10}, //q9
			{q10, q10, q10, q10} //q10
	};
	
	/**
	 * The transition function
	 * @param s state code (an int)
	 * @param c char to make a transition on
	 * @return the next state code
	 * Based on the transition function from page 38
	 * of our Formal Languages textbook
	 **/
/**	static public int delta(int s, char c){
		switch (s){
			case q0: switch(c){
				case 'g': return q1;
				default: return q10;
			}
			case q1: switch(c){
				case 'g': return q0;
				case 'n': return q2;
				default: return q10;
			}
			case q2: switch(c){
				case 'c': return q8;
				case 'w': return q3;
				case 'n': return q1;
				default: return q10;
			}
			case q3: switch(c){
				case 'g': return q4;
				case 'w': return q2;
				default: return q10;
			}
			case q4: switch(c){
				case 'c': return q5;
				case 'g': return q3;
				default: return q10;
			}
			case q5: switch(c){
				case 'n': return q6;
				case 'c': return q4;
				case 'w': return q9;
				default: return q10;
			}
			case q6: switch(c){
				case 'g': return q7;
				case 'n': return q5;
				default: return q10;
			}
			case q7: switch(c){
				default: return q10;
			}
			case q8: switch(c){
				case 'g': return q9;
				case 'c': return q2;
				default: return q10;
			}
			case q9: switch(c){
				case 'g': return q8;
				case 'w': return q5;
				default: return q10;
			}
			default: return q10;
		}
	}
	*/
	/**
	 * Reset the current state to the start state
	 */
	public void reset(){
		state = q0;
	}
	
	public void process(String input){
		
		for (int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(c == 'g'){
				state = deltaTable[state][0];
			}else if(c == 'w'){
				state = deltaTable[state][1];
			}else if(c == 'n'){
				state = deltaTable[state][2];
			}else if(c == 'c'){
				state = deltaTable[state][3];
			}else{
				state = q10;
			}
	  }
		
		if(accepted()){
			System.out.println("That is a solution");
		}else{
			System.out.println("That is not a solution");
		}
	}
	/**
	 * Returns true if the final state was accepting
	 */
	public boolean accepted(){
		return state == q7;
	}
}
