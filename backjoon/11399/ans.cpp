#include <iostream>
#include <algorithm>

using namespace std;

int p[1010];
int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> p[i];
    }
    sort(p, p + n);
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        ans += p[i] * (n - i);
    }
    cout << ans << endl;
    return 0;
}