
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
    int firstMissingPositive(vector<int> &nums)
    {
        int n = nums.size();
        for (int i = 0; i < n; i++)
        {
            if (nums[i] <= 0 || nums[i] > n)
            {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++)
        {
            int absNum = abs(nums[i]);
            if (absNum > n)
                continue;
            nums[absNum - 1] = -abs(nums[absNum - 1]);
        }
        for (int i = 0; i < n; i++)
        {
            if (nums[i] > 0)
            {
                return i + 1;
            }
        }
        return n + 1;
    }
};
int main()
{
    vector<int> nums = {1, 2, 3};
    Solution solution;
    int answer = solution.firstMissingPositive(nums);
    cout << answer << endl;

    return 0;
}