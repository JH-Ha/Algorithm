import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int requiredMemory = sc.nextInt();
        int[] memory = new int[n + 5];
        int[] cost = new int[n + 5];

        for (int i = 1; i <= n; i++) {
            memory[i] = sc.nextInt();
        }
        int costSum = 0;
        for (int i = 1; i <= n; i++) {
            cost[i] = sc.nextInt();
            costSum += cost[i];
        }

        long[][] dp = new long[n + 5][costSum + 5];

        for (int i = 0; i < costSum + 5; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        int ans = 1000000;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= costSum; j++) {
                if (j - cost[i] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j - cost[i]] + memory[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[i][j] >= requiredMemory) {
                    ans = Math.min(ans, j);
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}