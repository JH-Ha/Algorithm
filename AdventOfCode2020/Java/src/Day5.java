import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class Day5 {
    public static int findNum(String s, int start, int end) {
        if (start == end) {
            return start;
        } else if (s.charAt(0) == 'F' || s.charAt(0) == 'L') {
            return findNum(s.substring(1), start, (start + end) / 2);
        } else {
            return findNum(s.substring(1), (start + end) / 2 + 1, end);
        }

    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p5Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line;
            int ans = -1;
            HashSet<Integer> set = new HashSet<>();
            while ((line = br.readLine()) != null) {
                int row = findNum(line, 0, 127);
                int col = findNum(line.substring(7), 0, 7);
                ans = Math.max(row * 8 + col, ans);
                set.add(row * 8 + col);
            }
            for (int i = 0; i <= ans; i++) {
                if (!set.contains(i)) {
                    System.out.println(i);
                }
            }
            System.out.println(ans);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
