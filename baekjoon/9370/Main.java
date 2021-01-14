import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point {
    int id;
    int distance;

    public Point(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }
}

public class Main {
    public static void dij(List<Integer> dp, List<List<Point>> node, int s) {
        dp.set(s, 0);
        PriorityQueue<Point> pq = new PriorityQueue<>((Point a, Point b) -> {
            return a.distance - b.distance;
        });
        pq.add(new Point(s, 0));
        while (!pq.isEmpty()) {
            Point top = pq.poll();
            List<Point> children = node.get(top.id);
            Integer curCost = top.distance;
            for (int i = 0; i < children.size(); i++) {
                Point child = children.get(i);
                Integer childCost = child.distance;
                if (dp.get(child.id) > childCost + curCost) {
                    dp.set(child.id, childCost + curCost);
                    pq.add(new Point(child.id, childCost + curCost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String line = sc.nextLine();
            String[] spt = line.split(" ");
            Integer n = Integer.parseInt(spt[0]);
            Integer m = Integer.parseInt(spt[1]);
            Integer t = Integer.parseInt(spt[2]);
            line = sc.nextLine();
            spt = line.split(" ");
            Integer s = Integer.parseInt(spt[0]);
            Integer g = Integer.parseInt(spt[1]);
            Integer h = Integer.parseInt(spt[2]);

            List<List<Point>> node = new ArrayList<>();
            int ghDistance = 0;
            for (int i = 0; i <= n; i++) {
                node.add(new ArrayList<>());
            }
            for (int i = 0; i < m; i++) {
                line = sc.nextLine();
                spt = line.split(" ");
                int a = Integer.parseInt(spt[0]);
                int b = Integer.parseInt(spt[1]);
                int d = Integer.parseInt(spt[2]);
                if ((a == g && b == h) || (a == h && b == g)) {
                    ghDistance = d;
                    // continue;
                }
                node.get(a).add(new Point(b, d));
                node.get(b).add(new Point(a, d));
            }
            List<Integer> dest = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                line = sc.nextLine();
                dest.add(Integer.parseInt(line));
            }
            Collections.sort(dest);

            List<Integer> dijS = new ArrayList<>();
            List<Integer> dijH = new ArrayList<>();
            List<Integer> dijG = new ArrayList<>();
            Integer MAX_NUM = 2000000000;
            for (int i = 0; i <= n; i++) {
                dijS.add(MAX_NUM);
            }

            dij(dijS, node, s);
            dij(dijH, node, g);
            dij(dijG, node, h);
            String ans = "";
            for (int i = 0; i < t; i++) {
                int destNode = dest.get(i);
                int distance = dijS.get(g) + ghDistance + dijH.get(destNode);
                int distance2 = dijS.get(h) + ghDistance + dijG.get(destNode);
                int minDis = Math.min(distance, distance2);
                if (minDis <= dijS.get(destNode)) {
                    ans += destNode + " ";
                }
            }
            System.out.println(ans);
        }
    }
}
