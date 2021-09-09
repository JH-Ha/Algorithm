package weeklyChallenge2021.thirdWeek;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Tile {
    int height;
    int width;
    int[][] map;
    boolean used = false;

    public Tile(int height, int width, int[][] map) {
        this.width = width;
        this.height = height;
        this.map = map;
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Solution {
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static boolean isValidPoint(int x, int y, int n, int m) {
        boolean result = false;
        if (x >= 0 && x < n && y >= 0 && y < m) {
            result = true;
        }
        return result;
    }

    public static List<Tile> getTiles(int[][] board, int num) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        List<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == num && !visited[i][j]) {
                    Queue<Point> q = new LinkedList<>();
                    visited[i][j] = true;
                    Point start = new Point(i, j);
                    q.add(start);
                    List<Point> visitedList = new ArrayList<>();
                    visitedList.add(start);
                    int minX = i;
                    int maxX = i;
                    int minY = j;
                    int maxY = j;
                    while (!q.isEmpty()) {
                        Point top = q.poll();
                        for (int k = 0; k < 4; k++) {
                            int nx = top.x + dx[k];
                            int ny = top.y + dy[k];
                            if (isValidPoint(nx, ny, n, m) && !visited[nx][ny] && board[nx][ny] == num) {
                                Point nPoint = new Point(nx, ny);
                                q.add(nPoint);
                                visited[nx][ny] = true;
                                visitedList.add(nPoint);
                                minX = Math.min(minX, nx);
                                maxX = Math.max(maxX, nx);
                                minY = Math.min(minY, ny);
                                maxY = Math.max(maxY, ny);
                            }
                        }
                    }
                    int tileX = maxX - minX + 1;
                    int tileY = maxY - minY + 1;
                    int[][] map = new int[tileX][tileY];
                    for (int k = 0; k < visitedList.size(); k++) {
                        Point visitedPoint = visitedList.get(k);
                        map[visitedPoint.x - minX][visitedPoint.y - minY] = 1;
                    }
                    Tile tile = new Tile(tileX, tileY, map);
                    tiles.add(tile);
                }
            }
        }
        tiles.stream().forEach(a -> {
            for (int i = 0; i < a.map.length; i++) {
                for (int j = 0; j < a.map[0].length; j++) {
                    System.out.print(a.map[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        });
        return tiles;
    }

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        List<Tile> emptyTiles = getTiles(game_board, 0);
        List<Tile> tiles = getTiles(table, 1);
        for (int i = 0; i < emptyTiles.size(); i++) {
            Tile emptyTile = emptyTiles.get(i);
            for (int j = 0; j < tiles.size(); j++) {
                Tile tile = tiles.get(j);

                // 정방향
                if (!tile.used && (emptyTile.width == tile.width && emptyTile.height == tile.height)) {
                    boolean isSameSize = true;
                    int sum = 0;
                    for (int x = 0; x < emptyTile.height; x++) {
                        for (int y = 0; y < emptyTile.width; y++) {
                            if (tile.map[x][y] != emptyTile.map[x][y]) {
                                isSameSize = false;
                                break;
                            }
                            sum += tile.map[x][y] * emptyTile.map[x][y];
                        }
                        if (!isSameSize)
                            break;
                    }
                    if (isSameSize) {
                        answer += sum;
                        tile.used = true;
                        emptyTile.used = true;
                    }
                }
                // 90도 회전
                if (!tile.used && !emptyTile.used
                        && (emptyTile.width == tile.height && emptyTile.height == tile.width)) {
                    boolean isSameSize = true;
                    int sum = 0;
                    for (int x = 0; x < emptyTile.height; x++) {
                        for (int y = 0; y < emptyTile.width; y++) {
                            if (emptyTile.map[x][y] != tile.map[emptyTile.width - 1 - y][x]) {
                                isSameSize = false;
                                break;
                            }
                            sum += emptyTile.map[x][y] * tile.map[emptyTile.width - 1 - y][x];
                        }
                        if (!isSameSize)
                            break;
                    }
                    if (isSameSize) {
                        answer += sum;
                        tile.used = true;
                        emptyTile.used = true;
                    }
                }
                // 180도 회전
                if (!tile.used && !emptyTile.used
                        && (emptyTile.width == tile.width && emptyTile.height == tile.height)) {
                    boolean isSameSize = true;
                    int sum = 0;
                    for (int x = 0; x < emptyTile.height; x++) {
                        for (int y = 0; y < emptyTile.width; y++) {
                            if (emptyTile.map[x][y] != tile.map[emptyTile.height - 1 - x][emptyTile.width - 1 - y]) {
                                isSameSize = false;
                                break;
                            }
                            sum += emptyTile.map[x][y] * tile.map[emptyTile.height - 1 - x][emptyTile.width - 1 - y];
                        }
                        if (!isSameSize)
                            break;
                    }
                    if (isSameSize) {
                        answer += sum;
                        tile.used = true;
                        emptyTile.used = true;
                    }
                }
                // 270도
                if (!tile.used && !emptyTile.used
                        && (emptyTile.width == tile.height && emptyTile.height == tile.width)) {
                    boolean isSameSize = true;
                    int sum = 0;
                    for (int x = 0; x < emptyTile.height; x++) {
                        for (int y = 0; y < emptyTile.width; y++) {
                            if (emptyTile.map[x][y] != tile.map[emptyTile.width - 1 - y][x]) {
                                isSameSize = false;
                                break;
                            }
                            sum += emptyTile.map[x][y] * tile.map[emptyTile.width - 1 - y][x];
                        }
                        if (!isSameSize)
                            break;
                    }
                    if (isSameSize) {
                        answer += sum;
                        tile.used = true;
                        emptyTile.used = true;
                    }
                }
                if (tile.used) {
                    // emptyTile.used = true;
                }
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args)

    {
        Solution solution = new Solution();
        int[][] game_board = { { 1, 1, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1 }, { 1, 1, 0, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 1, 0, 0 } };
        int[][] table = { { 1, 0, 0, 1, 1, 0 }, { 1, 0, 1, 0, 1, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0, 0 } };

        // System.out.println(solution.solution(game_board, table));

        int[][] game_board2 = { { 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0 }, { 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
                { 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }, { 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0 }, { 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0 },
                { 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0 } };

        int[][] table2 = { { 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1 }, { 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1 },
                { 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
                { 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1 }, { 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1 },
                { 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1 } };
        System.out.println(solution.solution(game_board2, table2));
    }
}