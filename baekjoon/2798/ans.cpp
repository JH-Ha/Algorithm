#include <iostream>

using namespace std;

int num[300010];
int main()
{
    int n, m;
    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        cin >> num[i];
    }
    int diff = m;
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        int sum;
        for (int j = 0; j < n; j++)
        {
            if (i == j)
                continue;
            for (int k = 0; k < n; k++)
            {
                if (i == k || j == k)
                    continue;
                sum = num[i] + num[j] + num[k];
                //cout << sum << endl;
                if ((sum <= m) && ((m - sum) <= diff))
                {
                    diff = m - sum;
                    ans = sum;
                }
            }
        }
    }
    cout << ans << endl;
    return 0;
}