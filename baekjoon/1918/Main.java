import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                result += s.charAt(i);
            } else {
                if (s.charAt(i) == '(') {
                    stack.push(c);
                } else if (c == '*' || c == '/') {
                    while (!stack.isEmpty() && (stack.lastElement() == '*' || stack.lastElement() == '/')) {
                        result += stack.pop();
                    }
                    stack.push(c);
                } else if (c == '+' || c == '-') {
                    while (!stack.isEmpty() && (stack.lastElement() != '(')) {
                        result += stack.pop();
                    }
                    stack.push(c);
                } else if (c == ')') {
                    while (!stack.isEmpty() && stack.lastElement() != '(') {
                        result += stack.pop();
                    }
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}