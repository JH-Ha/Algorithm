#include <iostream>
#include <string>
#include <vector>

using namespace std;

string solution(string p)
{
    string answer = "";
    //빈 문자열일 경우 빈 문자열 반환
    if (p.size() == 0)
        return answer;

    int leftCnt = 0;
    int rightCnt = 0;
    int idx = 0;
    bool checkGood = true;
    for (int i = 0; i < p.size(); i++)
    {
        if (p[i] == '(')
        {
            leftCnt++;
        }
        else
        {
            rightCnt++;
        }
        if (rightCnt > leftCnt)
        {
            checkGood = false;
        }
        if (leftCnt == rightCnt)
        {
            idx = i;
            break;
        }
    }
    //두 균형잡힌 괄호 문자열 u,v로 분리
    //cout << idx << endl;
    string u, v;
    u = p.substr(0, idx + 1);
    v = p.substr(idx + 1, p.size() - idx - 1);
    //cout << u << " " << v << endl;
    if (checkGood)
    {
        answer += u + solution(v);
    }
    else
    {
        answer += "(" + solution(v) + ")";
        u = u.substr(1, u.size() - 2);
        for (int i = 0; i < u.size(); i++)
        {
            if (u[i] == '(')
                u[i] = ')';
            else
                u[i] = '(';
        }
        answer += u;
    }
    //cout << u << endl;
    return answer;
}

int main()
{
    string s;
    cin >> s;
    cout << solution(s) << endl;
    return 0;
}