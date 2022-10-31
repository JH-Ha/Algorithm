
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
    vector<vector<int>> merge(vector<vector<int>> &intervals)
    {
        vector<vector<int>> answer;
        bool nums[10010] = {false};
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b)
             {
            if(a[0] < b[0]) return true;
            else return false; });
        answer.push_back(intervals[0]);
        for (int i = 1; i < intervals.size(); i++)
        {
            vector<int> interval = intervals[i];
            int lastIdx = answer.size() - 1;
            if (answer[lastIdx][0] <= interval[0] && interval[0] <= answer[lastIdx][1])
            {
                if (answer[lastIdx][1] < interval[1])
                    answer[lastIdx][1] = interval[1];
            }
            else
            {
                answer.push_back(interval);
            }
        }
        return answer;
    }
};