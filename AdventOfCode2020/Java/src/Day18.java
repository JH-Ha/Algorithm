import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Node {

}

class OperNode extends Node {
    char oper;
    Node leftNode;
    Node rightNode;
    int priority;

    public OperNode(char oper) {
        this.oper = oper;
        if (oper == '+') {
            this.priority = 2;
        } else {
            this.priority = 1;
        }
    }

}

class NumNode extends Node {
    long num;

    public NumNode(long num) {
        this.num = num;
    }
}

public class Day18 {
    public static Node parse(Node root, String exp) {

        // remove blank
        int startIdx = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) != ' ') {
                startIdx = i;
                break;
            }
        }
        exp = exp.substring(startIdx);

        // handle empty string
        if (exp.length() == 0) {
            return root;
        }
        if (exp.startsWith("+") || exp.startsWith("*")) {
            OperNode operNode = new OperNode(exp.charAt(0));
            operNode.leftNode = root;
            return parse(operNode, exp.substring(1));
        } else if (exp.startsWith("(")) {
            int leftRightSum = 0;
            int rightParaIdx = 0;
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(') {
                    leftRightSum++;
                } else if (exp.charAt(i) == ')') {
                    leftRightSum--;
                }
                if (leftRightSum == 0) {
                    rightParaIdx = i;
                    break;
                }
            }
            Node para = parse(null, exp.substring(1, rightParaIdx));

            if (root == null) {
                root = para;
            } else {
                ((OperNode) root).rightNode = para;
            }
            return parse(root, exp.substring(rightParaIdx + 1));
        } else {
            // number;
            int endIdx = exp.indexOf(" ");
            if (endIdx == -1) {
                if (root == null)
                    root = new NumNode(Long.parseLong(exp));
                else {
                    ((OperNode) root).rightNode = new NumNode(Long.parseLong(exp));
                }
                return root;
            } else {
                long num = Long.parseLong(exp.substring(0, endIdx));
                NumNode numNode = new NumNode(num);
                if (root == null)
                    root = numNode;
                else
                    ((OperNode) root).rightNode = numNode;
                return parse(root, exp.substring(endIdx + 1));
            }
        }
    }

    public static Node parseP2(Node root, String exp) {

        // remove blank
        int startIdx = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) != ' ') {
                startIdx = i;
                break;
            }
        }
        exp = exp.substring(startIdx);

        // handle empty string
        if (exp.length() == 0) {
            return root;
        }
        if (exp.startsWith("*")) {
            OperNode operNode = new OperNode(exp.charAt(0));
            operNode.leftNode = root;
            return parseP2(operNode, exp.substring(1));
        } else if (exp.startsWith("+")) {
            if (root instanceof OperNode) {
                OperNode rootOper = (OperNode) root;
                if (rootOper.priority < 2) {
                    OperNode operNode = new OperNode(exp.charAt(0));
                    operNode.leftNode = rootOper.rightNode;
                    rootOper.rightNode = operNode;
                    return parseP2(root, exp.substring(1));
                } else {
                    OperNode operNode = new OperNode(exp.charAt(0));
                    operNode.leftNode = root;
                    return parseP2(operNode, exp.substring(1));
                }
            } else {
                OperNode operNode = new OperNode(exp.charAt(0));
                operNode.leftNode = root;
                return parseP2(operNode, exp.substring(1));
            }

        } else if (exp.startsWith("(")) {
            int leftRightSum = 0;
            int rightParaIdx = 0;
            for (int i = 0; i < exp.length(); i++) {
                if (exp.charAt(i) == '(') {
                    leftRightSum++;
                } else if (exp.charAt(i) == ')') {
                    leftRightSum--;
                }
                if (leftRightSum == 0) {
                    rightParaIdx = i;
                    break;
                }
            }
            Node para = parseP2(null, exp.substring(1, rightParaIdx));
            if (para instanceof OperNode) {
                ((OperNode) para).priority = 2;
            }
            if (root == null) {
                root = para;
            } else {
                OperNode rootOper = (OperNode) root;
                while (rootOper.rightNode != null) {
                    rootOper = (OperNode) rootOper.rightNode;
                }
                rootOper.rightNode = para;
            }
            return parseP2(root, exp.substring(rightParaIdx + 1));
        } else {
            // number;
            int endIdx = exp.indexOf(" ");
            if (endIdx == -1) {
                NumNode numNode = new NumNode(Long.parseLong(exp));
                if (root == null)
                    root = numNode;
                else {
                    OperNode rootOper = (OperNode) root;
                    while (rootOper.rightNode != null) {
                        rootOper = (OperNode) rootOper.rightNode;
                    }
                    rootOper.rightNode = numNode;
                }
                return root;
            } else {
                long num = Long.parseLong(exp.substring(0, endIdx));
                NumNode numNode = new NumNode(num);
                if (root == null)
                    root = numNode;
                else {
                    OperNode rootOper = (OperNode) root;
                    while (rootOper.rightNode != null) {
                        rootOper = (OperNode) rootOper.rightNode;
                    }
                    rootOper.rightNode = numNode;
                }
                return parseP2(root, exp.substring(endIdx + 1));
            }
        }
    }

    public static long calNode(Node root) {
        if (root instanceof NumNode) {
            return ((NumNode) root).num;
        } else if (root instanceof OperNode) {
            OperNode operNode = (OperNode) root;
            if (operNode.oper == '+') {
                return calNode(operNode.leftNode) + calNode(operNode.rightNode);
            } else if (operNode.oper == '*') {
                return calNode(operNode.leftNode) * calNode(operNode.rightNode);
            }
        }
        return 0L;
    }

    public static void printNode(Node root) {
        if (root instanceof NumNode) {
            System.out.print(" " + ((NumNode) root).num + " ");
        } else {
            OperNode operNode = (OperNode) root;
            if (operNode.leftNode instanceof OperNode)
                System.out.print("(");
            printNode(operNode.leftNode);
            if (operNode.leftNode instanceof OperNode)
                System.out.print(") ");
            System.out.print(operNode.oper);
            if (operNode.rightNode instanceof OperNode)
                System.out.print(" (");
            printNode(operNode.rightNode);
            if (operNode.rightNode instanceof OperNode)
                System.out.print(")");
        }
    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p18Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = "9 * 7 + 8 + 3";
            long sum = 0L;
            long sumP2 = 0L;
            while ((line = br.readLine()) != null) {
                // long num = cal(line);
                // System.out.println(num);
                Node result = parse(null, line);
                long num = calNode(result);
                Node resultP2 = parseP2(null, line);
                long numP2 = calNode(resultP2);
                // printNode(resultP2);
                sum += num;
                sumP2 += numP2;
            }
            System.out.println("ans : " + sum);
            System.out.println("ansP2 : " + sumP2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
