import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Day3 {
    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p3Input.txt");

        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;

            ArrayList<ArrayList<Integer>> map = new ArrayList<>();
            int curX = 0;
            int curY = 0;
            int[] dx = { 1, 3, 5, 7, 1 };
            int[] dy = { 1, 1, 1, 1, 2 };
            while ((line = br.readLine()) != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '.') {
                        arrayList.add(0);
                    } else {
                        arrayList.add(1);
                    }
                }
                map.add(arrayList);
            }
            long ans = 0;
            long mulAns = 1;
            for (int i = 0; i < dx.length; i++) {
                ans = 0;
                curX = 0;
                curY = 0;
                while (curY < map.size()) {
                    if (map.get(curY).get(curX) == 1) {
                        ans++;
                    }
                    curY += dy[i];
                    curX += dx[i];
                    curX %= map.get(0).size();
                }
                mulAns *= ans;
            }
            System.out.println(mulAns);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
