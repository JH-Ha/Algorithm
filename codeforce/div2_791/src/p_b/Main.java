package p_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input1 = Arrays.stream((bf.readLine().split(" "))).map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = input1.get(0);
        int q = input1.get(1);
        List<Integer> input = Arrays.stream((bf.readLine().split(" "))).map(Integer::parseInt)
                .collect(Collectors.toList());
        long sum = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            map.put(i + 1, input.get(i));
            sum += input.get(i);
        }
        Set<Integer> changed = new HashSet<>();
        long lastTwoNum = -1;
        StringBuffer answer = new StringBuffer();
        for (int i = 0; i < q; i++) {
            List<Integer> query = Arrays.stream((bf.readLine().split(" "))).map(Integer::parseInt)
                    .collect(Collectors.toList());
            if (query.get(0) == 1) {
                if (lastTwoNum == -1) {
                    int before = map.get(query.get(1));
                    int after = query.get(2);
                    map.put(query.get(1), after);
                    sum += after - before;
                } else {
                    if (changed.contains(query.get(1))) {
                        int before = map.get(query.get(1));
                        int after = query.get(2);
                        map.put(query.get(1), after);
                        sum += after - before;
                    } else {
                        long before = lastTwoNum;
                        int after = query.get(2);
                        map.put(query.get(1), after);
                        sum += after - before;
                        changed.add(query.get(1));
                    }
                }
            } else if (query.get(0) == 2) {
                changed = new HashSet<>();
                lastTwoNum = query.get(1);
                sum = n * lastTwoNum;
            }
            answer.append(sum).append("\n");
        }
        System.out.println(answer.toString());
    }
}
