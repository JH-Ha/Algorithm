#include <iostream>

using namespace std;

long long num[1000010];

long long count(int n)
{
    if (num[n] == -1)
    {
        num[n] = count(n - 1) + count(n - 2);
        return num[n] % 15746;
    }
    else
    {
        return num[n] % 15746;
    }
}

int main()
{
    for (int i = 0; i < 1000010; i++)
    {
        num[i] = -1;
    }
    num[0] = 1;
    num[1] = 1;

    int n;
    cin >> n;
    cout << count(n) << endl;
    return 0;
}