#include <iostream>

using namespace std;

long long arr[110];

long long padovan(int n)
{
    if (arr[n] == -1)
    {
        arr[n] = padovan(n - 1) + padovan(n - 5);
    }
    return arr[n];
}

int main()
{

    for (int i = 1; i <= 100; i++)
    {
        arr[i] = -1;
    }
    arr[1] = arr[2] = arr[3] = 1;
    arr[4] = arr[5] = 2;
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        cout << padovan(n) << endl;
    }
    return 0;
}