
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
    int longestValidParentheses(string s)
    {
        int dp[30010] = {0};
        int answer = 0;
        for (int i = 1; i < s.size(); i++)
        {
            if (s[i] == ')')
            {
                if (dp[i - 1] > 0)
                {
                    int prev = i - dp[i - 1] - 1;
                    if (prev >= 0 && s[prev] == '(')
                    {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                else if (s[i - 1] == '(')
                {
                    dp[i] = 2;
                }
            }
            if (s.charAt(i) == ')')
            {
                if (s.charAt(i - 1) == '(')
                {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                }
                else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(')
                {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
            answer = max(answer, dp[i]);
        }
        return answer;
    }
};

int main()
{
    return 0;
}