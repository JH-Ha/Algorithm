#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        vector<pair<int, int>> node[505];
        int n, m, w;
        cin >> n >> m >> w;
        int l, r, weight;
        long long d[505];
        for (int i = 0; i < m; i++)
        {
            cin >> r >> l >> weight;
            node[r].push_back(make_pair(l, weight));
            node[l].push_back(make_pair(r, weight));
        }
        for (int i = 0; i < w; i++)
        {
            cin >> r >> l >> weight;
            node[r].push_back(make_pair(l, -weight));
        }
        for (int i = 1; i <= n; i++)
        {
            d[i] = 987654321;
        }
        d[1] = 0;
        for (int i = 1; i <= n - 1; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (auto e : node[j])
                {
                    d[j] = min(d[j], d[e.first] + e.second);
                }
            }
        }
        bool ans = false;
        for (int j = 1; j <= n; j++)
        {
            for (auto e : node[j])
            {
                if (d[j] > d[e.first] + e.second)
                {
                    ans = true;
                }
            }
        }
        if (ans)
            cout << "YES" << '\n';
        else
            cout << "NO" << '\n';
    }
    return 0;
}