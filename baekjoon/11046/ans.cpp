#include <iostream>
#include <cstdio>
#include <algorithm>
#include <string>
#include <memory.h>

using namespace std;

typedef pair<int, int> pii;

const int MAXN = 23 * 2;

int str[MAXN];
int A[MAXN];

void manachers(int *S, int N)
{
    int r = 0, p = 0;
    for (int i = 0; i < N; i++)
    {
        if (i <= r)
            A[i] = min(A[2 * p - i], r - i);
        else
            A[i] = 0;

        while (i - A[i] - 1 >= 0 && i + A[i] + 1 < N && S[i - A[i] - 1] == S[i + A[i] + 1])
            A[i]++;

        if (r < i + A[i])
        {
            r = i + A[i];
            p = i;
        }
    }
}
int main()
{
    int n;
    scanf("%d", &n);

    int len = 0;
    for (int i = 0; i < n * 2 - 1; i++)
    {
        int val;
        scanf("%d", &val);
        str[i] = val;
        i++;
        len++;
        str[i] = -1;
        len++;
    }

    manachers(str, len - 1);

    int q;
    scanf("%d", &q);
    while (q--)
    {
        int s, e;
        scanf("%d %d", &s, &e);
        s--, e--;
        s *= 2;
        e *= 2;

        int r = A[(s + e) / 2];

        if ((s + e) / 2 + r >= e)
            printf("1\n");
        else
            printf("0\n");
    }

    return 0;
}
