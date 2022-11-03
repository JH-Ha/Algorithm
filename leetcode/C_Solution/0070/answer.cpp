
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
    int dp[50];
    int climbStairs(int n)
    {

        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        if (dp[n] != 0)
            return dp[n];
        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
};

int main()
{
    Solution sol;
    cout << sol.climbStairs(3) << endl;
    return 0;
}