import java.util.PriorityQueue;
import java.util.Scanner;

class Ans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        String answer = "";
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (num == 0) {
                if (q.size() == 0) {
                    answer += "0\n";
                } else {
                    answer += (q.poll() + "\n");
                }
            } else {
                q.add(num);
            }
        }
        System.out.print(answer);
    }
}