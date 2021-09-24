package p0004;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums = new int[n1 + n2];

        int c1 = 0;
        int c2 = 0;
        double ans = 0.0;
        for (int i = 0; i < n1 + n2; i++) {
            if (c1 < n1 && c2 < n2) {
                if (nums1[c1] <= nums2[c2]) {
                    nums[i] = nums1[c1++];

                } else {
                    nums[i] = nums2[c2++];
                }
            } else if (c1 < n1) {
                nums[i] = nums1[c1++];
            } else {
                nums[i] = nums2[c2++];
            }
        }
        if ((n1 + n2) % 2 == 0) {
            int mid = (n1 + n2) / 2;
            ans = ((double) nums[mid - 1] + nums[mid]) / 2;
        } else {
            ans = nums[(n1 + n2) / 2];
        }
        return ans;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}