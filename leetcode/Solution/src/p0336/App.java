package p0336;

import java.util.ArrayList;
import java.util.List;

public class App {
    class Trie {
        List<Integer> palindromeIdx;
        Trie[] children;
        int wordIdx = -1;

        public Trie() {
            this.children = new Trie[26];
            this.palindromeIdx = new ArrayList<>();
        }

        public void insert(String s, int idx) {
            if ("".equals(s)) {
                this.palindromeIdx.add(idx);
                this.wordIdx = idx;
            } else {
                int charIdx = s.charAt(0) - 'a';
                if (this.children[charIdx] == null) {
                    this.children[charIdx] = new Trie();
                }
                if (checkPalindrome(s)) {
                    this.palindromeIdx.add(idx);
                }
                this.children[charIdx].insert(s.substring(1), idx);
            }
            // System.out.println(s.substring(1, 2));
        }

    }

    public boolean checkPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie root = new Trie();
        // Trie reRoot = new Trie();
        for (int i = 0; i < words.length; i++) {
            root.insert(words[i], i);
            // reRoot.insert(words[i], i);
        }
        Trie node = root;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            StringBuilder builder = new StringBuilder(words[i]);
            String reWord = builder.reverse().toString();
            for (int j = 0; j < reWord.length(); j++) {
                if (node.wordIdx != -1 && checkPalindrome(reWord.substring(j))) {
                    List<Integer> a1 = new ArrayList<>();
                    a1.add(node.wordIdx);
                    a1.add(i);
                    ans.add(a1);
                }
                if (node.children[reWord.charAt(j) - 'a'] == null)
                    break;
                node = node.children[reWord.charAt(j) - 'a'];
            }

        }
        return null;
    }

    public static void main(String[] args) {
        String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
        App solution = new App();
        solution.palindromePairs(words);
    }
}
