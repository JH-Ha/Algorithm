import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
    long num;
    long depth;

    public Pair(long num, long depth) {
        this.num = num;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] spt = line.split(" ");
        long start = Long.parseLong(spt[0]);
        long end = Long.parseLong(spt[1]);

        Pair pair = new Pair(start, 1);
        Queue<Pair> q = new LinkedList<>();
        q.add(pair);
        long ans = -1;
        while (!q.isEmpty()) {
            Pair front = q.poll();
            if (front.num == end) {
                ans = front.depth;
                break;
            } else if (front.num < end) {
                q.add(new Pair(front.num * 2, front.depth + 1));
                q.add(new Pair(front.num * 10 + 1, front.depth + 1));
            }
        }
        System.out.println(ans);
        sc.close();

    }
}
