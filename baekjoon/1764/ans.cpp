#include <iostream>
#include <unordered_map>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

unordered_map<string, int> kiku;
vector<string> answer;
int main()
{
    int n, m;
    cin >> n >> m;
    string s;
    for (int i = 0; i < n; i++)
    {
        cin >> s;
        kiku.insert(make_pair(s, 0));
    }
    unordered_map<string, int>::iterator iter;
    for (int i = 0; i < m; i++)
    {
        cin >> s;
        iter = kiku.find(s);
        if (iter != kiku.end())
        {
            answer.push_back(s);
        }
    }
    sort(answer.begin(), answer.end());
    string a = "";
    for (int i = 0; i < answer.size(); i++)
    {
        a += answer[i] + '\n';
    }
    cout << answer.size() << '\n'
         << a;
    return 0;
}