#include <iostream>
#include <queue>

using namespace std;

int main()
{
    int n;

    priority_queue<int> pqPositive;
    priority_queue<int> pqNegative;

    cin >> n;
    string ans = "";
    for (int i = 0; i < n; i++)
    {
        int input;
        cin >> input;
        if (input > 0)
        {
            pqPositive.push(-input);
        }
        else if (input < 0)
        {
            pqNegative.push(input);
        }
        else
        {
            if (pqPositive.empty() && pqNegative.empty())
            {
                ans += "0\n";
            }
            else if (pqPositive.empty() && !pqNegative.empty())
            {
                int pop = pqNegative.top();
                ans += to_string(pop) + "\n";
                pqNegative.pop();
            }
            else if (!pqPositive.empty() && pqNegative.empty())
            {
                int pop = -pqPositive.top();
                ans += to_string(pop) + "\n";
                pqPositive.pop();
            }
            else
            {
                int pTop = -pqPositive.top();
                int nTop = -pqNegative.top();
                if (nTop <= pTop)
                {
                    ans += to_string(-nTop) + "\n";
                    pqNegative.pop();
                }
                else
                {
                    ans += to_string(pTop) + "\n";
                    pqPositive.pop();
                }
            }
        }
    }
    cout << ans;

    return 0;
}