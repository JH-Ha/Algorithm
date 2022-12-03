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
    TreeNode *concat(TreeNode *a, TreeNode *b)
    {
        if (a == nullptr)
        {
            return b;
        }
        if (b == nullptr)
        {
            return a;
        }
        TreeNode *cur = a;
        while (cur->right != nullptr)
        {
            cur = cur->right;
        }
        cur->right = b;
        return a;
    }
    TreeNode *toLinked(TreeNode *root)
    {
        if (root == nullptr)
            return nullptr;
        TreeNode *answer = new TreeNode(root->val);
        TreeNode *left = toLinked(root->left);
        TreeNode *right = toLinked(root->right);
        answer->right = concat(left, right);
        return answer;
    }
    void flatten(TreeNode *root)
    {
        if (root == nullptr)
            return;
        TreeNode *linked = toLinked(root);
        root->left = nullptr;
        root->right = linked->right;
    }
};

int main()
{
    Solution s;
    return 0;
}