package p0082;

//* Definition for singly-linked list.
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode ans = new ListNode();
        ListNode cur = head;
        int curVal = cur.val;
        int cnt = 0;
        while (cur != null && curVal == cur.val) {
            cnt++;
            cur = cur.next;
        }
        if (cnt == 1) {
            ans.next = new ListNode(curVal, deleteDuplicates(cur));
        } else {
            ans.next = deleteDuplicates(cur);
        }

        return ans.next;
    }
}

public class App {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
        new Solution().deleteDuplicates(head);
    }
}