package weeklyChallenge2021.week10;

import java.util.ArrayList;
import java.util.List;

class Point {
    long x;
    long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        int n = line.length;
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long a = line[i][0];
                long b = line[i][1];
                long e = line[i][2];
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];
                long adbc = a * d - b * c;
                if (adbc == 0) {
                    continue;
                }
                long bfed = b * f - e * d;
                if (bfed % adbc != 0) {
                    continue;
                }
                long ecaf = e * c - a * f;
                if (ecaf % adbc != 0) {
                    continue;
                }
                long x = bfed / adbc;
                long y = ecaf / adbc;
                points.add(new Point(x, y));
            }
        }
        long minX = points.get(0).x;
        long minY = points.get(0).y;
        long maxX = points.get(0).x;
        long maxY = points.get(0).y;

        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
        }
        long width = maxX - minX + 1;
        long height = maxY - minY + 1;
        StringBuilder sb = new StringBuilder();
        answer = new String[(int) height];
        for (int i = 0; i < width; i++) {
            sb.append(".");
        }
        for (int i = 0; i < height; i++) {
            answer[i] = sb.toString();
        }
        for (int k = 0; k < points.size(); k++) {
            Point p = points.get(k);
            long j = p.x - minX;
            long i = maxY - p.y;
            answer[(int) i] = answer[(int) i].substring(0, (int) j) + "*" + answer[(int) i].substring((int) (j + 1));
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] line = { { 2, -1, 4 }, { -2, -1, 4 }, { 0, -1, 1 }, { 5, -8, -12 }, { 5, 8, 12 } };
        String[] answer = solution.solution(line);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
