package p_c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static int query(int[] tree, int start, int end) {
        int treeSize = tree.length / 2;
        int left = treeSize + start;
        int right = treeSize + end;
        int ans = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                ans += tree[left];
                left += 1;
            }
            if (right % 2 == 0) {
                ans += tree[right];
                right -= 1;
            }
            left /= 2;
            right /= 2;
        }
        return ans;
    }

    public static int[] initTree(int[] a) {
        int n = a.length;
        double nn = Math.ceil(Math.log10(n) / Math.log10(2));
        int treeSize = 1 << (int) nn;
        int[] tree = new int[treeSize * 2];
        for (int i = 0; i < treeSize * 2; i++) {
            tree[i] = 1234567890;
        }
        for (int i = treeSize; i < treeSize + n; i++) {
            tree[i] = a[i - treeSize];
        }
        for (int i = treeSize - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }
        return tree;
    }

    public static void update(int[] tree, int idx, int value) {
        int treeSize = tree.length / 2;
        int minus = tree[treeSize + idx];
        int p = treeSize + idx;
        while (p != 0) {
            tree[p] = tree[p] - minus + value;
            p = p / 2;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input1 = Arrays.stream((bf.readLine().split(" "))).map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = input1.get(0);
        int q = input1.get(1);

        int[] row = new int[n];
        int[] col = new int[n];

        StringBuffer answer = new StringBuffer();

        int[] zeros = new int[n];
        int[] treeCol = initTree(zeros);
        int[] treeRow = initTree(zeros);

        while (q-- > 0) {
            List<Integer> query = Arrays.stream((bf.readLine().split(" "))).map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (query.get(0) == 1) {
                int x = query.get(1) - 1;
                int y = query.get(2) - 1;
                row[x]++;
                col[y]++;
                if (row[x] == 1) {
                    update(treeRow, x, 1);
                }
                if (col[y] == 1) {
                    update(treeCol, y, 1);
                }
            } else if (query.get(0) == 2) {
                int x = query.get(1) - 1;
                int y = query.get(2) - 1;
                row[x]--;
                col[y]--;
                if (row[x] == 0) {
                    update(treeRow, x, 0);
                }
                if (col[y] == 0) {
                    update(treeCol, y, 0);
                }
            } else if (query.get(0) == 3) {
                int x1 = query.get(1) - 1;
                int y1 = query.get(2) - 1;
                int x2 = query.get(3) - 1;
                int y2 = query.get(4) - 1;
                boolean xAttacked = false;
                if (query(treeRow, x1, x2) == (x2 - x1 + 1)) {
                    xAttacked = true;
                }
                boolean yAttacked = false;
                if (query(treeCol, y1, y2) == (y2 - y1 + 1)) {
                    yAttacked = true;
                }
                if (xAttacked || yAttacked) {
                    answer.append("Yes").append("\n");
                } else {
                    answer.append("No").append("\n");
                }

            }

        }
        System.out.println(answer.toString());
    }
}
