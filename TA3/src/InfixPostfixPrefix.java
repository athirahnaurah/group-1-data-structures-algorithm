import java.util.Stack;
import java.util.Scanner;

public class InfixPostfixPrefix {

    static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }
    static boolean isValidInfix(String exp) {
        boolean lastWasOperator = true;

        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                lastWasOperator = false;
            } else if ("+-*/".indexOf(c) != -1) {
                if (lastWasOperator) return false;
                lastWasOperator = true;
            } else {
                return false;
            }
        }
        return !lastWasOperator;
    }

    static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char c : infix.toCharArray()) {
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    static String infixToPrefix(String infix) {
        String reversed = new StringBuilder(infix).reverse().toString();

        Stack<Character> stack = new Stack<>();
        StringBuilder prefix = new StringBuilder();

        for (char c : reversed.toCharArray()) {
            if (Character.isDigit(c)) {
                prefix.append(c);
            } else {
                while (!stack.isEmpty() &&
                        precedence(stack.peek()) > precedence(c)) {
                    prefix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            prefix.append(stack.pop());
        }

        return prefix.reverse().toString();
    }
    static int calculatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan notasi infix: ");
        String infix = input.nextLine().replaceAll("\\s+", "");

        if (!isValidInfix(infix)) {
            System.out.println("Notasi infix tidak valid!");
            return;
        }

        String postfix = infixToPostfix(infix);
        String prefix = infixToPrefix(infix);
        int hasil = calculatePostfix(postfix);

        System.out.println("Infix   : " + infix);
        System.out.println("Postfix : " + postfix);
        System.out.println("Prefix  : " + prefix);
        System.out.println("Hasil   : " + hasil);
    }
}
