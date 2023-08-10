package p0151;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Solution {
    public String reverseWords(String s) {
        List<String> list = Arrays.stream(s.trim().split(" "))
                .filter(a -> a.length() > 0)
                .collect(Collectors.toList());

        Collections.reverse(list);
        return String.join(" ", list);
    }
}

public class App {
    public static void main(String[] args) {

        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        new Solution().insertionSortList(node);
    }
}
