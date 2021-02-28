#include <iostream>
#include <algorithm>

using namespace std;
long long a[4010], b[4010], c[4010], d[4010];
long long ab[16000010], cd[16000010];
int main()
{
    int n;

    cin >> n;
    int nn = n * n;
    for (int i = 0; i < n; i++)
    {
        cin >> a[i] >> b[i] >> c[i] >> d[i];
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            ab[n * i + j] = a[i] + b[j];
            cd[n * i + j] = c[i] + d[j];
        }
    }
    sort(cd, cd + nn);
    long long ans = 0;
    for (int i = 0; i < nn; i++)
    {
        int left = 0;
        int right = nn - 1;
        int l, r;
        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (ab[i] + cd[mid] > 0)
            {
                right = mid - 1;
            }
            else
            {
                left = mid + 1;
            }
        }
        r = right;
        left = 0;
        right = nn - 1;
        while (left <= right)
        {
            int mid = (left + right) / 2;

            if (ab[i] + cd[mid] < 0)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
        }
        l = left;
        if (l <= r)
        {
            ans += (r - l + 1);
        }
    }
    cout << ans << endl;
    return 0;
}