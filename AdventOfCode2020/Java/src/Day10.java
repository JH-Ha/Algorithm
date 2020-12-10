import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day10 {
    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p10Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            List<Integer> joltageList = new ArrayList<>();
            joltageList.add(0);
            while ((line = br.readLine()) != null) {
                joltageList.add(Integer.parseInt(line));
            }
            Collections.sort(joltageList);
            joltageList.add(joltageList.get(joltageList.size() - 1) + 3);

            int one = 0;
            int three = 0;
            for (int i = 0; i < joltageList.size() - 1; i++) {
                int diff = joltageList.get(i + 1) - joltageList.get(i);
                if (diff == 3) {
                    three++;
                } else if (diff == 1) {
                    one++;
                }
            }
            System.out.println("three : " + three + " one : " + one);
            System.out.println("multi : " + three * one);
            boolean[] canRemove = new boolean[joltageList.size()];
            for (int i = 0; i < canRemove.length; i++) {
                canRemove[i] = true;
            }
            canRemove[0] = false;
            canRemove[joltageList.size() - 1] = false;
            for (int i = 0; i < joltageList.size() - 1; i++) {
                int diff = joltageList.get(i + 1) - joltageList.get(i);

                if (diff == 3) {
                    canRemove[i] = canRemove[i + 1] = false;
                }
            }
            int lenTrue = 0;
            long ans = 1;
            for (int i = 1; i < joltageList.size(); i++) {
                if (canRemove[i]) {
                    lenTrue++;
                } else {
                    System.out.println(lenTrue);
                    if (lenTrue >= 1 && lenTrue <= 2)
                        ans *= Math.pow(2, lenTrue);
                    else if (lenTrue == 3)
                        ans *= 7; // 三連続はできません。8‐1＝7
                    else if (lenTrue == 4)
                        ans *= 13;
                    else if (lenTrue == 5)
                        ans *= 24;
                    lenTrue = 0;
                }
            }
            // 問題２の答え
            System.out.println(ans);
            System.out.println("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
