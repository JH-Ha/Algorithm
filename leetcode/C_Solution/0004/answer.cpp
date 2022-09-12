#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
    {
        int n = nums1.size();
        int m = nums2.size();

        vector<int> answer;
        for (int i = 0, j = 0; i + j < n + m;)
        {
            if (i < n && j < m)
            {
                if (nums1[i] < nums2[j])
                {
                    answer.push_back(nums1[i]);
                    i++;
                }
                else
                {
                    answer.push_back(nums2[j]);
                    j++;
                }
            }
            else if (i < n)
            {
                answer.push_back(nums1[i]);
                i++;
            }
            else
            {
                answer.push_back(nums2[j]);
                j++;
            }
        }
        if ((n + m) % 2 == 1)
        {
            return answer[(n + m) / 2];
        }
        else
        {
            return (answer[(n + m) / 2 - 1] + answer[(n + m) / 2]) / 2.0;
        }
    }
};
int main()
{
    vector<int> nums1 = {1, 2};
    vector<int> nums2 = {3, 4};

    Solution solution;
    cout << solution.findMedianSortedArrays(nums1, nums2) << endl;

    return 0;
}