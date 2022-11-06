
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
    int minDistance(string word1, string word2)
    {
        int n = word1.size();
        int m = word2.size();
        int dp[510][510];
        for (int j = 0; j <= m; j++)
        {
            dp[0][j] = j;
        }
        for (int i = 0; i <= n; i++)
        {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (word1[i - 1] == word2[j - 1])
                {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else
                {
                    int minDis = min(dp[i - 1][j - 1], dp[i - 1][j]);
                    minDis = min(minDis, dp[i][j - 1]);
                    dp[i][j] = minDis + 1;
                }
            }
        }
        return dp[n][m];
    }
};