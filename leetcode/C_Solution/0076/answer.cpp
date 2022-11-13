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
    string minWindow(string s, string t)
    {
        vector<int> cnt(128, 0);
        vector<queue<int>> pos(128);

        int tLen = t.size();
        for (int i = 0; i < tLen; i++)
        {
            cnt[t[i] - 'A']++;
        }
        int sLen = s.size();
        int minLen = sLen;
        int numMatch = 0;
        int l = 0; // include
        int r = 0; // include
        for (int i = 0; i < sLen; i++)
        {
            int idx = s[i] - 'A';
            pos[idx].push(i);
            if (cnt[idx] < pos[idx].size())
            {
                pos[idx].pop();
            }
            else
            {
                numMatch++;
            }
            if (numMatch == tLen)
            {
                int minI = sLen;
                for (int j = 0; j < pos.size(); j++)
                {
                    if (pos[j].empty())
                        continue;
                    minI = min(pos[j].front(), minI);
                }
                if (i - minI + 1 <= minLen)
                {
                    minLen = i - minI + 1;
                    l = minI;
                    r = i;
                }
            }
        }
        if (numMatch == tLen)
            return s.substr(l, r - l + 1);
        else
            return "";
    }
};

int main()
{
    Solution s;
    cout << s.minWindow("aa", "aa") << endl;
    return 0;
}