
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
    void rotate(vector<vector<int>> &matrix)
    {
        int n = matrix.size();
        for (int i = 0; i < n; i++)
        {
            for (int j = i; j < n - 1 - i; j++)
            {
                int leftTop = matrix[i][j];
                int rightTop = matrix[j][n - 1 - i];
                int rightBottom = matrix[n - 1 - i][n - 1 - j];
                int leftBottom = matrix[n - 1 - j][i];
                matrix[i][j] = leftBottom;
                matrix[j][n - 1 - i] = leftTop;
                matrix[n - 1 - i][n - 1 - j] = rightTop;
                matrix[n - 1 - j][i] = rightBottom;
            }
        }
    }
};

int main()
{
    vector<vector<int>> matrix = {{1, 2, 3},
                                  {4, 5, 6},
                                  {7, 8, 9}};
    Solution solution;
    solution.rotate(matrix);
    for (int i = 0; i < matrix.size(); i++)
    {
        for (int j = 0; j < matrix.size(); j++)
        {
            cout << matrix[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}