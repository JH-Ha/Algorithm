#include <iostream>
#include <cmath>
#include <limits.h>
#define MAX_N 300001
using namespace std;

long long tree[MAX_N];
long long maxTree[MAX_N];
long long n, m;
long long s;

long long getMin(long long a, long long b)
{
    a += s;
    b += s;
    long long ans = INT_MAX;
    while (a <= b)
    {
        if (a % 2 == 1)
            ans = min(ans, tree[a++]);
        if (b % 2 == 0)
            ans = min(ans, tree[b--]);
        a /= 2;
        b /= 2;
    }
    return ans;
}
long long getMax(long long a, long long b)
{
    a += s;
    b += s;
    long long ans = 0;
    while (a <= b)
    {
        if (a % 2 == 1)
            ans = max(ans, maxTree[a++]);
        if (b % 2 == 0)
            ans = max(ans, maxTree[b--]);
        a /= 2;
        b /= 2;
    }
    return ans;
}

int main()
{

    cin >> n >> m;
    long long height = ceil(log2(n)) + 1;
    s = pow(2, height - 1);

    for (long long i = 0; i < MAX_N; i++)
    {
        tree[i] = INT_MAX;
        maxTree[i] = 0;
    }
    for (long long i = 0; i < n; i++)
    {
        long long input;
        cin >> input;
        long long index = s + i;
        tree[index] = input;
        maxTree[index] = input;
    }
    for (long long i = s - 1; i >= 1; i--)
    {
        long long leftChild = i * 2;
        long long rightChild = i * 2 + 1;
        tree[i] = min(tree[leftChild], tree[rightChild]);
        maxTree[i] = max(maxTree[leftChild], maxTree[rightChild]);
    }
    for (long long i = 0; i < m; i++)
    {
        long long a, b;
        scanf("%lld %lld", &a, &b);
        //cin >> a >> b;
        //prlong longf("%lld\n", get(1, a - 1, b - 1, 0, n - 1));
        printf("%lld %lld\n", getMin(a - 1, b - 1), getMax(a - 1, b - 1));
    }
    return 0;
}