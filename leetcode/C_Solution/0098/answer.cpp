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
    bool isValidBST(TreeNode *root, int leftBound, int rightBound)
    {
        bool isValid = true;
        if (leftBound != -1)
        {
            if (root->val <= leftBound)
            {
                return false;
            }
        }
        if (rightBound != -1)
        {
            if (root->val >= rightBound)
            {
                return false;
            }
        }

        if (root->left != nullptr)
        {
            if (root->val <= root->left->val)
                return false;
            isValid &= isValidBST(root->left, leftBound, root->val);
        }
        if (root->right != nullptr)
        {
            if (root->val >= root->right->val)
                return false;
            isValid &= isValidBST(root->right, root->val, rightBound);
        }
        return isValid;
    }
    bool isValidBST(TreeNode *root)
    {
        return isValidBST(root, -1, -1);
    }
};

int main()
{
    TreeNode *root = new TreeNode(5);
    root->left = new TreeNode(4);
    root->right = new TreeNode(6);
    root->right->left = new TreeNode(3);
    root->right->right = new TreeNode(7);
    Solution s;
    cout << s.isValidBST(root) << endl;
    return 0;
}