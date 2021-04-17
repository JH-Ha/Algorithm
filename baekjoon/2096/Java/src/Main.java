import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        Integer n = Integer.parseInt(line);
        int[][] map = new int[n][3];
        int[][] dpMax = new int[n][3];
        int[][] dpMin = new int[n][3];
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            String[] spt = line.split(" ");
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(spt[j]);
                dpMax[i][j] = -1;
                dpMin[i][j] = 9 * n + 1;
            }
        }

        int[][] upIdx = { { 0, 1 }, { 0, 1, 2 }, { 1, 2 } };
        for (int j = 0; j < 3; j++) {
            dpMax[0][j] = map[0][j];
            dpMin[0][j] = map[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < upIdx[j].length; k++) {
                    dpMax[i][j] = Math.max(dpMax[i - 1][upIdx[j][k]], dpMax[i][j]);
                    dpMin[i][j] = Math.min(dpMin[i - 1][upIdx[j][k]], dpMin[i][j]);
                }
                dpMax[i][j] += map[i][j];
                dpMin[i][j] += map[i][j];
            }
        }
        Integer maxNum = dpMax[n - 1][0];
        Integer minNum = dpMin[n - 1][0];
        for (int j = 0; j < 3; j++) {
            maxNum = Math.max(dpMax[n - 1][j], maxNum);
            minNum = Math.min(dpMin[n - 1][j], minNum);
        }
        System.out.println(maxNum + " " + minNum);

        sc.close();
    }
}
