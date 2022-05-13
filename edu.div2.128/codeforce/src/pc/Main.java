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
            
        
        }
    }
}
