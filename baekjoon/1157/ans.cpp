#include <iostream>
#include <string>

using namespace std;

int cnt[26];

int main()
{
    string s;
    cin >> s;
    for (int i = 0; i < 26; i++)
    {
        cnt[i] = 0;
    }
    for (int i = 0; i < s.size(); i++)
    {
        char c = s[i];
        if (c >= 65 && c <= 90)
        {
            cnt[c - 65]++;
        }
        else
        {
            cnt[c - 97]++;
        }
    }
    int maxNum = 0;
    int maxNumNum = 0;
    char maxChar = 0;
    for (int i = 0; i < 26; i++)
    {
        if (cnt[i] > maxNum)
        {
            maxNum = cnt[i];
            maxNumNum = 1;
            maxChar = i + 65;
        }
        else if (cnt[i] == maxNum)
        {
            maxNumNum++;
        }
    }

    if (maxNumNum == 1)
    {
        cout << maxChar << '\n';
    }
    else
    {
        cout << "?" << '\n';
    }

    return 0;
}