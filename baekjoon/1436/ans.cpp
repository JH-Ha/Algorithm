#include <iostream>
#include <vector>

using namespace std;

#define MAX_END_NUM 2666801

vector<int> endNumVec;

int main()
{
    int n;
    cin >> n;
    for (int i = 1; i < MAX_END_NUM; i++)
    {
        int cntSix = 0;
        int num = i;
        bool beforeSix = true;
        while (num > 0)
        {
            int last = num % 10;
            if (last == 6)
            {
                if (beforeSix)
                {
                    cntSix++;
                }
                else
                {
                    beforeSix = true;
                    cntSix = 1;
                }
            }
            else
            {
                beforeSix = false;
            }
            if (cntSix == 3)
            {
                endNumVec.push_back(i);
                break;
            }
            num = num / 10;
        }
    }
    cout << endNumVec[n - 1] << '\n';
    return 0;
}