#include <iostream>
#include <cmath>

using namespace std;

int numLen(int num)
{
    int len = 0;
    while (num > 0)
    {
        num++;
        num /= 10;
    }
    return len;
}

int main()
{
    int r1, c1, r2, c2;
    cin >> r1 >> c1 >> r2 >> c2;

    int p1 = max(abs(r1), abs(c1));
    int p2 = max(abs(r2), abs(c2));
    int p1Width = p1 * 2 + 1;
    int p2Width = p2 * 2 + 1;
    int maxSize = max(p1Width * p1Width, p2Width * p2Width);
    int maxLen = 0;
    cout << maxSize << endl;
    while (maxSize > 0)
    {
        maxLen++;
        maxSize /= 10;
    }
    for (int i = r1; i <= r2; i++)
    {
        for (int j = c1; j <= c2; j++)
        {
            int maxIdx = max(abs(i), abs(j));
            int width = maxIdx * 2 + 1;
            int lastNum = (width - 2) * (width - 2);
            //         cout << "max Idx " << maxIdx << endl;
            //cout << "last " << lastNum << endl;
            if (i == -maxIdx)
            {
                int startNum = lastNum + (width - 1);
                int num = startNum - j - i;
                int len = numLen(num);
                for (int i = 0; i < maxLen - len; i++)
                {
                    cout << " ";
                }
                cout << startNum - j - i << " ";
                //printf(format, startNum - j - i);
            }
            else if (j == -maxIdx)
            {
                int startNum = lastNum + (width - 1) * 2;
                cout << startNum - j + i << " ";
            }
            else if (i == maxIdx)
            {
                int startNum = lastNum + (width - 1) * 3;
                cout << startNum + i + j << " ";
            }
            else if (j == maxIdx)
            {
                int startNum = lastNum;
                cout << startNum + i + j << " ";
            }
        }
        cout << endl;
    }
    return 0;
}