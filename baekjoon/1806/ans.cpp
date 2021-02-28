#include <iostream>
#include <algorithm>

using namespace std;

long long arr[100010];

int main()
{
    long long n, s;
    cin >> n >> s;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    long long l, r;
    l = r = 0;
    long long sum = arr[0];
    long long ans = INT32_MAX;
    while (l <= r && r < n)
    {
        //cout << "sum : " << sum << " l " << l << " r " << r << endl;
        if (sum >= s)
        {
            ans = min(ans, r - l + 1);
            sum -= arr[l];
            l++;
        }
        else
        {
            r++;
            sum += arr[r];
        }
    }
    if (ans == INT32_MAX)
    {
        printf("0\n");
    }
    else
    {
        printf("%lld\n", ans);
    }

    return 0;
}