package p0019;

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int nodesLen = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            nodesLen++;
        }
        if (nodesLen == 1) {
            return null;
        } else if (n == nodesLen) {
            return head.next;
        } else {
            cur = head;
            for (int i = 0; i < nodesLen - 1 - n; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            return head;
        }
    }
}

public class App {
    public static void main(String[] args) {

        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        int n = 1;
        ListNode answer = solution.removeNthFromEnd(head, n);
        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}
