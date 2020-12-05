public class Network {
    class Solution {
        public boolean[] visited;
        public int node[][];

        public void dfs(int n, int start) {

            for (int i = 0; i < n; i++) {
                if (node[start][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(n, i);

                }
            }
        }

        public int solution(int n, int[][] computers) {

            int ans = 0;
            node = computers;
            visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                visited[i] = false;
            }
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(n, i);
                    ans++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Network network = new Network();
        Solution solution = network.new Solution();
        int[][] computers = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

        System.out.println(solution.solution(3, computers));
    }
}
