#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>
#include <queue>
#include <string>

using namespace std;

class Solution
{
public:
    void findAnswer(vector<vector<int>> &answer, vector<int> &nums, vector<bool> &inUse, int idx)
    {
        if (idx >= nums.size())
        {
            vector<int> subset;
            for (int i = 0; i < nums.size(); i++)
            {
                if (inUse[i])
                {
                    subset.push_back(nums[i]);
                }
            }
            answer.push_back(subset);
            return;
        }

        inUse[idx] = false;
        findAnswer(answer, nums, inUse, idx + 1);
        inUse[idx] = true;
        findAnswer(answer, nums, inUse, idx + 1);
    }
    vector<vector<int>> subsets(vector<int> &nums)
    {
        vector<vector<int>> answer;
        vector<bool> inUse(nums.size(), false);
        findAnswer(answer, nums, inUse, 0);
        return answer;
    }
};