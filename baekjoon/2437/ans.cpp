#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int w[1010];

int main()
{
    int n;
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> w[i];
    }
    sort(w, w + n);

    int sum = 0;
    int ans = 0;
    for (int i = 0; i < n; i++)
    {
        if (w[i] > sum + 1)
        {
            break;
        }
        sum += w[i];
    }
    ans = sum + 1;
    cout << ans << endl;
    return 0;
}