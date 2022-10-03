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
    ListNode *mergeTwoLists(ListNode *list1, ListNode *list2)
    {
        ListNode *head = new ListNode();
        ListNode *cur = head;
        while (list1 != nullptr && list2 != nullptr)
        {
            if (list1->val < list2->val)
            {
                cur->next = new ListNode(list1->val);
                list1 = list1->next;
            }
            else
            {
                cur->next = new ListNode(list2->val);
                list2 = list2->next;
            }
            cur = cur->next;
        }
        if (list1 != nullptr)
        {
            cur->next = list1;
        }
        if (list2 != nullptr)
        {
            cur->next = list2;
        }
        return head->next;
    }
};

int main()
{
    Solution solution;
    // solution.removeNthFromEnd(null, 1)

    return 0;
}