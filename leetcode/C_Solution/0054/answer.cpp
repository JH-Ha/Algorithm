
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
    bool isValidPos(int x, int y, int n, int m)
    {
        if (x < 0 || x >= n || y < 0 || y >= m)
        {
            return false;
        }
        return true;
    }
    string makeKey(int x, int y)
    {
        return to_string(x) + "_" + to_string(y);
    }
    vector<int> spiralOrder(vector<vector<int>> &matrix)
    {
        vector<int> answer;
        int height = matrix.size();
        int width = matrix[0].size();
        int num = width * height;
        int numVisited = 0;
        vector<int> dx = {0, 1, 0, -1};
        vector<int> dy = {1, 0, -1, 0};
        int curX = 0;
        int curY = 0;
        int direction = 0;
        unordered_set<string> visited;
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited.insert(makeKey(0, 0));
        answer.push_back(matrix[0][0]);
        while (!q.empty())
        {
            pair<int, int> top = q.front();
            q.pop();
            int nx = curX + dx[direction];
            int ny = curY + dy[direction];
            if (isValidPos(nx, ny, height, width) && visited.find(makeKey(nx, ny)) == visited.end())
            {
                answer.push_back(matrix[nx][ny]);
                q.push({nx, ny});
                visited.insert(makeKey(nx, ny));
                curX = nx;
                curY = ny;
            }
            else
            {
                direction = (direction + 1) % 4;
                int nx = curX + dx[direction];
                int ny = curY + dy[direction];
                if (isValidPos(nx, ny, height, width) && visited.find(makeKey(nx, ny)) == visited.end())
                {
                    answer.push_back(matrix[nx][ny]);
                    q.push({nx, ny});
                    visited.insert(makeKey(nx, ny));
                    curX = nx;
                    curY = ny;
                }
            }
        }
        return answer;
    }
};

int main()
{

    Solution solution;
    vector<vector<int>> matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    solution.spiralOrder(matrix);
}