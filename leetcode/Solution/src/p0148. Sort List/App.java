package p0148;

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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        if (cnt == 1) {
            return head;
        } else if (cnt == 2) {
            ListNode next = head.next;
            if (head.val > next.val) {
                head.next = null;
                next.next = head;
                return next;
            }
            return head;
        } else {
            cur = head;
            ListNode prev = null;
            for (int i = 0; i < cnt / 2; i++) {
                prev = cur;
                cur = cur.next;
            }
            prev.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(cur);
            ListNode answer = new ListNode();
            ListNode answerCur = answer;
            ListNode leftCur = left;
            ListNode rightCur = right;
            while (leftCur != null && rightCur != null) {
                if (leftCur.val < rightCur.val) {
                    answerCur.next = leftCur;
                    leftCur = leftCur.next;
                } else {
                    answerCur.next = rightCur;
                    rightCur = rightCur.next;
                }
                answerCur = answerCur.next;
            }
            if (leftCur != null) {
                answerCur.next = leftCur;
            }
            if (rightCur != null) {
                answerCur.next = rightCur;
            }
            return answer.next;
        }
    }
}

public class App {
    public static void main(String[] args) {

        ListNode node = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3, null))));
        new Solution().sortList(node);
    }
}
