import java.util.PriorityQueue;

public class ConnectIsland {
    class Edge implements Comparable<Edge> {
        public int l;
        public int r;
        public int cost;

        public Edge(int l, int r, int cost) {
            this.l = l;
            this.r = r;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.cost < edge.cost) {
                return -1;
            } else if (this.cost == edge.cost) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    class Solution {
        private int[] set;

        public void initSet(int n) {
            this.set = new int[n];
            for (int i = 0; i < n; i++) {
                this.set[i] = i;
            }
        }

        public void union(int a, int b) {
            int pa = findParent(a);
            int pb = findParent(b);
            if (pa < pb) {
                set[pb] = pa;
            } else {
                set[pa] = pb;
            }
        }

        public int findParent(int i) {
            if (set[i] == i)
                return i;
            return findParent(set[i]);
        }

        public int solution(int n, int[][] costs) {
            int answer = 0;

            initSet(n);

            PriorityQueue<Edge> q = new PriorityQueue<>();
            for (int i = 0; i < costs.length; i++) {
                int l = costs[i][0];
                int r = costs[i][1];
                int cost = costs[i][2];

                q.add(new Edge(l, r, cost));
            }

            while (!q.isEmpty()) {
                Edge edge = q.poll();
                if (findParent(edge.l) != findParent(edge.r)) {
                    union(edge.l, edge.r);
                    answer += edge.cost;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        ConnectIsland connectIsland = new ConnectIsland();
        Solution solution = connectIsland.new Solution();
        int n = 4;
        int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3, 8 } };
        System.out.println(solution.solution(n, costs));
    }
}
