import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };
    static int answer = 0;
    static int r;
    static int c;

    public static boolean isValid(int r, int c, int x, int y) {
        boolean result = false;
        if (x >= 0 && x < r && y >= 0 && y < c) {
            result = true;
        }
        return result;
    }

    public static void find(Set<String> set, int x, int y, String[][] map, boolean[][] visited, int depth) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (isValid(r, c, nextX, nextY) && !visited[nextX][nextY] && !set.contains(map[nextX][nextY])) {
                set.add(map[nextX][nextY]);
                visited[nextX][nextY] = true;
                find(set, nextX, nextY, map, visited, depth + 1);
                visited[nextX][nextY] = false;
                set.remove(map[nextX][nextY]);
            }
        }
        answer = Math.max(depth, answer);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        String[] spt = line.split(" ");
        r = Integer.parseInt(spt[0]);
        c = Integer.parseInt(spt[1]);
        String[][] map = new String[r][c];
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            line = sc.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = Character.toString(line.charAt(j));
                visited[i][j] = false;
            }
        }
        Set<String> set = new HashSet<>();
        visited[0][0] = true;
        set.add(map[0][0]);
        find(set, 0, 0, map, visited, 1);
        System.out.println(answer);
    }
}
