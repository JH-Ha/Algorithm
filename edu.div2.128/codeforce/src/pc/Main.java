package pc;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            List<Integer> input = Arrays.stream(sc.nextLine().split("")).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
            int n = input.size();
            int[] acc = new int[n + 1];
            int sum = 0;
            for(int i = 0; i < n; i ++ ){
                int s = input.get(i);
                acc[i + 1] = acc[i] + s;
                sum += s;
            }
            int ans = n;
            int l = 0;
            int r = n - 1;
            int removedOne = 0;
            int leftZero = n - sum;
            while (l <= r){
                if(leftZero == removedOne){
                    ans = Math.min(ans, Math.max(leftZero, removedOne));
                    break;
                }
                if(input.get(l) == 0){
                    leftZero --;
                    l ++;
                }else if(input.get(r) == 0){
                    leftZero --;
                    r --;
                }else if(l < (n - 1) && input.get(l) == 1 && input.get(l + 1) == 0){
                    removedOne ++;
                    leftZero --;
                    l += 2;
                }else if (r > 0 && input.get(r) == 1 && input.get(r - 1 ) == 0){
                    removedOne ++;
                    leftZero --;
                    r -= 2;
                } else if (input.get(l) == 1){
                    removedOne ++;
                    l ++;
                } else {
                    removedOne ++;
                    r --;
                }
                ans = Math.min(ans, Math.max(leftZero, removedOne));
            }
            System.out.println(ans);
        }
    }
}
