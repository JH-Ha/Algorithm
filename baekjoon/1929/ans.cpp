#include <iostream>
#include <set>

using namespace std;
#define maxNum 1000010
bool isPrime[1000011];

int main()
{
    long long m;
    long long n;
    cin >> m >> n;
    for (long long i = 0; i <= maxNum; i++)
    {
        isPrime[i] = true;
    }
    for (long long i = 2; i <= maxNum; i++)
    {
        if (isPrime[i])
        {
            for (long long j = i * i; j <= maxNum; j += i)
            {
                isPrime[j] = false;
            }
        }
    }
    for (long long i = m; i <= n; i++)
    {
        if (isPrime[i])
        {
            cout << i << '\n';
        }
    }
    return 0;
}