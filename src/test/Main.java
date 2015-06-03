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
			expression = "4(97*[89+ 35+ 1+( ])";
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
		/*
		 * if error return -1 if no error return None
		 */
		// for(int i = expression.length(); i > 0; i--)
		// {
		// if(expression.charAt(0))
		//
		// expression = expression.substring(1);
		// }

//		for (int i = 0; i < 15; i++) {
//			System.out.println(i);
//		}

		int i = 0;  //jump from 3 to 7
		while (i < 15) {
			System.out.println(i);
			if(i == 3) i = 6;
			i++;
		}

	}
}
// Deque<Integer> stack = new ArrayDeque<Integer>();
// arrBrackets = new char[][] { { '(', '[', '{' }, { ')', ']', '}' } };
//
// for (char element : expression.toCharArray()) {
//
// if (Arrays.binarySearch(arrBrackets[0], element) >= 0) {
// stack.push(Arrays.binarySearch(arrBrackets[0], element));
//
// }
// if (Arrays.binarySearch(arrBrackets[1], element) >= 0) {
// if (stack.size() == 0
// || Arrays.binarySearch(arrBrackets[1], element) != stack
// .pop()) {
// System.out.println("Position of brackets is wrong");
// return;
// }
// }
//
// }
// if (stack.size() > 0) {
// System.out.println("Position of brackets is wrong");
// } else {
// System.out.println("Brackets are right");
// }

