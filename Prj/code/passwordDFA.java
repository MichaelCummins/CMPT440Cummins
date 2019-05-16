
public class passwordDFA {
	
	public static final int q0 = 0; //Start State
	public static final int q1 = 1; 
	public static final int q2 = 2;
	public static final int q3 = 3;
	public static final int q4 = 4; //Goal State 
	public static final int q5 = 5; 
	public static final int q6 = 6;
	public static final int q7 = 7;
	public static final int q8 = 8;
	public static final int q9 = 9;
	public static final int q10 = 10;
	public static final int q11 = 11;
	public static final int q12 = 12;
	public static final int q13 = 13;
	public static final int q14 = 14;
	public static final int q15 = 15;
	public static final int q16 = 16;
	public static final int q17 = 17;
	public static final int q18 = 18;
	public static final int q19 = 19;
	public static final int q20 = 20;
	public static final int q21 = 21;

	
	public int currentState;
	

	public int length;
	
	public static int deltaTable [][] = {
			//A-Z, a-z, 1-9, Spec
			{q1,   q9,   q14,  q19}, //q0 Start State
			{q1,   q2,   q5,   q6 }, //q1
			{q2,   q2,   q3,   q8 }, //q2
			{q3,   q3,   q3,   q4 }, //q3
			{q4,   q4,   q4,   q4 }, //q4 Goal State
			{q5,   q3,   q5,   q7 }, //q5
			{q6,   q8,   q7,   q6 }, //q6
			{q7,   q4,   q7,   q7 }, //q7
			{q8,   q8,   q4,   q8 }, //q8
			{q12,  q9,   q10,  q11}, //q9
			{q3,   q10,  q10,  q13}, //q10
			{q8,   q11,  q13,  q11}, //q11
			{q12,  q12,  q3,   q8 }, //q12
			{q4,   q13,  q13,  q13}, //q13
			{q15,  q16,  q14,  q17}, //q14
			{q15,  q3,   q15,  q7 }, //q15
			{q3,   q16,  q16,  q13}, //q16
			{q7,   q13,  q17,  q17}, //q17
			{q19,  q20,  q21,  q18}, //q18
			{q19,  q8,   q7,   q19}, //q19
			{q8,   q20,  q13,  q20}, //q20
			{q7,   q13,  q21,  q21}, //q21
	};
	
	public void process(String input){
		for (int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(Character.isUpperCase(c)){
				currentState = deltaTable[currentState][0];
				length++;
				
			}else if(Character.isLowerCase(c)){
				currentState = deltaTable[currentState][1];
				length++;
				
			}else if(c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || 
					 c == '5' || c == '6' || c == '7' || c == '8' || c == '9'){
				currentState = deltaTable[currentState][2];
				length++;
				
			}else if(c == '!' || c == '@' || c == '#' || c == '$' || c == '%' ||
					 c == '^' || c == '&' || c == '*' || c == '(' || c == ')'){
				currentState = deltaTable[currentState][3];
				length++;
				
			}
			
		}
		
		if(accepted()){
			System.out.println("That is a good password");
			
		}else{
			System.out.println("That is not a good password");
		}
	}
	
	
	public boolean accepted(){
		if(length >= 8){
			return currentState == q4;
		}else{
			return false;
		}
	}
	
	public void reset(){
		currentState = q0;	
	}

}