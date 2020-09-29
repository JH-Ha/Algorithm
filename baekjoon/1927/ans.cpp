#include <queue>
#include <iostream>

using namespace std;

int main()
{
    priority_queue<int> q;
    int n;
    cin >> n;
    string answer = "";
    for (int i = 0; i < n; i++)
    {
        int input;
        cin >> input;
        if (input == 0)
        {
            if (q.empty())
            {
                answer += "0\n";
            }
            else
            {
                int front = q.top();
                q.pop();
                answer += to_string(-front) + "\n";
            }
        }
        else
        {
            q.push(-input);
        }
    }
    cout << answer;
    return 0;
}