#include <iostream>

using namespace std;

long long minResult = 100000000000000001;
long long maxResult = -100000000000000001;

int a[12];
int oper[4];
int n;

void find(long long prev, int idx)
{
    long long next = 0;
    if (idx == n)
    {
        maxResult = max(prev, maxResult);
        minResult = min(prev, minResult);
        return;
    }
    if (oper[0] > 0)
    {
        oper[0]--;
        next = prev + a[idx];
        find(next, idx + 1);
        oper[0]++;
    }
    if (oper[1] > 0)
    {
        oper[1]--;
        next = prev - a[idx];
        find(next, idx + 1);
        oper[1]++;
    }
    if (oper[2] > 0)
    {
        oper[2]--;
        next = prev * a[idx];
        find(next, idx + 1);
        oper[2]++;
    }
    if (oper[3] > 0)
    {
        oper[3]--;
        next = prev / a[idx];
        find(next, idx + 1);
        oper[3]++;
    }
}

int main()
{

    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    for (int i = 0; i < 4; i++)
    {
        cin >> oper[i];
    }
    find(a[0], 1);
    cout << maxResult << "\n"
         << minResult << "\n";

    return 0;
}