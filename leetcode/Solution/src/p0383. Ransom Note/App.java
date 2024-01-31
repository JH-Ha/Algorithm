package p0383;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int ransomNoteCnt[] = new int[26];
        int magazineCnt[] = new int[26];

        for (int i = 0; i < ransomNote.length(); i++) {
            ransomNoteCnt[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            magazineCnt[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (ransomNoteCnt[i] > magazineCnt[i]) {
                return false;
            }
        }
        return true;
    }
}

public class App {

    public static void main(String[] args) {

    }
}
