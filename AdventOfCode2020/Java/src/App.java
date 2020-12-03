import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class App {
    public static void main(String[] args) throws Exception {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p2Input.txt");

        int ans = 0;
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String[] spt = line.split(" ");
                int hypen = spt[0].indexOf('-');
                int minNum = Integer.parseInt(spt[0].substring(0, hypen));
                int maxNum = Integer.parseInt(spt[0].substring(hypen + 1));
                char ch = spt[1].charAt(0);

                // number 1
                // int matched = 0;
                // for (int i = 0; i < spt[2].length(); i++) {
                // if (spt[2].charAt(i) == ch) {
                // matched++;
                // }
                // }
                // if (minNum <= matched && matched <= maxNum) {
                // ans++;
                // }
                // System.out.println(line + "minNum : " + minNum + " maxNum : " + maxNum + "
                // matched : " + matched);

                if (spt[2].charAt(minNum - 1) == ch ^ spt[2].charAt(maxNum - 1) == ch) {
                    ans++;
                }
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
