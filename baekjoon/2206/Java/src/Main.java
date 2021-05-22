import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    boolean useBreak;
    int x;
    int y;
    int depth;

    public Point(int x, int y, int depth, boolean useBreak) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.useBreak = useBreak;
    }
}

public class Main {

    public static boolean isValidPos(int x, int y, int n, int m) {
        if (x >= 0 && x < n && y >= 0 && y < m) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] spt = line.split(" ");
        int n = Integer.parseInt(spt[0]);
        int m = Integer.parseInt(spt[1]);

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '1') {
                    map[i][j] = 1;
                }
            }
        }
        boolean[][][] visited = new boolean[n][m][2];

        Queue<Point> q = new LinkedList<>();

        q.add(new Point(0, 0, 1, false));
        visited[0][0][0] = true;
        int ans = n * m;

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            Point front = q.poll();
            if (front.x == n - 1 && front.y == m - 1) {
                ans = Math.min(front.depth, ans);
            }
            for (int i = 0; i < 4; i++) {
                int nx = front.x + dx[i];
                int ny = front.y + dy[i];
                if (isValidPos(nx, ny, n, m)) {
                    if (front.useBreak && map[nx][ny] == 0 && !visited[nx][ny][1]) {
                        q.add(new Point(nx, ny, front.depth + 1, front.useBreak));
                        visited[nx][ny][1] = true;
                    }
                    if (!front.useBreak && map[nx][ny] == 1 && !visited[nx][ny][0]) {
                        q.add(new Point(nx, ny, front.depth + 1, true));
                        visited[nx][ny][1] = true;
                    }
                    if (!front.useBreak && map[nx][ny] == 0 && !visited[nx][ny][0]) {
                        q.add(new Point(nx, ny, front.depth + 1, front.useBreak));
                        visited[nx][ny][0] = true;
                    }
                }
            }
        }
        if (ans != 1 && ans == n * m) {
            ans = -1;
        }
        System.out.println(ans);
        sc.close();
    }
}
