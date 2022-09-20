#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>

using namespace std;

class Solution
{
public:
    vector<vector<int>> threeSum(vector<int> &nums)
    {
        vector<vector<int>> answer;

        int n = nums.size();
        sort(nums.begin(), nums.end());

        for (int i = 0; i < n; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n; j++)
            {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int target = -(nums[i] + nums[j]);
                int l = j + 1;
                int r = n - 1;
                while (l <= r)
                {
                    int mid = (l + r) / 2;
                    if (nums[mid] == target)
                    {
                        vector<int> a;
                        a.push_back(nums[i]);
                        a.push_back(nums[j]);
                        a.push_back(target);
                        answer.push_back(a);
                        break;
                    }
                    else if (nums[mid] < target)
                    {
                        l = mid + 1;
                    }
                    else
                    {
                        r = mid - 1;
                    }
                }
            }
        }
        return answer;
    }
};

int main()
{
    vector<int> nums = {-1, 0, 1, 2, -1, -4};
    Solution sol;
    vector<vector<int>> answer = sol.threeSum(nums);
    for (int i = 0; i < answer.size(); i++)
    {
        for (int j = 0; j < answer[i].size(); j++)
        {
            cout << answer[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}
