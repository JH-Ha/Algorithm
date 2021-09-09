package weeklyChallenge2021.forthWeek;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class JobScore {

    String name;
    int score;

    public JobScore(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            scoreMap.put(languages[i], preference[i]);
        }
        PriorityQueue<JobScore> pq = new PriorityQueue<>((a, b) -> {
            if (a.score != b.score) {
                return b.score - a.score;
            } else {
                return a.name.compareTo(b.name);
            }
        });
        for (int i = 0; i < table.length; i++) {
            String[] spt = table[i].split(" ");
            int scoreSum = 0;
            for (int j = 1; j < spt.length; j++) {
                scoreSum += scoreMap.getOrDefault(spt[j], 0) * (6 - j);
            }
            JobScore jobScore = new JobScore(spt[0], scoreSum);
            pq.add(jobScore);
        }
        return pq.poll().name;
    }
}

public class App {
    public static void main(String[] args) {

        String[] table = { "SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
                "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP",
                "GAME C++ C# JAVASCRIPT C JAVA" };
        String[] languages = { "PYTHON", "C++", "SQL" };
        int[] preference = { 7, 5, 5 };
        Solution solution = new Solution();
        System.out.println(solution.solution(table, languages, preference));
    }
}