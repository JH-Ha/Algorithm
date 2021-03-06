#include <iostream>
#include <cmath>

using namespace std;

int numLen(int num)
{
    int len = 0;
    while (num > 0)
    {
        len++;
        num /= 10;
    }
    return len;
}
int findMax(int r1, int c1, int r2, int c2)
{
    int maxNum = 0;
    for (int i = r1; i <= r2; i++)
    {
        for (int j = c1; j <= c2; j++)
        {
            int maxIdx = max(abs(i), abs(j));
            int width = maxIdx * 2 + 1;
            int lastNum = (width - 2) * (width - 2);
            int num;
            if (i == -maxIdx)
            {
                int startNum = lastNum + (width - 1);
                num = startNum - j - i;
            }
            else if (j == -maxIdx)
            {
                int startNum = lastNum + (width - 1) * 2;
                num = startNum - j + i;
            }
            else if (i == maxIdx)
            {
                int startNum = lastNum + (width - 1) * 3;
                num = startNum + i + j;
            }
            else if (j == maxIdx)
            {
                int startNum = lastNum;
                num = startNum - i + j;
            }
            maxNum = max(num, maxNum);
        }
    }
    return maxNum;
}

int main()
{
    int r1, c1, r2, c2;
    cin >> r1 >> c1 >> r2 >> c2;

    int maxSize = findMax(r1, c1, r2, c2);
    int maxLen = 0;
    //cout << maxSize << endl;
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
                //cout << "len " << maxLen << " " << len;
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
                int num = startNum - j + i;
                int len = numLen(num);
                for (int i = 0; i < maxLen - len; i++)
                {
                    cout << " ";
                }
                cout << startNum - j + i << " ";
            }
            else if (i == maxIdx)
            {
                int startNum = lastNum + (width - 1) * 3;
                int num = startNum + i + j;
                int len = numLen(num);
                for (int i = 0; i < maxLen - len; i++)
                {
                    cout << " ";
                }
                cout << startNum + i + j << " ";
            }
            else if (j == maxIdx)
            {
                int startNum = lastNum;
                int num = startNum - i + j;
                int len = numLen(num);
                for (int i = 0; i < maxLen - len; i++)
                {
                    cout << " ";
                }
                cout << startNum - i + j << " ";
            }
        }
        cout << endl;
    }
    return 0;
}