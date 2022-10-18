
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
    int jump(vector<int> &nums)
    {
        unordered_set<int> visited;
        queue<pair<int, int>> q;
        pair<int, int> first = {0, 0};
        q.push(first);
        visited.insert(0);
        int n = nums.size();

        while (!q.empty())
        {
            pair<int, int> top = q.front();
            q.pop();
            int i = top.first;

            for (int j = 1; j <= nums[i]; j++)
            {
                if (i + j >= n)
                    continue;
                if (i + j == n - 1)
                {
                    return top.second + 1;
                }
                else if (visited.find(i + j) == visited.end())
                {
                    visited.insert(i + j);
                    q.push({i + j, top.second + 1});
                }
            }
        }
        return 0;
    }
};

int main()
{
    vector<int> nums = {2, 3, 1, 1, 4};
    Solution solution;
    cout << solution.jump(nums) << endl;
    return 0;
}