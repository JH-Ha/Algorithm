#include <iostream>

using namespace std;

class Solution
{
public:
    int lengthOfLongestSubstring(string s)
    {
        int ans = 0;
        for (int i = 0; i < s.size(); i++)
        {
            bool visited[255] = {false};
            int cnt = 0;
            for (int j = 0; i + j < s.size(); j++)
            {
                int pos = s.at(i + j);
                if (!visited[pos])
                {
                    visited[pos] = true;
                    cnt++;
                }
                else
                {
                    break;
                }
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};

int main()
{
    Solution solution;
    cout << solution.lengthOfLongestSubstring(" ") << endl;

    return 0;
}