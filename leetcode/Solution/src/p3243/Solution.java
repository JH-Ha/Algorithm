package p3243;

import java.util.*;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        Map<Integer, List<Integer>> childrenMap = new HashMap<>();

        int[] answer = new int[queries.length];

        for (int i = 0; i < n; i++) {
            List<Integer> children = new ArrayList<>();
            if (i != n - 1) {
                children.add(i + 1);
            }
            childrenMap.put(i, children);
        }

        for (int i = 0; i < queries.length; i++) {
            List<Integer> children = childrenMap.get(queries[i][0]);
            children.add(queries[i][1]);

            int[] distance = new int[n];

            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);

            while (!queue.isEmpty()) {
                Integer cur = queue.poll();
                List<Integer> ch = childrenMap.get(cur);
                for (Integer child : ch) {
                    if (distance[child] == 0) {
                        distance[child] = distance[cur] + 1;
                        queue.add(child);
                    }
                }
            }
            answer[i] = distance[n - 1];

        }
        return answer;
    }
}