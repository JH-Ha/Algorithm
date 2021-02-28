#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

#define MAX_N 500010

stack<int> s;
vector<pair<int, int>> connect;
int cache[MAX_N];
pair<int, int> answer[MAX_N];
bool visited[MAX_N];

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        int l, r;
        cin >> l >> r;
        connect.push_back(make_pair(l, r));
        visited[l] = true;
    }
    sort(connect.begin(), connect.end());
    int idx = 0;
    int length = 0;
    cache[idx] = connect[0].second;
    answer[0] = make_pair(0, connect[0].first);
    for (int i = 1; i < n; i++)
    {
        if (cache[idx] < connect[i].second)
        {
            cache[++idx] = connect[i].second;
            answer[i] = make_pair(idx, connect[i].first);
        }
        else
        {
            int l = 0;
            int r = idx;
            int ans = l;
            while (l <= r)
            {
                int mid = (l + r) / 2;
                if (connect[i].second <= cache[mid])
                {
                    ans = mid;
                    r = mid - 1;
                }
                else
                {
                    l = mid + 1;
                }
            }
            cache[ans] = connect[i].second;
            answer[i] = make_pair(ans, connect[i].first);
            //cout << "ans : " << ans << endl;
        }
    }
    cout << n - idx - 1 << endl;
    int num = idx;
    for (int i = n - 1; i >= 0; i--)
    {
        if (answer[i].first == num)
        {
            s.push(answer[i].second);
            num--;
        }
    }
    while (!s.empty())
    {
        int top = s.top();
        visited[top] = false;
        s.pop();
    }
    for (int i = 0; i < MAX_N; i++)
    {
        if (visited[i])
            printf("%d\n", i);
    }

    return 0;
}