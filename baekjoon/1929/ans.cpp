#include <iostream>
#include <set>

using namespace std;
#define maxNum 1000010
bool isPrime[1000010];

int main()
{
    int m;
    int n;
    cin >> m >> n;
    for (int i = 0; i <= maxNum; i++)
    {
        isPrime[i] = true;
    }
    for (int i = 2; i <= maxNum; i++)
    {
        if (isPrime[i])
        {
            for (int j = i * i; j <= maxNum; j += i)
            {
                isPrime[j] = false;
            }
        }
    }
    for (int i = m; i <= n; i++)
    {
        if (isPrime[i])
        {
            cout << i << '\n';
        }
    }
    return 0;
}