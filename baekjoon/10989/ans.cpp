#include <iostream>

using namespace std;

int n;

int c[10010];
//int a[10000010];
//int b[10000010];
int main()
{
    ios::sync_with_stdio(false);

    cin >> n;
    for (int i = 0; i < 10010; i++)
    {
        c[i] = 0;
    }
    for (int i = 0; i < n; i++)
    {
        int a;
        cin >> a;
        c[a]++;
    }

    for (int i = 0; i < 10010; i++)
    {
        for (int j = 0; j < c[i]; j++)
        {
            printf("%d\n", i);
        }
    }
    return 0;
}