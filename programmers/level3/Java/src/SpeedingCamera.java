import java.util.Arrays;

public class SpeedingCamera {
    class Solution {
        public int solution(int[][] routes) {
            int answer = 1;

            Arrays.sort(routes, (a, b) -> {
                return a[0] - b[0];
            });

            int cameraPos = routes[0][1];
            for (int i = 1; i < routes.length; i++) {
                if (cameraPos > routes[i][1]) {
                    cameraPos = routes[i][1];
                }
                if (cameraPos < routes[i][0]) {
                    cameraPos = routes[i][1];
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = (new SpeedingCamera()).new Solution();
        int[][] routes = { { -20, 15 }, { -14, -5 }, { -18, -13 }, { -5, -3 }, };
        System.out.println(solution.solution(routes));
    }
}
