#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
    string t, p;
    getline(cin, t);
    getline(cin, p);

    int tSize = t.size();
    int pSize = p.size();
    int fail[1000010] = {0};

    vector<int> result;
    for (int i = 1, j = 0; i < pSize; i++)
    {
        while (j > 0 && p[i] != p[j])
            j = fail[j - 1];
        if (p[i] == p[j])
            fail[i] = ++j;
    }
    for (int i = 0, j = 0; i < tSize; i++)
    {
        while (j > 0 && t[i] != p[j])
            j = fail[j - 1];
        if (t[i] == p[j])
        {
            if (j == pSize - 1)
            {
                result.push_back(i - pSize + 2);
                j = fail[j];
            }
            else
            {
                j++;
            }
        }
    }
    printf("%ld\n", result.size());
    for (int i : result)
    {
        printf("%d ", i);
    }
    cout << '\n';
    return 0;
}