#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> a;

int main()
{
    int n;
    cin >> n;

    for (int i = 0; i < n; i++)
    {
        int input;
        cin >> input;
        a.push_back(input);
    }
    sort(a.begin(), a.end());
    string ans = "";
    int m;
    cin >> m;
    for (int i = 0; i < m; i++)
    {
        int l = 0, r = n - 1;
        int b;
        cin >> b;
        bool exist = false;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (a[mid] == b)
            {
                exist = true;
                //cout << "b : " << b << endl;
                break;
            }
            else if (a[mid] < b)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        if (exist)
        {
            ans += "1\n";
        }
        else
        {
            ans += "0\n";
        }
    }
    cout << ans;
    return 0;
}