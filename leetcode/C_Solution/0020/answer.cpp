#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>

using namespace std;

class Solution
{
public:
    bool isValid(string s)
    {
        stack<char> stack;
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.at(i);
            if (c == ')')
            {
                if (stack.size() == 0)
                    return false;
                char top = stack.top();
                stack.pop();
                if (top != '(')
                {
                    return false;
                }
            }
            else if (c == '}')
            {
                if (stack.size() == 0)
                    return false;
                char top = stack.top();
                stack.pop();
                if (top != '{')
                {
                    return false;
                }
            }
            else if (c == ']')
            {
                if (stack.size() == 0)
                    return false;
                char top = stack.top();
                stack.pop();
                if (top != '[')
                {
                    return false;
                }
            }
            else
            {
                stack.push(c);
            }
        }
        if (stack.size() != 0)
        {
            return false;
        }
        return true;
    }
};

int main()
{
    Solution solution;
    cout << solution.isValid("()[]{}") << endl;
    return 0;
}