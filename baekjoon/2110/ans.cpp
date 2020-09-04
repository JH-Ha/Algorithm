#include <iostream>
#include <algorithm>
using namespace std;

int x[200010];

int main()
{
    int n, c;
    cin >> n >> c;
    for (int i = 0; i < n; i++)
    {
        cin >> x[i];
    }
    sort(x, x + n);
    int r = x[n - 1] - x[0];
    int l = 1;
    int ans = 0;
    while (l <= r)
    {
        int mid = (l + r) / 2;
        int prev = x[0];
        int num = 1;
        for (int i = 1; i < n; i++)
        {
            if (mid <= x[i] - prev)
            {
                prev = x[i];
                num++;
            }
        }
        //cout << "num : " << num << " l: " << l << " r: " << r << " mid: " << mid << endl;
        if (num >= c)
        {
            ans = mid;
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
        }
    }
    cout << ans << endl;

    return 0;
}