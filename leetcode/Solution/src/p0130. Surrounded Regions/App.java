package p0130;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { 1, 0, -1, 0 };

    public boolean isValidIndex(char[][] board, int x, int y) {
        int n = board.length;
        int m = board[0].length;
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }

    public void bfs(char[][] board, boolean[][] visited, int i, int j) {
        if (!visited[i][j] && board[i][j] == 'O') {
            LinkedList<Pair> q = new LinkedList<>();
            q.addLast(new Pair(i, j));
            visited[i][j] = true;
            while (!q.isEmpty()) {
                Pair first = q.removeFirst();
                for (int d = 0; d < 4; d++) {
                    int nx = first.x + dx[d];
                    int ny = first.y + dy[d];

                    if (isValidIndex(board, nx, ny) && board[nx][ny] == 'O' && !visited[nx][ny]) {
                        // System.out.println("x: " + first.x + " y: " + first.y + " nx: " + nx + " ny:
                        // " + ny);System.out.println("nx" + nx + "ny" + ny);
                        visited[nx][ny] = true;
                        q.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        // left border
        for (int i = 0; i < n; i++) {
            bfs(board, visited, i, 0);
        }
        // top border

        for (int j = 0; j < m; j++) {
            bfs(board, visited, 0, j);
        }
        // right border

        for (int i = 0; i < n; i++) {
            bfs(board, visited, i, m - 1);
        }
        // bottom border
        for (int j = 0; j < m; j++) {
            bfs(board, visited, n - 1, j);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}