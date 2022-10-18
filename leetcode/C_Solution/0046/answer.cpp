
#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>
#include <queue>

using namespace std;
class Solution
{
public:
    void solve(vector<int> &nums, vector<int> &cur, unordered_set<int> &visited, vector<vector<int>> &answer)
    {
        if (cur.size() == nums.size())
        {
            vector<int> ele = vector<int>(cur);
            answer.push_back(ele);
            return;
        }
        for (int i = 0; i < nums.size(); i++)
        {
            if (visited.find(i) == visited.end())
            {
                visited.insert(i);
                cur.push_back(nums[i]);
                solve(nums, cur, visited, answer);
                cur.pop_back();
                visited.erase(i);
            }
        }
    }
    vector<vector<int>> permute(vector<int> &nums)
    {
        vector<vector<int>> answer;
        vector<int> cur;
        unordered_set<int> visited;
        solve(nums, cur, visited, answer);
        return answer;
    }
};

int main()
{
    vector<int> nums = {2, 3, 1, 1, 4};
    Solution solution;
    vector<vector<int>> answer = solution.permute(nums);
    return 0;
}