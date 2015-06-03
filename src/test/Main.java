package test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {

		String expression;
		if (args.length > 0) {
			expression = args[0];
		} else {
			expression = "4(97*[89+ 35+ 1+( ])+(8+6))";
		}

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

		Deque<Integer> stack = new ArrayDeque<Integer>();
		arrBrackets = new char[][] { { '(', '[', '{' }, { ')', ']', '}' } };

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
		if (stack.size() > 0) {
			System.out.println("Position of brackets is wrong");
		} else {
			System.out.println("Brackets are right");
		}

	}
}