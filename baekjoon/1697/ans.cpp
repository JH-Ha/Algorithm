#include <iostream>
#include <queue>

using namespace std;

bool visited[100010];

int main()
{
    for (int i = 0; i < 100010; i++)
    {
        visited[i] = false;
    }

    int n, k;
    cin >> n >> k;
    queue<pair<int, int>> q;
    pair<int, int> start = make_pair(n, 0);

    q.push(start);
    visited[n] = true;
    int answer = 0;
    while (!q.empty())
    {
        pair<int, int> p = q.front();
        q.pop();
        if (p.first == k)
        {
            answer = p.second;
            break;
        }
        if (p.first - 1 >= 0 && !visited[p.first - 1])
        {

            q.push(make_pair(p.first - 1, p.second + 1));
            visited[p.first - 1] = true;
        }
        if (p.first + 1 <= 100000 && !visited[p.first + 1])
        {
            q.push(make_pair(p.first + 1, p.second + 1));
            visited[p.first + 1] = true;
        }
        if (p.first * 2 <= 100000 && !visited[p.first * 2])
        {
            q.push(make_pair(p.first * 2, p.second + 1));
            visited[p.first * 2] = true;
        }
    }
    cout << answer << endl;
    return 0;
}