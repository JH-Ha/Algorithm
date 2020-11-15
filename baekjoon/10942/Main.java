import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 5];
        int[][] dp = new int[n + 5][n + 5];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dp[i][i] = 1;

        }
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; i + j <= n; j++) {
                if (i - j <= 0 || arr[i + j] != arr[i - j])
                    break;
                else if (arr[i + j] == arr[i - j]) {
                    dp[i - j][i + j] = 1;
                }
            }
            for (int j = 1; i + 1 + j <= n; j++) {
                if (dp[i][i + 1] == 1) {
                    if (i - j <= 0 || arr[i + 1 + j] != arr[i - j]) {
                        break;
                    } else if (arr[i + 1 + j] == arr[i]) {
                        dp[i - j][i + 1 + j] = 1;
                    }
                }
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            bw.write(Integer.toString(dp[s][e]) + '\n');
        }
        bw.flush();
        bw.close();
        sc.close();
    }
}
