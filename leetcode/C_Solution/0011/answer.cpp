#include <iostream>
#include <vector>

using namespace std;

class Solution
{
public:
    int maxArea(vector<int> &height)
    {
        int answer = 0;
        int left = 0;
        int right = height.size() - 1;
        while (left < right)
        {
            int width = right - left;
            int minHeight = min(height[right], height[left]);
            int area = width * minHeight;
            answer = max(area, answer);
            if (height[right] < height[left])
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return answer;
    }
};

int main()
{
    Solution sol;
    vector<int> height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    cout << sol.maxArea(height) << endl;
    return 0;
}