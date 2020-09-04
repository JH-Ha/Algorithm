#include <iostream>
#include <string>
#include <climits>

using namespace std;

long long ans;

int n;
string s;

long long cal(int a, int b, char oper)
{

    if (oper == '+')
    {
        return a + b;
    }
    else if (oper == '-')
    {
        return a - b;
    }
    else if (oper == '*')
    {
        return a * b;
    }
    return 0;
}

void findMax(long long curVal, int idx)
{
    if (idx >= n - 1)
    {
        ans = max(curVal, ans);
        return;
    }
    if (idx < n - 4)
    {

        int nextValue = cal(s[idx + 2] - '0', s[idx + 4] - '0', s[idx + 3]);

        int nextInput = cal(curVal, nextValue, s[idx + 1]);
        findMax(nextInput, idx + 4);
    }
    findMax(cal(curVal, s[idx + 2] - '0', s[idx + 1]), idx + 2);
}

int main()
{

    ans = INT_MIN;
    cin >> n;

    cin >> s;

    findMax(s[0] - '0', 0);
    cout << ans << endl;
    return 0;
}