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
			expression = "4+(97*[89+( )]+{8+6})";

		expression = expression.replaceAll(" ", "");
		System.out.println(expression);
		String wrongOpenSymbols[] = new String[] { "/", "*" };
		String wrongCloseSymbols[] = new String[] { "+", "-", "/", "*" };
		for (String x : wrongOpenSymbols) {
			if (expression.startsWith(x)) {
				System.out
						.println("Expression starts with an irregular symbol");
				return;
			}
		}
		for (String x : wrongCloseSymbols) {
			if (expression.endsWith(x)) {
				System.out.println("Expression ends with an irregular symbol");
				return;
			}
		}

		char[][] arrBrackets = { { '(', ')' }, { '[', ']' }, { '{', '}' } };

		// математические знаки после открывающей скобки
		for (String symbol : wrongCloseSymbols) {
			for (char[] brackets : arrBrackets) {
				if (expression.contains(brackets[0] + symbol)
						|| expression.contains(symbol + brackets[1])) {
					System.out
							.println("Math symbols after open brackets or before close brackets");
					return;
				}
			}
		}

		if (bracketsViaRec(expression)) {
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

	public static boolean bracketsViaRec(String expression) {

		return (bracketsViaRecIn(expression)[0] == expression.length());
	}

	public static int[] bracketsViaRecIn(String expression) {
		int i = 0;
		char[] openBrackets = { '(', '[', '{' };

		while (i < expression.length()) {
			if (Arrays.asList(')', ']', '}').contains(expression.charAt(i))) {
				return new int[] {
						i,
						Arrays.asList(')', ']', '}').indexOf(
								expression.charAt(i)) };
			}

			if (Arrays.asList('(', '[', '{').contains(expression.charAt(i))) {
				int result[] = bracketsViaRecIn(expression.substring(i + 1));
				if (result[0] == -1 || result[1] == -1) {
					return new int[] { -1, 0 };
				} else {
					if (openBrackets[result[1]] == expression.charAt(i))
						i += result[0] + 1;
					else
						return new int[] { -1, 0 };
				}
			}

			i++;
		}

		return new int[] { expression.length(), -1 };
	}

	// public static Boolean compareBrackets(char openBracket, char
	// closeBracket) {
	// Hashtable<String, String> brackets = new Hashtable<String, String>() {
	// {
	// put("(", ")");
	// put("[", "]");
	// put("{", "}");
	// }
	// };
	//
	// if (brackets.keySet().contains(String.valueOf(openBracket)))
	// return (brackets.get(String.valueOf(openBracket)).equals(String
	// .valueOf(closeBracket)));
	// else
	// return false;
	//
	// }
}