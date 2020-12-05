class Solution2 {
    private int[] tree;

    private int treeSize;

    public int query(int start, int end) {
        int left = treeSize + start;
        int right = treeSize + end;
        int ans = 1234567890;
        while (left <= right) {
            if (left % 2 == 1) {
                ans = Math.min(tree[left], ans);
                left += 1;
            }
            if (right % 2 == 0) {
                ans = Math.min(tree[right], ans);
                right -= 1;
            }
            left /= 2;
            right /= 2;
        }
        return ans;
    }

    public void initTree(int[] a) {
        int n = a.length;
        double nn = Math.ceil(Math.log10(n) / Math.log10(2));
        treeSize = 1 << (int) nn;
        tree = new int[treeSize * 2];
        for (int i = 0; i < treeSize * 2; i++) {
            tree[i] = 1234567890;
        }
        for (int i = treeSize; i < treeSize + n; i++) {
            tree[i] = a[i - treeSize];
        }
        for (int i = treeSize - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

    }

    public int solution(int[] a) {
        if (a.length <= 3) {
            return a.length;
        }
        int answer = 2;
        initTree(a);
        for (int i = 1; i < a.length - 1; i++) {
            int leftMin = query(0, i - 1);
            int rightMin = query(i + 1, a.length - 1);
            if (a[i] <= leftMin || a[i] <= rightMin) {
                answer++;
            }
        }
        return answer;
    }
}

public class PopBalloon {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] input = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };
        System.out.println(solution.solution(input));
        // System.out.println(solution.query(0, 2));
        // System.out.println(solution.query(2, 4));
        // System.out.println(solution.query(4, 6));
    }
}