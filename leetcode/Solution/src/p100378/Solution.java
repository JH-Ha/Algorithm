package p100378;

import java.util.*;

class Pair<T, Q> {
    T left;
    Q right;

    public Pair(T left, Q right) {
        this.left = left;
        this.right = right;
    }
}

class neighborSum {

    Map<Integer, Pair<Integer, Integer>> posMap = new HashMap<>();;
    int grid[][];
    int n;

    public neighborSum(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                posMap.put(grid[i][j], new Pair(i, j));
            }
        }
    }

    int[][] adjPos = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    int[][] diagPos = { { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

    boolean isValidPos(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public int adjacentSum(int value) {
        Pair<Integer, Integer> pos = posMap.get(value);

        int answer = 0;
        for (int i = 0; i < adjPos.length; i++) {
            int x = pos.left + adjPos[i][0];
            int y = pos.right + adjPos[i][1];
            if (isValidPos(x, y, n)) {
                answer += grid[x][y];
            }
        }
        return answer;
    }

    public int diagonalSum(int value) {
        Pair<Integer, Integer> pos = posMap.get(value);

        int answer = 0;
        for (int i = 0; i < diagPos.length; i++) {
            int x = pos.left + diagPos[i][0];
            int y = pos.right + diagPos[i][1];
            if (isValidPos(x, y, n)) {
                answer += grid[x][y];
            }
        }
        return answer;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */