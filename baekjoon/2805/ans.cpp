#include <iostream>
#include <algorithm>

using namespace std;

long long myLog[1000010];

int main()
{
    long long n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> myLog[i];
    }
    long long l = 0, r = INT32_MAX;
    long long answer = 0;
    while (l <= r)
    {
        long long sum = 0;
        long long mid = (l + r) / 2;
        for (int i = 0; i < n; i++)
        {
            long long diff = myLog[i] - mid;
            if (diff > 0)
            {
                sum += diff;
            }
        }
        if (sum >= m)
        {
            //cout << " mid : " << mid << endl;
            answer = max(mid, answer);
            l = mid + 1;
        }
        else
        {
            r = mid - 1;
        }
    }
    //cout << "l : " << l << " r : " << r << endl;
    cout << answer << endl;
    return 0;
}