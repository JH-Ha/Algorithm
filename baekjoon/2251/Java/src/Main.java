import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class State {
    int curA;
    int curB;
    int curC;

    public State(int a, int b, int c) {
        this.curA = a;
        this.curB = b;
        this.curC = c;
    }

    public String getKey() {
        return curA + "-" + curB + "-" + curC;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // 8 9 10
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] spt = line.split(" ");
        int a = Integer.parseInt(spt[0]);
        int b = Integer.parseInt(spt[1]);
        int c = Integer.parseInt(spt[2]);
        Set<String> visited = new HashSet<>();
        Set<Integer> answer = new HashSet<>();

        Queue<State> q = new LinkedList<>();

        State init = new State(0, 0, c);
        q.add(init);
        visited.add(init.getKey());
        while (!q.isEmpty()) {
            State top = q.poll();
            if (top.curA == 0) {
                answer.add(top.curC);
            }
            // a -> b
            if (top.curA > 0 && top.curB < b) {
                int canMove = (b - top.curB);
                int move = Math.min(top.curA, canMove);
                int nextA = top.curA - move;
                int nextB = top.curB + move;
                State nextState = new State(nextA, nextB, top.curC);
                if (!visited.contains(nextState.getKey())) {
                    visited.add(nextState.getKey());
                    q.add(nextState);
                }
            }
            // a -> c
            if (top.curA > 0 && top.curC < c) {
                int canMove = (c - top.curC);
                int move = Math.min(top.curA, canMove);
                int nextA = top.curA - move;
                int nextC = top.curC + move;
                State nextState = new State(nextA, top.curB, nextC);
                if (!visited.contains(nextState.getKey())) {
                    // answer.add(nextC);
                    visited.add(nextState.getKey());
                    q.add(nextState);
                }
            }

            // b -> a
            if (top.curB > 0 && top.curA < a) {
                int canMove = (a - top.curA);
                int move = Math.min(top.curB, canMove);
                int nextB = top.curB - move;
                int nextA = top.curA + move;
                State nextState = new State(nextA, nextB, top.curC);
                if (!visited.contains(nextState.getKey())) {
                    visited.add(nextState.getKey());
                    q.add(nextState);
                }
            }
            // b -> c
            if (top.curB > 0 && top.curC < c) {
                int canMove = (c - top.curC);
                int move = Math.min(top.curB, canMove);
                int nextB = top.curB - move;
                int nextC = top.curC + move;
                State nextState = new State(top.curA, nextB, nextC);
                if (!visited.contains(nextState.getKey())) {
                    // answer.add(nextC);
                    visited.add(nextState.getKey());
                    q.add(nextState);
                }
            }
            // c -> a
            if (top.curC > 0 && top.curA < a) {
                int canMove = (a - top.curA);
                int move = Math.min(top.curC, canMove);
                int nextC = top.curC - move;
                int nextA = top.curA + move;
                State nextState = new State(nextA, top.curB, nextC);
                if (!visited.contains(nextState.getKey())) {
                    // answer.add(nextC);
                    visited.add(nextState.getKey());
                    q.add(nextState);
                }
            }
            // c -> b
            if (top.curC > 0 && top.curB < b) {
                int canMove = (b - top.curB);
                int move = Math.min(top.curC, canMove);
                int nextC = top.curC - move;
                int nextB = top.curB + move;
                State nextState = new State(top.curA, nextB, nextC);
                if (!visited.contains(nextState.getKey())) {
                    // answer.add(nextC);
                    visited.add(nextState.getKey());
                    q.add(nextState);
                }
            }
        }
        List<Integer> answerList = answer.stream().collect(Collectors.toList());
        answerList.sort((Integer aa, Integer bb) -> {
            return aa - bb;
        });
        answerList.stream().forEach(aa -> {
            System.out.print(aa + " ");
        });
        System.out.println();
    }
}
