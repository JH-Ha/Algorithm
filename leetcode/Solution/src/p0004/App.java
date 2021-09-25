package p0004;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans;
        if (nums1.length > nums2.length) {
            int[] numsTemp;
            numsTemp = nums1;
            nums1 = nums2;
            nums2 = numsTemp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m - 1;
        int leftMax = -1;
        int rightMax = -1;
        int i = 0;
        int j = 0;
        while (l <= r) {
            i = l + (r - l) / 2;
            j = (n + m + 1) / 2 - i;
            if (i > 0 && nums1[i - 1] > nums2[j]) {
                r = i - 1;
            } else if (j > 0 && nums2[j - 1] > nums1[i]) {
                l = i + 1;
            } else {
                break;
            }
        }
        i = l + (r - l) / 2;
        j = (n + m + 1) / 2 - i;

        // 왼쪽 최대값
        if (i == 0) {
            leftMax = nums2[j - 1];
        } else if (j == 0) {
            leftMax = nums1[i - 1];
        } else {
            leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
        }

        // 오른쪽 최소값
        if (i < m && j < n) {
            rightMax = Math.min(nums1[i], nums2[j]);
        } else if (i < m) {
            rightMax = nums1[i];
        } else if (j < n) {
            rightMax = nums2[j];
        }

        if ((m + n) % 2 == 0) {
            ans = (leftMax + rightMax) / 2.0;
        } else {
            ans = leftMax;
        }
        return ans;
    }

    public double findMedianSortedArraysSlow(int[] nums1, int[] nums2) {
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
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2, 7 };
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}