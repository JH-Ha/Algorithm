package p0002;

// 2. Add Two Numbers
//Definition for singly-linked list. 
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode answer = null;
        ListNode curNode = null;
        while (true) {
            if (l1 != null && l2 != null) {
                int num = l1.val + l2.val + carry;
                if (num >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                num %= 10;
                ListNode newNode = new ListNode(num);
                if (answer == null) {
                    answer = newNode;
                    curNode = answer;
                } else {
                    curNode.next = newNode;
                    curNode = newNode;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else {
                break;
            }
        }
        while (l1 != null) {
            int num = l1.val + carry;
            if (num >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            num %= 10;
            ListNode newNode = new ListNode(num);
            curNode.next = newNode;
            curNode = newNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num = l2.val + carry;
            if (num >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }
            num %= 10;
            ListNode newNode = new ListNode(num);
            curNode.next = newNode;
            curNode = newNode;
            l2 = l2.next;
        }
        if (carry == 1) {
            curNode.next = new ListNode(1);
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1_1 = new ListNode(3);
        ListNode l1_2 = new ListNode(4, l1_1);
        ListNode l1_3 = new ListNode(2, l1_2);

        ListNode l2_1 = new ListNode(4);
        ListNode l2_2 = new ListNode(6, l2_1);
        ListNode l2_3 = new ListNode(5, l2_2);

        solution.addTwoNumbers(l1_3, l2_3);
    }
}
