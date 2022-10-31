
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
    bool isValid(vector<bool> &d1, vector<bool> &d2, vector<bool> &cols, int x, int y, int n)
    {
        if (!cols[y] && !d1[x + y] && !d2[x - y + n])
        {
            return true;
        }
        return false;
    }
    void backTracking(bool pos[9][9], vector<bool> &d1, vector<bool> &d2, vector<bool> &cols, int cur, int n, vector<vector<string>> &answer)
    {
        if (cur == n)
        {
            vector<string> v;
            for (int i = 0; i < n; i++)
            {
                string s;
                for (int j = 0; j < n; j++)
                {
                    if (pos[i][j])
                        s += "Q";
                    else
                        s += ".";
                }
                v.push_back(s);
            }
            answer.push_back(v);
            return;
        }
        int i = cur;

        for (int j = 0; j < n; j++)
        {
            if (isValid(d1, d2, cols, i, j, n))
            {

                cols[j] = true;
                d1[i + j] = true;
                d2[i - j + n] = true;
                pos[i][j] = true;
                backTracking(pos, d1, d2, cols, cur + 1, n, answer);
                pos[i][j] = false;
                d2[i - j + n] = false;
                d1[i + j] = false;
                cols[j] = false;
            }
        }
    }
    vector<vector<string>> solveNQueens(int n)
    {
        bool pos[9][9] = {false};
        vector<bool> cols(n, false);
        vector<bool> d1(n * 2 + 1, false);
        vector<bool> d2(n * 2 + 1, false);
        vector<vector<string>> answer;
        backTracking(pos, d1, d2, cols, 0, n, answer);
        return answer;
    }
};
int main()
{
    Solution solution;
    solution.solveNQueens(4);
    return 0;
}