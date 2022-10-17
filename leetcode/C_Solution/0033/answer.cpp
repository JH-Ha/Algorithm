
#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>

using namespace std;
class Solution
{
public:
    int search(vector<int> &nums, int target)
    {
        int n = nums.size();
        int l = 1;
        int r = n - 1;
        int changeIdx = 0;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (nums[mid] <= nums[0])
            {
                changeIdx = mid;
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }

        int answer = -1;

        l = 0;
        r = changeIdx - 1;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (nums[mid] < target)
            {
                l = mid + 1;
            }
            else if (nums[mid] > target)
            {
                r = mid - 1;
            }
            else
            {
                answer = mid;
                break;
            }
        }

        l = changeIdx;
        r = n - 1;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (nums[mid] < target)
            {
                l = mid + 1;
            }
            else if (nums[mid] > target)
            {
                r = mid - 1;
            }
            else
            {
                answer = mid;
                break;
            }
        }
        return answer;
    }
};
int main()
{
    Solution solution;
    // vector<int> nums = {4, 5, 6, 7, 8, 1, 2, 3};
    vector<int> nums = {4, 5, 6, 7, 0, 1, 2};
    // vector<int> nums = {3, 1};
    int target = 0;
    cout << solution.search(nums, target) << endl;

    return 0;
}