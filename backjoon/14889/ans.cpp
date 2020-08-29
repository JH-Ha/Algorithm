#include <iostream>

using namespace std;

int n;

int s[25][25];
int sTeam[25];
int aNum = 0;
int bNum = 0;
int aSum = 0;
int bSum = 0;
int diff = 99999999;
void find()
{
    if (aNum == 0 && bNum == 0)
    {
        int localDiff = aSum - bSum;
        if (localDiff < 0)
            localDiff = -localDiff;
        diff = min(diff, localDiff);
        return;
    }
    for (int i = 0; i < n; i++)
    {
        if (sTeam[i] == 0)
        {

            int aSumTemp = 0;
            int bSumTemp = 0;
            if (aNum > 0)
            {
                sTeam[i] = 1;
                aNum--;

                for (int j = 0; j < n; j++)
                {
                    if (sTeam[j] == 1)
                    {
                        aSumTemp = aSumTemp + s[i][j] + s[j][i];
                    }
                }
                aSum += aSumTemp;
                find();
                aNum++;
                aSum -= aSumTemp;
                sTeam[i] = 0;
            }
            if (bNum > 0)
            {
                sTeam[i] = 2;
                bNum--;
                for (int j = 0; j < n; j++)
                {
                    if (sTeam[j] == 2)
                    {
                        bSumTemp = bSumTemp + s[i][j] + s[j][i];
                    }
                }
                bSum += bSumTemp;
                find();
                bNum++;
                bSum -= bSumTemp;
                sTeam[i] = 0;
            }
            return;
        }
    }
}

int main()
{

    cin >> n;
    aNum = bNum = n / 2;
    for (int i = 0; i < n; i++)
    {
        sTeam[i] = 0;
        for (int j = 0; j < n; j++)
        {
            cin >> s[i][j];
        }
    }
    find();
    cout << diff << endl;

    return 0;
}