import java.util.*;

class Node {
    int id;
    double x;
    double y;

    public Node(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}

class Edge {
    Double weight;
    int l;
    int r;

    public Edge(int l, int r, Double weight) {
        this.l = l;
        this.r = r;
        this.weight = weight;
    }
}

public class Main {
    static int[] set;

    public static int findParent(int a) {
        if (set[a] == a)
            return a;
        set[a] = findParent(set[a]);
        return set[a];
    }

    public static void union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        if (pa != pb) {
            set[pa] = pb;
        }
    }

    public static boolean hasSameParent(int a, int b) {
        boolean result = true;
        if (findParent(a) != findParent(b))
            result = false;
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int n = Integer.parseInt(line);
        set = new int[n];
        for (int i = 0; i < n; i++) {
            set[i] = i;
        }
        Node[] nodeArr = new Node[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> {
            if (a.weight - b.weight > 0) {
                return 1;
            } else if (a.weight - b.weight < 0) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            String[] spt = line.split(" ");
            Double x = Double.parseDouble(spt[0]);
            Double y = Double.parseDouble(spt[1]);
            nodeArr[i] = new Node(i, x, y);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double diffX = (nodeArr[i].x - nodeArr[j].x);
                double diffY = (nodeArr[i].y - nodeArr[j].y);
                pq.add(new Edge(i, j, diffX * diffX + diffY * diffY));
            }
        }
        Double ans = 0D;
        while (!pq.isEmpty()) {
            Edge top = pq.poll();
            int l = top.l;
            int r = top.r;
            if (!hasSameParent(l, r)) {
                ans += Math.sqrt(top.weight);
                union(l, r);
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
