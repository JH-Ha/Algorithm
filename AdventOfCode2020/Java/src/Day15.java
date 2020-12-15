import java.util.HashMap;
import java.util.Map;

public class Day15 {
    public static void main(String[] args) {
        int[] input = { 9, 19, 1, 6, 0, 5, 4 };
        // int[] input = { 0, 3, 6 };
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= input.length; i++) {
            map.put(input[i - 1], i);
        }
        int last = 0;
        for (int i = input.length; i <= 30000000 - 2; i++) {
            if (map.get(last) == null) {
                map.put(last, i + 1);
                last = 0;
            } else {
                int lastPos = map.get(last);
                map.put(last, i + 1);
                last = i + 1 - lastPos;
                // map.put(last, i + 1);
            }
            // System.out.println(last);
        }
        System.out.println(last);
    }
}
