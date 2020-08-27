#include <iostream>

using namespace std;

int ans = 0;
int n;

int diag1[30];
int diag2[30];
int column[15];
void queen(int depth)
{
    if (depth == 0)
    {
        ans++;
        return;
    }
    else
    {
        for (int j = 0; j < n; j++)
        {
            int i = n - depth;
            if (column[j] == 0 && diag1[i + j] == 0 && diag2[n - 1 - i + j] == 0)
            {
                column[j] = 1;
                diag1[i + j] = 1;
                diag2[n - 1 - i + j] = 1;
                queen(depth - 1);
                column[j] = 0;
                diag1[i + j] = 0;
                diag2[n - 1 - i + j] = 0;
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        column[i] = 0;
    }
    for (int i = 0; i < 2 * n; i++)
    {
        diag1[i] = 0;
        diag2[i] = 0;
    }
    queen(n);
    cout << ans << "\n";

    return 0;
}