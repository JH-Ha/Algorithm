
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
    int maxSubArray(vector<int> &nums)
    {
        int answer = -10000;
        int sum = 0;
        int start = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            sum += nums[i];
            answer = max(answer, sum);
            if (sum < 0)
            {
                sum = 0;
            }
        }
        return answer;
    }
};