
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
    int minPathSum(vector<vector<int>> &grid)
    {
        int dp[210][210] = {0};
        int n = grid.size();
        int m = grid[0].size();
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++)
        {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for (int j = 1; j < m; j++)
        {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < n; i++)
        {
            for (int j = 1; j < m; j++)
            {
                dp[i][j] = min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }
};