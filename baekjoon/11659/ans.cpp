#include <iostream>

using namespace std;

int arr[100010];
int sum[100010];

int main()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    cin >> n >> m;

    sum[0] = 0;
    for (int i = 1; i <= n; i++)
    {
        cin >> arr[i];
        sum[i] = sum[i - 1] + arr[i];
    }
    for (int i = 0; i < m; i++)
    {
        int a, b;
        cin >> a >> b;
        cout << sum[b] - sum[a - 1] << '\n';
    }
    return 0;
}