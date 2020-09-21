#include <iostream>

using namespace std;

long long power(long long x, long long n, long long mod)
{
    if (n == 0)
    {
        return 1;
    }
    if (n % 2 == 1)
    {
        return (x * power(x, n - 1, mod)) % mod;
    }
    else
    {
        long long x2 = power(x, n / 2, mod);
        return (x2 * x2) % mod;
    }
}

int main()
{
    int n, k;
    cin >> n >> k;
    long long p = 1000000007;
    long long up = 1;
    long long down = 1;
    for (int i = n - k + 1; i <= n; i++)
    {
        up = (up * i) % p;
    }
    for (int i = 1; i <= k; i++)
    {
        down = (down * i) % p;
    }
    long long answer = (up * power(down, p - 2, p)) % p;
    cout << answer << endl;
    return 0;
}