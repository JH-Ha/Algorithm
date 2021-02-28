#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int num[10];
int n, m;
bool used[10];
vector<int> answer;
void solve(int depth)
{
    if (depth == 0)
    {
        for (int i = 0; i < answer.size(); i++)
        {
            cout << answer[i] << ' ';
        }
        cout << '\n';
        return;
    }

    for (int i = 0; i < n; i++)
    {
        if (used[i] == false)
        {
            used[i] = true;
            answer.push_back(num[i]);
            //cout << num[i] << " ";
            solve(depth - 1);
            used[i] = false;
            answer.pop_back();
        }
    }
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> num[i];
        used[i] = false;
    }
    sort(num, num + n);
    solve(m);
    return 0;
}