#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    long long mask = 0;
    long long all = 0;
    for (int i = 0; i <= 20; i++)
    {
        all += 1 << i;
    }
    //string answer = "";
    for (int i = 0; i < n; i++)
    {
        string s;
        int input;
        cin >> s;
        if (s == "add")
        {
            cin >> input;
            mask |= (1 << input);
        }
        else if (s == "check")
        {
            cin >> input;
            if ((mask >> input) % 2 == 1)
            {
                // answer += "1\n";
                cout << 1 << '\n';
            }
            else
            {
                // answer += "0\n";
                cout << 0 << '\n';
            }
        }
        else if (s == "remove")
        {
            cin >> input;
            if ((mask >> input) % 2 == 1)
            {
                mask -= 1 << input;
            }
        }
        else if (s == "toggle")
        {
            cin >> input;
            mask ^= 1 << input;
        }
        else if (s == "all")
        {
            mask = all;
        }
        else if (s == "empty")
        {
            mask = 0;
        }
    }
    //cout << answer;
    return 0;
}