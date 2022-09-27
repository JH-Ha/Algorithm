#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>

using namespace std;

struct ListNode
{
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class Solution
{
public:
    ListNode *removeNthFromEnd(ListNode *head, int n)
    {
        int sz = 0;
        ListNode *cur = head;
        while (cur != nullptr)
        {
            sz++;
            cur = cur->next;
        }
        int removeIdx = sz - n;
        if (removeIdx == 0)
        {
            return head->next;
        }
        else if (removeIdx == sz - 1)
        {
            cur = head;
            for (int i = 0; i < removeIdx - 1; i++)
            {
                cur = cur->next;
            }
            cur->next = nullptr;
            return head;
        }
        else
        {
            cur = head;
            for (int i = 0; i < removeIdx - 1; i++)
            {
                cur = cur->next;
            }
            cur->next = cur->next->next;
            return head;
        }
    }
};
int main()
{
    Solution solution;
    // solution.removeNthFromEnd(null, 1)

    return 0;
}