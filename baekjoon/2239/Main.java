import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int[][] sudoku;
    static boolean end;

    public static void solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (check(i, j, k)) {
                            sudoku[i][j] = k;
                            solve();
                            if (end)
                                return;
                            sudoku[i][j] = 0;

                        }
                    }
                    return;
                }
            }
        }
        end = true;
        return;
    }

    public static boolean check(int x, int y, int k) {
        int baseX = x / 3 * 3;
        int baseY = y / 3 * 3;
        for (int i = baseX; i < baseX + 3; i++) {
            for (int j = baseY; j < baseY + 3; j++) {
                if (sudoku[i][j] == k)
                    return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == k)
                return false;
        }
        for (int j = 0; j < 9; j++) {
            if (sudoku[x][j] == k)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sudoku = new int[9][9];
        end = false;
        try {
            for (int i = 0; i < 9; i++) {
                String line = (br.readLine());
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = line.charAt(j) - '0';
                }
            }

            solve();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(Integer.toString(sudoku[i][j]));
                }
                bw.write('\n');
            }
            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
