#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <stack>
#include <queue>
#include <string>

using namespace std;

// Definition for a binary tree node.
struct TreeNode
{
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution
{
public:
    vector<vector<int>> levelOrder(TreeNode *root)
    {
        vector<vector<int>> answer;
        queue<pair<TreeNode *, int>> q;
        if (root != nullptr)
        {
            q.push({root, 0});
        }

        int curIdx = -1;
        while (!q.empty())
        {
            pair<TreeNode *, int> top = q.front();
            q.pop();
            if (curIdx < top.second)
            {
                curIdx++;
                vector<int> a;
                answer.push_back(a);
            }
            answer[top.second].push_back(top.first->val);
            if (top.first->left != nullptr)
            {
                q.push({top.first->left, top.second + 1});
            }
            if (top.first->right != nullptr)
            {
                q.push({top.first->right, top.second + 1});
            }
        }
        return answer;
    }
};