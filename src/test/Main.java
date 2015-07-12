package test;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;

public class Main {
	// public static boolean firstItteration = true;
	public static void main(String[] args) {
		String expression;

		if (args.length > 0)
			expression = args[0];
		else
			expression = " [4+(97*[89+ 35+ 1+( )]+{8+6})";

		expression = expression.replaceAll(" ", "");

		// FIXME could start with - +
		String arrSymbols[] = new String[] { "+", "-", "/", "*" };
		for (String x : arrSymbols) {
			if (expression.startsWith(x) || expression.endsWith(x)) {
				System.out
						.println("Expression starts with or ends with an irregular symbol");
				return;
			}
		}

		char[][] arrBrackets = { { '(', ')' }, { '[', ']' }, { '{', '}' } };

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

		if (bracketsViaRec(expression)[0] == 0) {
			System.out.println("Expression is good!");
		} else {
			System.out.println("Expression is bad!");
		}
	}

	public static void bracketsViaDeque(String expression) {
		char arrBrackets[][] = new char[][] { { '(', '[', '{' },
				{ ')', ']', '}' } };
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (char element : expression.toCharArray()) {
			if (Arrays.binarySearch(arrBrackets[0], element) >= 0) {
				stack.push(Arrays.binarySearch(arrBrackets[0], element));
			}
			if (Arrays.binarySearch(arrBrackets[1], element) >= 0) {
				if (stack.size() == 0
						|| Arrays.binarySearch(arrBrackets[1], element) != stack
								.pop()) {
					System.out.println("Position of brackets is wrong");
					return;
				}
			}
		}
		if (stack.size() > 0)
			System.out.println("Position of brackets is wrong");
		else
			System.out.println("Brackets are right");
	}

	public static int[] bracketsViaRec(String expression) {
		return bracketsViaRecIn(expression, true);
	}

	public static int[] bracketsViaRecIn(String expression,
			boolean firstItteration) {
		// FIXME : one open at at the beginning - shows OK

		int i;
		if (firstItteration)
			i = 0;
		else
			i = 1;

		System.out.println(expression);

		while (i < expression.length()) {
			if (// i != 0 &&
			Arrays.asList('(', '[', '{').contains(expression.charAt(i))) {
				int result[] = bracketsViaRecIn(expression.substring(i), false);
				if (result[0] == -1)
					return new int[] { -1, i };
				else
					i += result[1] + 1;
				if (i >= expression.length())
					break;
			}

			if (Arrays.asList(')', ']', '}').contains(expression.charAt(i))) {
				// System.out.println("let's match "+expression+" for comparing "+expression.charAt(0)+" and "+expression.charAt(i));
				if (compareBrackets(expression.charAt(0), expression.charAt(i))) {
					return new int[] { 0, i };
				} else
					return new int[] { -1, i };
			}
			i++;
		}
		return new int[] { 0, expression.length()-1 };
	}

	public static Boolean compareBrackets(char openBracket, char closeBracket) {
		Hashtable<String, String> brackets = new Hashtable<String, String>() {
			{
				put("(", ")");
				put("[", "]");
				put("{", "}");
			}
		};

		if (brackets.keySet().contains(String.valueOf(openBracket)))
			return (brackets.get(String.valueOf(openBracket)).equals(String.valueOf(closeBracket)));
		else 
			return false;

	}
}