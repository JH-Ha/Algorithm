#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

class Solution
{
public:
    vector<int> twoSum(vector<int> &nums, int target)
    {
        unordered_map<int, int> map;
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++)
        {
            auto idx = map.find(target - nums[i]);
            if (idx != map.end())
            {
                ans.push_back(i);
                ans.push_back(idx->second);
                break;
            }
            map.insert({nums[i], i});
        }
        return ans;
    }
};

// class Solution
// {
// public:
//     vector<int> twoSum(vector<int> &nums, int target)
//     {
//         vector<int> ans;
//         for (int i = 0; i < nums.size(); i++)
//         {
//             for (int j = i + 1; j < nums.size(); j++)
//             {
//                 if (nums[i] + nums[j] == target)
//                 {
//                     ans.push_back(i);
//                     ans.push_back(j);
//                     break;
//                 }
//             }
//             if (ans.size() > 0)
//             {
//                 break;
//             }
//         }
//         return ans;
//     }
// };

int main()
{
    int target = 5;
    vector<int> nums = {1, 2, 3};

    Solution Solution;
    vector<int> ans = Solution.twoSum(nums, target);
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << endl;
    }
    return 0;
}