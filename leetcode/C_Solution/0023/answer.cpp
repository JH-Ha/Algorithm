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
    ListNode *mergeTwo(ListNode *a, ListNode *b)
    {
        ListNode *head = new ListNode();
        ListNode *cur = head;
        while (a != nullptr && b != nullptr)
        {
            if (a->val < b->val)
            {
                cur->next = new ListNode(a->val);
                a = a->next;
            }
            else
            {
                cur->next = new ListNode(b->val);
                b = b->next;
            }
            cur = cur->next;
        }
        if (a != nullptr)
        {
            cur->next = a;
        }
        if (b != nullptr)
        {
            cur->next = b;
        }
        return head->next;
    }
    ListNode *mergeKLists(vector<ListNode *> &lists)
    {
        if (lists.size() == 0)
        {
            return nullptr;
        }
        else if (lists.size() == 1)
        {
            return lists[0];
        }
        else
        {
            vector<ListNode *> left;
            vector<ListNode *> right;
            for (int i = 0; i < lists.size(); i++)
            {
                if (i < lists.size() / 2)
                {
                    left.push_back(lists[i]);
                }
                else
                {
                    right.push_back(lists[i]);
                }
            }
            ListNode *leftMerge = mergeKLists(left);
            ListNode *rightMerge = mergeKLists(right);
            return mergeTwo(leftMerge, rightMerge);
        }
    }
};
int main()
{
    Solution solution;
    // solution.removeNthFromEnd(null, 1)

    return 0;
}