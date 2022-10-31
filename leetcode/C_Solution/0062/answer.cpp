
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
    int uniquePaths(int m, int n)
    {
        long long answer = 1;
        m--;
        n--;
        if (m > n)
        {
            int temp;
            temp = m;
            m = n;
            n = temp;
        }
        int j = 1;
        for (int i = (m + n); i > n; i--)
        {
            answer *= i;
            answer /= j;
            j++;
        }

        return answer;
    }
};