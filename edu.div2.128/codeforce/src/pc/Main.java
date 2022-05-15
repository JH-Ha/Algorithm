package pc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Integer t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> input = Arrays.stream(sc.nextLine().split("")).map(str -> Integer.parseInt(str))
                    .collect(Collectors.toList());
            int n = input.size();
            long numOnes = input.stream().reduce((x, y) -> x + y).get();
            long numZeros = n - numOnes;
            // save the number of removed zeros when remove i number of one from begin
            List<Long> removedZerosFromFirst = new ArrayList<>();
            // save the number of removed zeros when remove i number of one from end
            List<Long> removedZerosFromLast = new ArrayList<>();
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                if (input.get(i) == 0) {
                    cnt++;
                } else {
                    removedZerosFromFirst.add(cnt);
                }
            }
            removedZerosFromFirst.add(cnt);
            cnt = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (input.get(i) == 0) {
                    cnt++;
                } else {
                    removedZerosFromLast.add(cnt);
                }
            }
            removedZerosFromLast.add(cnt);
            long l = 0;
            long r = numOnes;
            long ans = 0;
            while (l <= r) {
                long mid = (l + r) / 2;
                boolean isPossible = false;
                for (int i = 0; i <= mid; i++) {
                    long leftZeros = numZeros;
                    leftZeros -= removedZerosFromFirst.get(i);
                    leftZeros -= removedZerosFromLast.get((int) mid - i);
                    if (leftZeros <= mid) {
                        isPossible = true;
                        break;
                    }
                }
                if (isPossible) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            System.out.println(ans);
        }
        sc.close();
    }
}
