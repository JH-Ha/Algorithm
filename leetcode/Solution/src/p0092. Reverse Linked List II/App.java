package p0092;

public class ListNode {
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int curIdx = 1;

        ListNode cur = head;
        ListNode ans = new ListNode();
        ListNode ansCur = ans;
        while (cur != null) {
            if (curIdx == left) {
                ListNode reverseCur = null;
                ListNode lastNode = null;
                while (curIdx <= right) {
                    reverseCur = new ListNode(cur.val, reverseCur);
                    if (curIdx == left) {
                        lastNode = reverseCur;
                    }
                    curIdx++;
                    cur = cur.next;
                }
                ansCur.next = reverseCur;
                ansCur = lastNode;
            } else {
                ansCur.next = new ListNode(cur.val);
                ansCur = ansCur.next;
                curIdx++;
                cur = cur.next;
            }
        }

        return ans.next;
    }
}

public class App {
    public static void main(String[] args) {

    }
}