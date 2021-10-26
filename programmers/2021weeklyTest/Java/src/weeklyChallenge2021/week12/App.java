package weeklyChallenge2021.week12;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<String> visited = new HashSet<>();
    int answer = 0;
    public String makeKey(int[] d){
        return d[0] + "&" + d[1];
    }
    public void solve(int k, int[][] dungeons, int depth){
        int n = dungeons.length;
        answer = Math.max(depth, answer);
        for(int i = 0; i < n; i ++){
            int[] d = dungeons[i];
            String key = makeKey(d);
            if(!visited.contains(key) && k >= d[0]){
                visited.add(key);
                solve(k - d[1], dungeons, depth + 1);
                visited.remove(key);
            }
        }
    }
    public int solution(int k, int[][] dungeons) {
        solve(k, dungeons, 0);
        return answer;
    }
}

public class App {
 public static void main(String[] args) {
     Solution solution = new Solution();
     int k = 80;
     int[][] dungeons = {{80,20},{50,40},{30,10}};
     System.out.println(solution.solution(k, dungeons));
 }   
}
