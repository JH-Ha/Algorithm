
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
    bool searchMatrix(vector<vector<int>> &matrix, int target)
    {
        int n = matrix.size();
        int m = matrix[0].size();

        int l = 0;
        int r = n * m - 1;
        bool answer = false;
        while (l <= r)
        {
            int mid = l + (r - l) / 2;
            int i = mid / m;
            int j = mid % m;
            if (matrix[i][j] < target)
            {
                l = mid + 1;
            }
            else if (matrix[i][j] > target)
            {
                r = mid - 1;
            }
            else
            {
                answer = true;
                break;
            }
        }
        return answer;
    }
};