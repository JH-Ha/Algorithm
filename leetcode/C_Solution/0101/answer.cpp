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
    void convert(TreeNode *root)
    {
        if (root == nullptr)
            return;
        TreeNode *tmp = root->left;
        root->left = root->right;
        root->right = tmp;
        convert(root->left);
        convert(root->right);
    }
    bool isSameTreeNode(TreeNode *a, TreeNode *b)
    {
        if (a == nullptr && b == nullptr)
            return true;
        else if (a == nullptr && b != nullptr)
            return false;
        else if (a != nullptr && b == nullptr)
            return false;
        bool isSame = true;
        if (a->val == b->val)
        {
            isSame &= isSameTreeNode(a->left, b->left);
            isSame &= isSameTreeNode(a->right, b->right);
        }
        else
        {
            isSame = false;
        }
        return isSame;
    }
    bool isSymmetric(TreeNode *root)
    {
        convert(root->right);
        return isSameTreeNode(root->left, root->right);
    }
};