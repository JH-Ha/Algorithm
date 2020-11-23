import java.util.Scanner;

class Main {

    static int[] student;
    static int[] cnt;
    static boolean[] visited;
    static int[] startStudent;
    static int answer = 0;

    public static int dfs(int start, int curCnt, int idx) {
        if (visited[idx]) {
            if (startStudent[idx] != start) {
                return 0;
            }
            return curCnt - cnt[idx];
        }
        startStudent[idx] = start;
        cnt[idx] = curCnt;
        visited[idx] = true;
        return dfs(start, curCnt + 1, student[idx]);
    }

    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            student = new int[n + 1];
            cnt = new int[n + 1];
            visited = new boolean[n + 1];
            startStudent = new int[n + 1];
            answer = 0;
            for (int i = 1; i <= n; i++) {
                student[i] = sc.nextInt();
                visited[i] = false;
                cnt[i] = 0;
                startStudent[i] = 0;
            }
            for (int i = 1; i <= n; i++) {
                answer += dfs(i, 1, i);
            }
            System.out.println(n - answer);

        }
        sc.close();
    }
}