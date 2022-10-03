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
    ListNode *reverseKGroup(ListNode *head, int k)
    {
        ListNode *answerHead = new ListNode();
        ListNode *answerLast;
        ListNode *leftNode = head;
        int cnt = 0;
        for (int i = 0; i < k && leftNode != nullptr; i++)
        {
            if (answerHead->next != nullptr)
            {
                ListNode *temp = answerHead->next;
                answerHead->next = new ListNode(leftNode->val);
                answerHead->next->next = temp;
            }
            else
            {
                answerHead->next = new ListNode(leftNode->val);
                answerLast = answerHead->next;
            }
            leftNode = leftNode->next;
            cnt++;
        }
        if (cnt < k)
        {
            return head;
        }
        answerLast->next = reverseKGroup(leftNode, k);
        return answerHead->next;
    }
};

int main()
{
    Solution solution;
    ListNode *head = new ListNode(1);
    head->next = new ListNode(2);
    ListNode *answer = solution.reverseKGroup(head, 2);
    while (answer != nullptr)
    {
        cout << answer->val << endl;
        answer = answer->next;
    }

    return 0;
}