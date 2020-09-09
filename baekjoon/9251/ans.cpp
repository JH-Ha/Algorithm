#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int lcs[1010][1010];

string s1, s2;


int main()
{
    
    cin >> s1 >> s2;
    for (int i = 0; i < 1010; i++)
    {
        lcs[0][i] = 0;
        lcs[i][0] = 0;
    }
    for (int i = 1; i <= s1.length(); i++)
    {
        for (int j = 1; j <= s2.length(); j++)
        {
            lcs[i][j] = max(lcs[i][j - 1] , lcs[i - 1][j]);
            if (s1[i - 1] == s2[j - 1])
                lcs[i][j] = lcs[i-1][j-1] + 1;
        }
    }    
   
    cout << lcs[s1.length()][s2.length()] << endl;
    return 0;
}