package p1392;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String longestPrefix(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int[] pi = new int[s.length()];

        int j = 0;
        for(int i = 1; i < s.length(); i ++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = pi[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                pi[i] = ++j;
            }
        }
        return s.substring(0, pi[s.length()-1]);
    }
}