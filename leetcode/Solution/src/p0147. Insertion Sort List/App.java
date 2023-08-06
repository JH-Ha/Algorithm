package p0147;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode answer = new ListNode();
        answer.next = head;
        ListNode cur = answer.next;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;

            ListNode insertPrev = answer;
            ListNode insertCur = answer.next;
            while (insertCur != null) {
                if (insertCur.val > cur.val) {
                    break;
                }
                insertPrev = insertCur;
                insertCur = insertCur.next;
            }
            insertPrev.next = cur;
            cur.next = insertCur;
            cur = next;
        }
        return answer.next;
    }
}

public class App {
    public static void main(String[] args) {

        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        new Solution().insertionSortList(node);
    }
}
