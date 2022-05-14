package p_a;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Long input = Long.parseLong(sc.nextLine());
            if (input % 2 == 1 || input < 4) {
                System.out.println(-1);
                continue;
            }
            Long min = 0L;
            Long max = 0L;
            if (input % 4 == 0) {
                max = input / 4;
            } else {
                max = (input - 6) / 4 + 1;
            }
            if (input % 6 == 0) {
                min = input / 6;
            } else if (input % 6 == 2) {
                min = (input - 8) / 6 + 2;
            } else {
                min = (input - 4) / 6 + 1;
            }
            System.out.println(min + " " + max);
        }
    }
}
