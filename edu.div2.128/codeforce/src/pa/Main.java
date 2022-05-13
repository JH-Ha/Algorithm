package pa;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < n; i++){
            List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
            Integer l1 = input.get(0);
            Integer r1 = input.get(1);
            Integer l2 = input.get(2);
            Integer r2 = input.get(3);
            //System.out.println(l1 + " " + r1 + " " + l2 + " " + r2);

            if(l1 > l2){
                int temp = l1;
                l1 = l2;
                l2 = temp;
                temp = r1;
                r1 = r2;
                r2 = temp;
            }
            int ans = 0;
            if( l1 <= l2 && l2 <= r1){
                ans = l2;
            }else if(r1 < l2){
                ans = l1 + l2;
            }
            //System.out.println(l1 + " " + r1 + " " + l2 + " " + r2);
            
            System.out.println(ans);
            
        }
    }
}
