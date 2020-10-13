#include <iostream>
#include <algorithm>
#include <tuple>

using namespace std;

long long arr[5010];

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    sort(arr, arr + n);
    tuple<int, int, int> ans = make_tuple(arr[0], arr[1], arr[2]);
    long long total = arr[0] + arr[1] + arr[2];
    long long totalAbs = abs(total);
    for (int i = 0; i < n; i++)
    {
        int l = 0, r = n - 1;
        if (i == l)
        {
            l++;
        }
        if (r == i)
        {
            r--;
        }
        while (l < r)
        {
            long long localTotal = arr[i] + arr[l] + arr[r];
            long long localTotalAbs = abs(localTotal);
            if (localTotalAbs < totalAbs)
            {
                total = localTotal;
                totalAbs = localTotalAbs;
                ans = make_tuple(arr[i], arr[l], arr[r]);
            }
            if (localTotal < 0)
            {
                l++;
                if (l == i)
                {
                    l++;
                }
            }
            else if (localTotal > 0)
            {
                r--;
                if (r == i)
                {
                    r--;
                }
            }
            else
            {
                break;
            }
        }
    }
    long long ansSort[3];
    ansSort[0] = get<0>(ans);
    ansSort[1] = get<1>(ans);
    ansSort[2] = get<2>(ans);
    sort(ansSort, ansSort + 3);
    for (int i = 0; i < 3; i++)
    {
        printf("%lld ", ansSort[i]);
    }
    printf("\n");
    return 0;
}