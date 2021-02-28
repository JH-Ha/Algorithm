#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int num[10];
int n, m;
vector<int> answer;
void solve(int depth)
{
    if (depth == 0)
    {
        for (int i = 0; i < answer.size(); i++)
        {
            cout << answer[i] << " ";
        }
        cout << endl;
        return;
    }
    for (int i = 0; i < n; i++)
    {
        if (answer.size() != 0)
        {
            if (answer[answer.size() - 1] > num[i])
                continue;
        }
        answer.push_back(num[i]);
        solve(depth - 1);
        answer.pop_back();
    }
}
int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> num[i];
    }
    sort(num, num + n);
    solve(m);
    return 0;
}