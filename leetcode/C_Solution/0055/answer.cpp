
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
    bool canJump(vector<int> &nums)
    {
        int n = nums.size();
        bool visited[10000] = {false};
        visited[0] = true;

        queue<int> q;
        q.push(0);
        bool answer = false;
        while (!q.empty())
        {
            int top = q.front();
            q.pop();
            if (top == n - 1)
            {
                answer = true;
                break;
            }
            for (int i = nums[top]; i >= 1; i--)
            {
                int next = top + i;
                if (next < n && !visited[next])
                {
                    visited[next] = true;
                    q.push(next);
                }
            }
        }
        return answer;
    }
};

int main()
{
    Solution solution;
    vector<int> nums = {2, 3, 1, 1, 4};
    cout << solution.canJump(nums) << endl;
}