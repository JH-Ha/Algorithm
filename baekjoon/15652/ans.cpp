#include <iostream>
#include <vector>
using namespace std;

bool used[10];
vector<int> v;
int n, m;
int last = -1;
void combination(int depth)
{
    if (depth == 0)
    {
        for (int i = 0; i < v.size(); i++)
        {
            cout << v[i] + 1 << " ";
        }
        cout << "\n";
    }
    else
    {
        for (int i = 0; i < n; i++)
        {
            if (i >= last)
            {
                int prev = last;
                last = i;
                v.push_back(i);
                combination(depth - 1);
                v.pop_back();
                last = prev;
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);

    cin >> n >> m;
    for (int i = 0; i < n; i++)
    {
        used[i] = false;
    }
    combination(m);
    return 0;
}