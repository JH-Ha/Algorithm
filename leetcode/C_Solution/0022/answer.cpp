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
    void gen(string &prev, int n, int l, int r, vector<string> &ans)
    {
        if (n == l && n == r)
        {
            ans.push_back(prev);
        }
        else if (n == l && r < n)
        {
            string next = prev + ')';
            gen(next, n, l, r + 1, ans);
        }
        else if (l < n && l > r)
        {
            string next1 = prev + '(';
            gen(next1, n, l + 1, r, ans);
            string next2 = prev + ')';
            gen(next2, n, l, r + 1, ans);
        }
        else if (l < n && l == r)
        {
            string next1 = prev + '(';
            gen(next1, n, l + 1, r, ans);
        }
    }
    vector<string> generateParenthesis(int n)
    {
        vector<string> answer;
        string init = "";
        gen(init, n, 0, 0, answer);
        return answer;
    }
};

int main()
{
    Solution solution;
    vector<string> a = solution.generateParenthesis(3);
    for (int i = 0; i < a.size(); i++)
    {
        cout << a[i] << endl;
    }
    return 0;
}