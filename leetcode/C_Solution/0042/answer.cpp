
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
    int trap(vector<int> &height)
    {
        vector<int> maxLeft;
        int curMax = height[0];
        int answer = 0;
        for (int i = 0; i < height.size(); i++)
        {
            curMax = max(curMax, height[i]);
            maxLeft.push_back(curMax);
        }

        curMax = height[height.size() - 1];
        for (int i = height.size() - 1; i >= 0; i--)
        {
            curMax = max(curMax, height[i]);
            if (height[i] < curMax)
            {
                int minMax = min(maxLeft[i], curMax);
                answer += (minMax - height[i]);
            }
        }
        return answer;
    }
};