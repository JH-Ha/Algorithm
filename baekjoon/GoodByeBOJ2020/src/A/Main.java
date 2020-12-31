package A;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static boolean solveld = false;

    public static void solve(String[] s, boolean[] used, int n, LinkedList<String> list) {
        for (int i = 0; i < n; i++) {
            if (!used[i] && list.isEmpty()) {
                list.add(s[i]);
                used[i] = true;
                solve(s, used, n, list);
                if (solveld)
                    return;
                used[i] = false;
                list.removeLast();
            } else if (!used[i] && !list.isEmpty()) {
                String last = list.getLast();
                if (last.charAt(0) == s[i].charAt(0)) {
                    list.add(s[i]);
                    used[i] = true;
                    solve(s, used, n, list);
                    if (solveld)
                        return;
                    used[i] = false;
                    list.removeLast();
                }
            }
        }
        boolean isSolved = true;
        for (int j = 0; j < n; j++) {
            if (!used[j]) {
                isSolved = false;
                break;
            }
        }
        if (isSolved) {
            solveld = true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = Integer.parseInt(sc.nextLine());
        String input = sc.nextLine();
        String[] s = input.split(" ");
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            used[i] = false;
        }
        LinkedList<String> list = new LinkedList<>();
        solve(s, used, n, list);
        if (solveld) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
