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
    int largestRectangleArea(vector<int> &heights)
    {
        int minHeight = heights[0];
        int l = 0;
        int answer = heights[0];
        stack<pair<int, int>> s;
        s.push({heights[0], 0});

        for (int i = 1; i < heights.size(); i++)
        {
            pair<int, int> top = s.top();
            if (s.empty() || top.first <= heights[i])
            {
                s.push({heights[i], i});
            }
            else
            {
                pair<int, int> top = s.top();
                int idx = i;
                while (!s.empty() && top.first > heights[i])
                {
                    idx = top.second;
                    answer = max(answer, top.first * (i - top.second));
                    s.pop();
                    if (!s.empty())
                    {
                        top = s.top();
                    }
                }
                s.push({heights[i], idx});
            }
        }
        while (!s.empty())
        {
            pair<int, int> top = s.top();
            answer = max(answer, top.first * ((int)heights.size() - top.second));
            s.pop();
        }
        return answer;
    }
};

int main()
{
    Solution s;
    vector<int> heights = {2, 1, 5, 6, 2, 3};
    cout << s.largestRectangleArea(heights) << endl;
    return 0;
}