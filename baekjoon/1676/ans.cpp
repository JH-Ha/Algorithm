#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int n;
    cin >> n;
    int fiveNum = 0;
    int twoNum = 0;
    int nTwo = n;
    int nFive = n;
    while (nTwo > 0)
    {
        nTwo = nTwo / 2;
        twoNum += nTwo;
    }
    while (nFive > 0)
    {
        nFive = nFive / 5;
        fiveNum += nFive;
    }
    int answer = min(fiveNum, twoNum);
    cout << answer << '\n';
    return 0;
}