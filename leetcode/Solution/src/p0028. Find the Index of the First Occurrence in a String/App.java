package p0028;

class Solution {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length()) {
                    match = false;
                    break;
                }
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
}
