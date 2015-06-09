package test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		String expression;
		if (args.length > 0)
			expression = args[0];
		else
			expression = "4(97*[89+ 35+ 1+( ])+{8+6})";

		expression = expression.replaceAll(" ", "");

		String arrSymbols[] = new String[] { "+", "-", "/", "*" };
		for (String x : arrSymbols) {
			if (expression.startsWith(x) || expression.endsWith(x)) {
				System.out
						.println("Expression starts with or ends with an irregular symbol");
				return;
			}
		}

		char arrBrackets[][] = { { '(', ')' }, { '[', ']' }, { '{', '}' } };

		// математические знаки после открывающей скобки
		for (String symbol : arrSymbols) {
			for (char[] brackets : arrBrackets) {
				if (expression.contains(brackets[0] + symbol)
						|| expression.contains(symbol + brackets[1])) {
					System.out
							.println("Math symbols after open brackets or before close brackets");
					return;
				}
			}
		}
		arrBrackets = new char[][] { { '(', '[', '{' }, { ')', ']', '}' } };
		// Deque<Integer> stack = new ArrayDeque<Integer>();
		// for (char element : expression.toCharArray())
		// {
		// if (Arrays.binarySearch(arrBrackets[0], element) >= 0)
		// {
		// stack.push(Arrays.binarySearch(arrBrackets[0], element));
		// }
		// if (Arrays.binarySearch(arrBrackets[1], element) >= 0)
		// {
		// if (stack.size() == 0
		// || Arrays.binarySearch(arrBrackets[1], element) != stack.pop())
		// {
		// System.out.println("Position of brackets is wrong");
		// return;
		// }
		// }
		// }
		// if (stack.size() > 0)
		// System.out.println("Position of brackets is wrong");
		// else
		// System.out.println("Brackets are right");

	//	String s = recursion(expression);
		if (rec(expression)[0] == 0){
			System.out.println("Expression is good!");
		} else {
			System.out.println("Expression is bad!");
		}
		

	}

	
	public static int[] rec(String expression)
	{
		System.out.println(expression);
		int i = 0;

		while(i < expression.length())
		{
			if(i != 0 && Arrays.asList('(', '[', '{').contains(expression.charAt(i))) {
				int result[] = rec(expression.substring(i));
				if (result[0] == -1)
					return new int[] {-1, i};
				else 
					i += result[1];
			}
			
			if(Arrays.asList(')', ']', '}').contains(expression.charAt(i))) {
				if (true) {
					System.out.println("Found close on " + i);
					return new int[] {0, i};
				}
				else 
					return new int[] {-1, i};
			}
			i++;
		}
		return new int[]  {0};
	}
	
	public static String recursion(String expression) {
		
		char brackets[][] = { { '(', ')' }, { '[', ']' }, { '{', '}' } };
		for (int j = 0; j < brackets.length; j++) {
			char charBracketOpen = brackets[j][0];
			System.out.println(charBracketOpen);
			for (int i = expression.length(); i > 0; i--) {
				// System.out.println(expression);

				if (expression.indexOf(charBracketOpen) != 0)// if expression begin not from openBracket
				{
					System.out.println(expression);
					expression = expression.substring(1);
				} else {
					System.out.println(expression + "Starts from open bracket");
					recursion(expression.substring(1));
				}

			}
		}
		return expression;
	}
}