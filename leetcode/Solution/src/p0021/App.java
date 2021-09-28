package p0021;

import java.util.List;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = null;
        ListNode answer = null;
        while (l1 != null && l2 != null) {
            ListNode node;
            if (l1.val < l2.val) {
                node = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                node = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (cur == null) {
                cur = node;
                answer = node;
            } else {
                cur.next = node;
                cur = cur.next;
            }
        }
        if (l1 != null) {
            if (cur == null) {
                answer = l1;
            } else {
                cur.next = l1;
            }
        } else if (l2 != null) {
            if (cur == null) {
                answer = l2;
            } else {
                cur.next = l2;
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        int n = 1;
        ListNode answer = solution.mergeTwoLists(head, head2);
        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}
