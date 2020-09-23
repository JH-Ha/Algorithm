#include <iostream>

using namespace std;

int main()
{
    int maxNum = -1;
    int maxIdx = 0;
    for (int i = 0; i < 9; i++)
    {
        int n;
        cin >> n;
        if (n > maxNum)
        {
            maxNum = n;
            maxIdx = i + 1;
        }
    }
    cout << maxNum << '\n';
    cout << maxIdx << '\n';
    return 0;
}