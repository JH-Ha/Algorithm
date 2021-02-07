#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <cmath>
#include <unordered_set>

using namespace std;

int main()
{
    int n;
    cin >> n;
    unordered_map<char, int> map;
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < s.size(); j++)
        {
            unordered_map<char, int>::iterator got = map.find(s[j]);
            int num = pow(10, s.size() - j - 1);
            if (got == map.end())
            {
                map.insert({s[j], num});
            }
            else
            {
                got->second += num;
            }
        }
    }
    vector<pair<char, int>> cnt;
    for (auto i : map)
    {
        cnt.push_back(i);
    }
    sort(cnt.begin(), cnt.end(), [](pair<char, int> &a, pair<char, int> &b) -> bool {
        return a.second > b.second;
    });
    int ans = 0;
    int num = 9;
    for (int i = 0; i < cnt.size(); i++)
    {
        ans += cnt[i].second * num;
        num--;
    }
    cout << ans << endl;
    return 0;
}