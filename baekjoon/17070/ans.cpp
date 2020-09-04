#include <iostream>
#include <queue>
#include <utility>
#include <tuple>

using namespace std;

int arr[20][20];

int ans = 0;

queue<tuple<int, int, int>> q;

bool check(int x, int y, int line)
{
    bool result = false;
    if (line == 0)
    {
        if (arr[y][x + 1] == 0)
        {
            //cout << "x : " << x << "y : " << y << " line : " << line << endl;
            result = true;
        }
    }
    else if (line == 1)
    {
        if (arr[y][x + 1] == 0 && arr[y + 1][x + 1] == 0 && arr[y + 1][x] == 0)
        {
            //cout << "x : " << x << "y : " << y << " line : " << line << endl;
            result = true;
        }
    }
    else if (line == 2)
    {
        if (arr[y + 1][x] == 0)
        {
            //cout << "x : " << x << "y : " << y << " line : " << line << endl;
            result = true;
        }
    }

    return result;
}

int main()
{
    int n;
    cin >> n;
    int input;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> input;
            arr[i][j] = input;
        }
    }
    // x : 0, diagonal : 1, y : 2
    q.push(make_tuple(1, 0, 0));
    while (!q.empty())
    {
        tuple<int, int, int> curPoint = q.front();
        q.pop();
        // lay on x axis
        int x = get<0>(curPoint);
        int y = get<1>(curPoint);
        int line = get<2>(curPoint);

        //finish if the pipe reach the end point
        if (x == n - 1 && y == n - 1)
        {
            ans++;
            continue;
        }
        if (line == 0)
        {
            if (x < n - 1)
            {
                if (check(x, y, 0))
                {
                    q.push(make_tuple(x + 1, y, 0));
                }
            }
            if (y < n - 1 && x < n - 1)
            {
                if (check(x, y, 1))
                {
                    q.push(make_tuple(x + 1, y + 1, 1));
                }
            }
        }
        else if (line == 1)
        {
            if (x < n - 1 && check(x, y, 0))
            {
                q.push(make_tuple(x + 1, y, 0));
            }
            if (x < n - 1 && y < n - 1 && check(x, y, 1))
            {
                q.push(make_tuple(x + 1, y + 1, 1));
            }
            if (y < n - 1 && check(x, y, 2))
            {
                q.push(make_tuple(x, y + 1, 2));
            }
        }
        else if (line == 2)
        {
            if (x < n - 1 && y < n - 1 && check(x, y, 1))
            {
                q.push(make_tuple(x + 1, y + 1, 1));
            }
            if (y < n - 1 && check(x, y, 2))
            {
                q.push(make_tuple(x, y + 1, 2));
            }
        }
    }
    cout << ans << endl;

    return 0;
}