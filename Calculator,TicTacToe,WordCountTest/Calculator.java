package Calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Iveskite komanda, pavyzdziui: \"a + b\" ");
		String input = scanner.nextLine();
		
		int one = getOne(input);
		int two = getTwo(input);
		String sign = getSign(input);
		
		System.out.println("Atsakymas yra: " +getAnswer(one, two, sign));
		
		
		//System.out.println(vienas);
		//System.out.println(du);
		//System.out.println(zenklas);

	}
	
	public static int getOne(String input) {
		String first = input.substring(0, input.indexOf(getSign(input)));
		int one = Integer.valueOf(first);
		return one;
	}
	public static int getTwo(String input) {
		String second = input.substring(input.lastIndexOf(getSign(input))+1);
		
		int two = Integer.valueOf(second);
		return two;
	}
	
	public static String getSign(String input) {
		
		String[] numbers = new String[input.length()];
		String sign = null;
		
		for (int i=0; i<input.length();i++) {
			if ((input.substring(i,i+1).equals("+"))||input.substring(i,i+1).equals("-")||input.substring(i,i+1).equals("*")||
					input.substring(i,i+1).equals("/")||input.substring(i,i+1).equals("%")) {
				sign = input.substring(i,i+1);
			}
		}
		
		return sign;
	}
	
	public static int getAnswer(int one, int two, String sign) throws ArithmeticException {
		
		int answer=0;
		

		switch (sign) {
		case "+":
			answer = one + two;
			break;
		case "-":
			answer = one - two;
			break;
		case "*":
			answer = one * two;
			break;
		case "/":
			if (two == 0) {
				throw new ArithmeticException ("Dalyba is 0 negalima");
			}
			answer = one / two;
			break;
		case "%":
			answer = one % two;
			break;
		}
		
		
		return answer;
	}
}