#include <iostream>

using namespace std;

int cnt[1000010];

int main()
{
    cnt[1] = 0;
    cnt[2] = 1;
    cnt[3] = 1;
    for (int i = 4; i < 1000010; i++)
    {
        int localCnt = 999999999;
        localCnt = min(cnt[i - 1] + 1, localCnt);
        localCnt = min(cnt[i - 2] + 2, localCnt);
        if (i % 2 == 0)
        {
            localCnt = min(cnt[i / 2] + 1, localCnt);
        }
        if (i % 3 == 0)
        {
            localCnt = min(cnt[i / 3] + 1, localCnt);
        }
        cnt[i] = localCnt;
    }
    int n;
    cin >> n;
    cout << cnt[n] << endl;
    return 0;
}
