#include <iostream>

using namespace std;
int a[1010];
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int n, k;
        cin >> n >> k;
        int minA = 10010;
        int minIdx = 0;
        for (int i = 0; i < n; i++)
        {
            cin >> a[i];
            if (a[i] < minA)
            {
                minA = a[i];
                minIdx = i;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++)
        {
            if (i == minIdx)
                continue;
            answer += (k - a[i]) / minA;
        }
        cout << answer << endl;
    }

    return 0;
}