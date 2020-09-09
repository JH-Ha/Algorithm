#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool check(vector<vector<int>> key, vector<vector<int>> lock)
{
    bool answer = false;
    int numEmpty = 0;
    for (int i = 0; i < lock.size(); i++)
    {
        for (int j = 0; j < lock[i].size(); j++)
        {
            if (lock[i][j] == 0)
            {
                numEmpty++;
            }
            //cout << key[i][j] << " ";
        }
        //cout << endl;
    }
    int m, n;
    m = key.size();
    n = lock.size();
    //bool isMatch = true;
    int numMatched = 0;
    for (int i = -m + 1; i <= m + n - 2; i++)
    {
        for (int j = -m + 1; j <= m + n - 2; j++)
        {
            numMatched = 0;
            for (int x = 0; x < m; x++)
            {
                for (int y = 0; y < m; y++)
                {
                    if (x + i >= 0 && x + i <= n - 1 && y + j >= 0 && y + j <= n - 1)
                    {
                        if (lock[x + i][y + j] == 0 && key[x][y] == 1)
                        {
                            numMatched++;
                        }
                    }
                }
            }
            if (numEmpty == numMatched)
            {
                answer = true;
            }
        }
    }

    return answer;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock)
{
    bool answer = false;
    if (check(key, lock))
    {
        answer = true;
    }
    vector<vector<int>> key90;
    vector<vector<int>> key180;
    vector<vector<int>> key270;

    for (int i = 0; i < key.size(); i++)
    {
        vector<int> row90, row180, row270;
        key90.push_back(row90);
        key180.push_back(row180);
        key270.push_back(row270);
    }
    int m = key.size();
    for (int i = 0; i < key.size(); i++)
    {
        for (int j = 0; j < key.size(); j++)
        {
            key90[i].push_back(key[j][m - 1 - i]);
            key180[i].push_back(key[m - i - 1][m - j - 1]);
        }
    }
    for (int i = 0; i < key.size(); i++)
    {
        for (int j = 0; j < m; j++)
        {
            key270[i].push_back(key90[m - i - 1][m - j - 1]);
        }
    }
    answer = answer | check(key90, lock) | check(key180, lock) | check(key270, lock);

    return answer;
}

int main()
{
    int m, n;
    cin >> m;
    vector<vector<int>> key;
    for (int i = 0; i < m; i++)
    {
        vector<int> row;
        key.push_back(row);
        for (int j = 0; j < m; j++)
        {
            int k;
            cin >> k;
            key[i].push_back(k);
        }
    }
    cin >> n;
    vector<vector<int>> lock;
    for (int i = 0; i < n; i++)
    {
        vector<int> row;
        lock.push_back(row);
        for (int j = 0; j < n; j++)
        {
            int l;
            cin >> l;
            lock[i].push_back(l);
        }
    }
    if (solution(key, lock))
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }
    return 0;
}