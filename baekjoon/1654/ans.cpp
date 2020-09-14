#include <iostream>
#include <algorithm>

using namespace std;

long long lan[10005];

int main()
{
    int k, n;
    long long maxLen = 0;
    cin >> k >> n;
    for (int i = 0; i < k; i++)
    {
        cin >> lan[i];
        maxLen = max(lan[i], maxLen);
    }
    long long l = 0;
    long long r = INT32_MAX;
    long long answer = l;
    while (l <= r)
    {
        long long num = 0;
        long long mid = (l + r) / 2;
        for (int i = 0; i < k; i++)
        {
            num += lan[i] / mid;
        }
        if (num >= n)
        {
            answer = max(answer, mid);
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
            //answer = r;
        }
    }
    //cout << l << " " << r << endl;
    //cout << r << endl;
    cout << answer << endl;

    return 0;
}