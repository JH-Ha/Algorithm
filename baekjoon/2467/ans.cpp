#include <iostream>

using namespace std;
long long arr[100010];
int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int l = 0, r = n - 1;
    pair<int, int> ans = make_pair(arr[l], arr[r]);
    long long sum = abs(arr[l] + arr[r]);
    while (l < r)
    {
        long long localSum = abs(arr[l] + arr[r]);
        if (localSum < sum)
        {
            sum = localSum;
            ans = make_pair(arr[l], arr[r]);
        }
        if (arr[l] + arr[r] < 0)
        {
            l++;
        }
        else if (arr[l] + arr[r] > 0)
        {
            r--;
        }
        else
        {
            break;
        }
    }
    cout << ans.first << " " << ans.second << '\n';
    return 0;
}