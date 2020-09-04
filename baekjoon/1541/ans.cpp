#include <iostream>
#include <string>
#include <cmath>
#include <vector>

using namespace std;
string s;
int num[50];
char oper[50];
int cnt = 0;
vector<int> minusV;

int main()
{

    cin >> s;
    int startIdx = 0;

    for (int i = 0; i < s.size(); i++)
    {
        if (s[i] == '+' || s[i] == '-')
        {
            if (s[i] == '-')
                minusV.push_back(cnt);
            int numTemp = 0;
            for (int j = startIdx; j < i; j++)
            {
                numTemp += (s[j] - '0') * pow(10, i - j - 1);
            }
            num[cnt] = numTemp;
            oper[cnt] = s[i];
            startIdx = i + 1;
            cnt++;
        }
    }
    int numTemp = 0;
    for (int j = startIdx; j < s.size(); j++)
    {
        numTemp += (s[j] - '0') * pow(10, s.size() - j - 1);
    }
    num[cnt] = numTemp;
    cnt++;
    if (cnt == 1)
    {
        cout << num[0] << endl;
        return 0;
    }
    int prev = 0;
    int endIdx = 0;
    if (minusV.empty())
    {
        endIdx = cnt - 1;
    }
    else
    {
        endIdx = minusV[0];
    }
    for (int i = 0; i <= endIdx; i++)
    {
        prev += num[i];
    }
    if (minusV.empty())
    {
        cout << prev << endl;
        return 0;
    }

    for (int i = 0; i < minusV.size(); i++)
    {
        int idx = minusV[i];
        int nextIdx = 0;
        if (i == minusV.size() - 1)
        {
            nextIdx = cnt - 1;
        }
        else
        {
            nextIdx = minusV[i + 1];
        }
        int sum = 0;
        for (int j = idx + 1; j <= nextIdx; j++)
        {
            sum += num[j];
        }
        //cout << "idx : " << idx << " nextIdx : " << nextIdx << " sum : " << sum << endl;
        prev -= sum;
    }
    cout << prev << endl;

    return 0;
}