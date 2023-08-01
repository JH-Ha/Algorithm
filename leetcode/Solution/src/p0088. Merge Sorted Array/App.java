package p0088;

//* Definition for singly-linked list.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        while(i < m || j < n){
            if(i < m && j < n){
                if(nums1[m - i - 1] > nums2[n - j - 1]){
                    nums1[n+ m - i - j - 1]= nums1[m - i - 1];
                    i ++;
                }else{
                    nums1[n + m - i - j - 1] = nums2[n - j - 1];
                    j ++;
                }
            }else if(i < m){
                nums1[n + m - i - j - 1] = nums1[m - i - 1];
                i ++;
            }else{
                nums1[n + m - i - j - 1] = nums2[n - j - 1];
                j ++;
            }
        }
        return;
    }
}

public class App {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
        new Solution().deleteDuplicates(head);
    }
}