import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine()); // Int

        String s = bf.readLine();

        List<Integer> crainList = Arrays.asList(s.split(" ")).stream().map(a -> Integer.parseInt(a))
                .collect(Collectors.toList());

        int m = Integer.parseInt(bf.readLine()); // Int
        s = bf.readLine();
        List<Integer> weightList = Arrays.asList(s.split(" ")).stream().map(a -> Integer.parseInt(a))
                .collect(Collectors.toList());

        Collections.sort(crainList, Collections.reverseOrder());

        weightList.sort((Integer a, Integer b) -> b - a);

        if (crainList.get(0) < weightList.get(0)) {
            System.out.println(-1);
            return;
        }
        int numMoved = 0;
        int time = 0;
        while (numMoved < m) {
            int crainIdx = 0;
            int weightIdx = 0;
            while (crainIdx < n && weightIdx < weightList.size()) {
                if (crainList.get(crainIdx) >= weightList.get(weightIdx)) {
                    weightList.remove(weightIdx);
                    numMoved++;
                    crainIdx++;
                } else {
                    weightIdx++;
                }
            }
            time++;
        }
        System.out.println(time);
    }

}