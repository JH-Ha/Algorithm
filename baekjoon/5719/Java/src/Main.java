import java.util.*;

class Node {
    List<Pair> childList;
    int id;

    public Node(int id) {
        this.id = id;
        this.childList = new ArrayList<>();
    }
}

class Pair {
    int id;
    int weight;

    public Pair(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }
}

public class Main {
    public static int[] dij(int n, int s, Node[] nodeArr, List<Integer>[] trace) {
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = 100000000;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> {
            return a.weight - b.weight;
        });
        distance[s] = 0;
        pq.add(new Pair(s, 0));

        for (int i = 0; i < n; i++) {
            trace[i] = new ArrayList<>();
        }
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            List<Pair> childList = nodeArr[top.id].childList;

            int curDis = top.weight;

            for (int i = 0; i < childList.size(); i++) {
                Pair child = childList.get(i);
                if (child.weight == -1) {
                    continue;
                }
                int newDis = curDis + child.weight;
                if (newDis < distance[child.id]) {
                    distance[child.id] = newDis;
                    pq.add(new Pair(child.id, distance[child.id]));
                    trace[child.id].clear();
                    trace[child.id].add(top.id);
                } else if (newDis == distance[child.id]) {
                    trace[child.id].add(top.id);
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String line = sc.nextLine();
            if (line.startsWith("0 0")) {
                break;
            }
            String[] spt = line.split(" ");

            int n = Integer.parseInt(spt[0]);
            int m = Integer.parseInt(spt[1]);

            line = sc.nextLine();
            spt = line.split(" ");
            int s = Integer.parseInt(spt[0]);
            int d = Integer.parseInt(spt[1]);

            Node[] nodeArr = new Node[n];
            for (int i = 0; i < n; i++) {
                nodeArr[i] = new Node(i);
            }
            for (int i = 0; i < m; i++) {
                line = sc.nextLine();
                spt = line.split(" ");
                int l = Integer.parseInt(spt[0]);
                int r = Integer.parseInt(spt[1]);
                int w = Integer.parseInt(spt[2]);
                nodeArr[l].childList.add(new Pair(r, w));
            }
            List<Integer>[] trace = new ArrayList[n];
            dij(n, s, nodeArr, trace);
            Queue<Integer> q = new LinkedList<>();
            q.add(d);
            // bfs로 제거
            boolean[] visited = new boolean[n];
            visited[d] = true;
            while (!q.isEmpty()) {
                Integer top = q.poll();
                List<Integer> childList = trace[top];
                for (int i = 0; i < childList.size(); i++) {
                    Integer child = childList.get(i);

                    for (int j = 0; j < nodeArr[child].childList.size(); j++) {
                        if (nodeArr[child].childList.get(j).id == top) {
                            nodeArr[child].childList.get(j).weight = -1;
                        }
                    }
                    if (!visited[child]) {
                        q.add(child);
                        visited[child] = true;
                    }
                }
            }
            int[] distance = dij(n, s, nodeArr, trace);

            if (distance[d] == 100000000) {
                System.out.println(-1);
            } else
                System.out.println(distance[d]);

        }
        sc.close();
    }
}
