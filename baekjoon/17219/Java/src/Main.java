import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] spt = line.split(" ");
        int n = Integer.parseInt(spt[0]);
        int m = Integer.parseInt(spt[1]);

        Map<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            spt = line.split(" ");
            hashMap.put(spt[0], spt[1]);
        }
        for (int i = 0; i < m; i++) {
            line = sc.nextLine();
            System.out.println(hashMap.get(line));
        }
        sc.close();
    }
}
