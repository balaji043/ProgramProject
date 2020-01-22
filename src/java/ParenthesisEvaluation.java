package java;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesisEvaluation {
    private static Scanner scanner = new Scanner(System.in);
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        isBalanced(scanner.next().toCharArray());
    }

    private static void isBalanced(char[] a) {
        if (evaluate(a)) System.out.println("Balanced");
        else System.out.println("Not Balanced");
    }

    private static boolean evaluate(char[] array) {
        for (char c : array) {
            if (c == '<' || c == '[' || c == '{' || c == '(') stack.push(c);
            else if (c == '>' || c == ']' || c == '}' || c == ')')
                if (stack.isEmpty()) return false;
                else if (!matching(c, stack.pop()))
                    return false;
        }
        return stack.isEmpty();
    }

    private static boolean matching(char c, Character last) {
        return (c == '>' && last == '<') || (c == ')' && last == '(') || (c == '}' && last == '{') || (c == ']' && last == '[');
    }
}
