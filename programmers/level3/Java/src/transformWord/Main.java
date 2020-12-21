package transformWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    int depth;
    String word;

    public Node(String word, int depth) {
        this.depth = depth;
        this.word = word;
    }
}

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 100000;

        Map<String, Boolean> visited = new HashMap<>();
        Map<String, List<String>> edge = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            visited.put(words[i], false);
            for (int j = i + 1; j < words.length; j++) {
                int diffCnt = 0;
                for (int x = 0; x < words[i].length(); x++) {
                    if (words[i].charAt(x) != words[j].charAt(x)) {
                        diffCnt++;
                    }
                }
                if (diffCnt == 1) {
                    List<String> list1 = edge.get(words[i]);
                    List<String> list2 = edge.get(words[j]);
                    if (list1 == null) {
                        list1 = new ArrayList<>();
                        edge.put(words[i], list1);
                    }
                    list1.add(words[j]);
                    if (list2 == null) {
                        list2 = new ArrayList<>();
                        edge.put(words[j], list2);
                    }
                    list2.add(words[i]);
                }
            }
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int diffCnt = 0;
            for (int x = 0; x < word.length(); x++) {
                if (begin.charAt(x) != word.charAt(x)) {
                    diffCnt++;
                }
            }
            if (diffCnt == 1) {
                for (int j = 0; j < words.length; j++) {
                    visited.put(words[j], false);
                }
                Queue<Node> q = new LinkedList<>();
                q.add(new Node(word, 1));
                while (!q.isEmpty()) {
                    Node top = q.poll();
                    if (top.word.equals(target)) {
                        // if (child.equals(target)) {
                        answer = Math.min(top.depth, answer);
                        // }
                    }
                    boolean visit = visited.get(top.word);
                    if (!visit) {
                        visited.put(top.word, true);
                        List<String> children = edge.get(top.word);
                        if (children != null) {
                            for (int j = 0; j < children.size(); j++) {
                                String child = children.get(j);

                                visit = visited.get(child);
                                if (!visit) {
                                    q.add(new Node(child, top.depth + 1));

                                }
                            }
                        }
                    }

                }
            }
        }
        if (answer == 100000) {
            answer = 0;
        }
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        System.out.println(solution.solution(begin, target, words));
    }
}