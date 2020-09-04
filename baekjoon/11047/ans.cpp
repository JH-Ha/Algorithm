#include <iostream>

using namespace std;

int coin[20];

int main()
{
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; i++)
    {
        int input;
        cin >> input;
        coin[i] = input;
    }
    int ans = 0;
    for (int i = n - 1; i >= 0; i--)
    {
        int q = k / coin[i];
        k = k % coin[i];
        ans += q;
    }
    cout << ans << endl;
    return 0;
}