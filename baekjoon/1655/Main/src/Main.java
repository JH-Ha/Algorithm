import java.util.*;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>();
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int input;
            input = sc.nextInt();
            if (minPq.isEmpty()) {
                minPq.add(-input);
            } else if (maxPq.size() < minPq.size()) {
                maxPq.add(input);
            } else {
                minPq.add(-input);
            }

            if (i == 0) {
                System.out.println(-minPq.peek());
                continue;
            } else if (-minPq.peek() > maxPq.peek()) {
                int a = -minPq.poll();
                int b = maxPq.poll();
                minPq.add(-b);
                maxPq.add(a);

            }
            if (maxPq.size() < minPq.size()) {
                System.out.println(-minPq.peek());
            } else {
                if (-minPq.peek() < maxPq.peek()) {
                    System.out.println(-minPq.peek());
                } else {
                    System.out.println(maxPq.peek());
                }
            }
        }
        sc.close();
    }
}
