#include <iostream>
#include <algorithm>
using namespace std;

//int a[100010];
int minNumLen = 0;
int minNum[1000010];

int main()
{
    int n;
    cin >> n;
    int input;
    for (int i = 0; i < n; i++)
    {
        minNum[i] = 1000010;
        //cin >> a[i];
        cin >> input;
        int l = 0, r = minNumLen;
        int pos = 1000010;
        while (l <= r)
        {
            int mid = (l + r) / 2;
            if (minNum[mid] >= input)
            {
                pos = min(mid, pos);
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        minNum[pos] = input;
        if (pos == minNumLen)
        {
            minNumLen++;
        }
        //cout << input << " pos : " << pos << " lenght : " << minNumLen << endl;
    }
    cout << minNumLen << '\n';
    return 0;
}