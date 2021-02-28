#include <iostream>
#include <map>

using namespace std;

int x[1000010];

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n;
    cin >> n;
    map<int, int> m;
    for (int i = 0; i < n; i++)
    {
        cin >> x[i];
        m.insert(make_pair(x[i], 1));
    }
    int idx = 0;
    for (auto it = m.begin(); it != m.end(); it++)
    {
        it->second = idx;
        idx++;
    }
    string s = "";
    for (int i = 0; i < n; i++)
    {
        s += to_string(m.find(x[i])->second) + " ";
    }
    s += "\n";
    cout << s;
    return 0;
}