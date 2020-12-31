package B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static Integer getDiff(String s1, String s2) {
        int n = s1.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t;
        t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            List<String> sList = null;
            String s = sc.nextLine();
            String[] spt = s.split(" ");
            Map<String, Integer> map = new HashMap<>();
            // sList = Arrays.asList(spt);

            // Collections.sort(sList);
            int ans = 100;
            for (int i = 0; i < n; i++) {
                Integer num = map.get(spt[i]);
                if (num == null) {
                    map.put(spt[i], 1);
                } else {
                    map.put(spt[i], num + 1);
                }
            }

            // Set<String> used = new HashSet<>();

            for (String key1 : map.keySet()) {
                Integer num1 = map.get(key1);
                map.put(key1, num1 - 1);
                for (String key2 : map.keySet()) {
                    Integer num2 = map.get(key2);
                    if (num2 > 0) {
                        map.put(key2, num2 - 1);
                        for (String key3 : map.keySet()) {
                            Integer num3 = map.get(key3);
                            if (num3 > 0) {
                                ans = Math.min(ans, getDiff(key1, key2) + getDiff(key2, key3) + getDiff(key1, key3));
                            }
                        }
                        map.put(key2, num2);
                    }
                }

                map.put(key1, num1);
            }
            System.out.println(ans);
        }
    }
}
