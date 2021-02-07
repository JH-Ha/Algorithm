import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String[] spt = s.split(" ");
        int v = Integer.parseInt(spt[0]);
        int e = Integer.parseInt(spt[1]);

        int[][] dist = new int[v + 1][v + 1];
        int MAX_DIST = 1000000000;
        for (int i = 0; i <= v; i++) {
            for (int j = 0; j <= v; j++) {
                dist[i][j] = MAX_DIST;
            }
        }
        for (int i = 0; i < e; i++) {
            s = sc.nextLine();
            int[] intArr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            dist[intArr[0]][intArr[1]] = intArr[2];
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int minLength = MAX_DIST;
        for (int i = 1; i <= v; i++) {
            if (dist[i][i] < minLength) {
                minLength = dist[i][i];
            }
        }
        if (minLength == MAX_DIST) {
            System.out.println(-1);
        } else {
            System.out.println(minLength);
        }

    }
}
