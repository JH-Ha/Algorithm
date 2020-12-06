import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;

public class Day6 {
    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p6Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            // HashSet<Integer> set = new HashSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            int answer = 0;
            int numPeople = 0;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                if (line.equals("")) {
                    // answer += set.size();
                    // set.clear();
                    for (Integer key : map.keySet()) {
                        if (map.get(key) == numPeople) {
                            answer++;
                        }
                    }
                    map.clear();
                    numPeople = 0;
                } else {
                    numPeople++;
                    for (int i = 0; i < line.length(); i++) {
                        // set.add((int) line.charAt(i));
                        Integer cnt = map.get((int) line.charAt(i));
                        if (cnt == null) {
                            map.put((int) line.charAt(i), 1);
                        } else {
                            map.put((int) line.charAt(i), cnt + 1);
                        }
                    }
                }
            }
            // answer += set.size();
            for (Integer key : map.keySet()) {
                if (map.get(key) == numPeople) {
                    answer++;
                }
            }
            System.out.println(answer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
