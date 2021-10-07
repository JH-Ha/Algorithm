package monthlyChallenge202110.p3;

class Solution {

    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0L;

        int lx = x;
        int ly = y;
        int rx = x;
        int ry = y;

        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            if (query[0] == 2) {
                if (lx != 0 && lx + query[1] >= n) {
                    return 0;
                }
                if (lx != 0) {
                    lx = lx + query[1];
                }
                int nrx = rx + query[1];
                if (nrx >= n) {
                    nrx = n - 1;
                }
                rx = nrx;
            } else if (query[0] == 3) {
                int nrx = rx - query[1];
                if (rx != n - 1 && nrx < 0) {
                    return 0;
                }
                if (rx != n - 1) {
                    rx = nrx;
                }
                int nlx = lx - query[1];
                if (nlx < 0) {
                    nlx = 0;
                }
                lx = nlx;
            } else if (query[0] == 0) {
                int nly = ly + query[1];
                if (ly != 0 && nly >= m) {
                    return 0;
                }
                if (ly != 0) {
                    ly = nly;
                }
                int nry = ry + query[1];
                if (nry >= m) {
                    nry = m - 1;
                }
                ry = nry;
            } else {
                int nry = ry - query[1];
                if (ry != m - 1 && nry < 0) {
                    return 0;
                }
                if (ry != m - 1) {
                    ry = nry;
                }
                int nly = ly - query[1];
                if (nly < 0) {
                    nly = 0;
                }
                ly = nly;
            }
        }
        answer = ((rx - lx + 1L) * (ry - ly + 1));
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int m = 3;
        int x = 0;
        int y = 0;
        // int[][] queries = { { 2, 1 }, { 0, 1 }, { 1, 1 }, { 0, 1 }, { 2, 1 } };
        int[][] queries = { { 3, 1 }, { 2, 2 }, { 1, 1 }, { 2, 3 }, { 0, 1 }, { 2, 1 } };
        System.out.println(solution.solution(n, m, x, y, queries));

    }
}
