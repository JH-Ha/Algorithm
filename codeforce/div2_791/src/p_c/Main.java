package p_c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input1 = Arrays.stream((bf.readLine().split(" "))).map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = input1.get(0);
        int q = input1.get(1);

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        StringBuffer answer = new StringBuffer();
        while (q-- > 0) {
            List<Integer> query = Arrays.stream((bf.readLine().split(" "))).map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (query.get(0) == 1) {
                int x = query.get(1);
                int y = query.get(2);
                xMap.put(x, xMap.getOrDefault(x, 0) + 1);
                yMap.put(y, yMap.getOrDefault(y, 0) + 1);
            } else if (query.get(0) == 2) {
                int x = query.get(1);
                int y = query.get(2);
                xMap.put(x, xMap.get(x) - 1);
                yMap.put(y, yMap.get(y) - 1);
            } else if (query.get(0) == 3) {
                int x1 = query.get(1);
                int y1 = query.get(2);
                int x2 = query.get(3);
                int y2 = query.get(4);
                boolean xAttacked = true;
                for (int i = x1; i <= x2; i++) {
                    if (xMap.getOrDefault(i, 0) == 0) {
                        xAttacked = false;
                        break;
                    }
                }
                boolean yAttacked = true;
                for (int i = y1; i <= y2; i++) {
                    if (yMap.getOrDefault(i, 0) == 0) {
                        yAttacked = false;
                        break;
                    }
                }
                if (xAttacked || yAttacked) {
                    answer.append("Yes").append("\n");
                } else {
                    answer.append("No").append("\n");
                }

            }

        }
        System.out.println(answer.toString());
    }
}
