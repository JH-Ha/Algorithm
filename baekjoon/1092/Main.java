import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> crainList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int crain = sc.nextInt();
            crainList.add(crain);
        }

        List<Integer> weightList = new ArrayList<>();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int weight = sc.nextInt();
            weightList.add(weight);
        }
        weightList.sort((int a, int b) -> a - b);
        weightList.stream().forEach(a -> {
            System.out.println(a);
        });
    }
}