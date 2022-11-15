#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>
#include <queue>
#include <string>

using namespace std;

int dx[] = {0, 1, 0, -1};
int dy[] = {1, 0, -1, 0};

class Solution
{
public:
    bool isValidPos(int i, int j, int n, int m)
    {
        if (i >= 0 && i < n && j >= 0 && j < m)
        {
            return true;
        }
        return false;
    }
    int makeKey(int x, int y, int m)
    {
        return x * m + y;
    }

    bool answer = false;
    void find(vector<vector<char>> &board, string word, unordered_set<int> &visited, int x, int y, int curDepth)
    {
        int n = board.size();
        int m = board[0].size();
        if (curDepth == word.size() - 1)
        {
            answer = true;
            return;
        }

        for (int k = 0; k < 4; k++)
        {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (isValidPos(nx, ny, n, m) && board[nx][ny] == word[curDepth + 1] && visited.find(makeKey(nx, ny, m)) == visited.end())
            {
                visited.insert(makeKey(nx, ny, m));
                find(board, word, visited, nx, ny, curDepth + 1);
                visited.erase(makeKey(nx, ny, m));
            }
        }
    }
    bool exist(vector<vector<char>> &board, string word)
    {
        int n = board.size();
        int m = board[0].size();
        unordered_set<int> visited;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (board[i][j] == word[0])
                {
                    visited.insert(makeKey(i, j, m));
                    find(board, word, visited, i, j, 0);
                    visited.erase(makeKey(i, j, m));
                }
                if (answer)
                    break;
            }
            if (answer)
                break;
        }

        return answer;
    }
};

int main()
{
    vector<vector<char>> board;
    vector<char> row1 = {'C', 'A', 'A'};
    vector<char> row2 = {'A', 'A', 'A'};
    vector<char> row3 = {'B', 'C', 'D'};
    board.push_back(row1);
    board.push_back(row2);
    board.push_back(row3);

    string word = "AAB";
    Solution solution;
    solution.exist(board, word);
    return 0;
}