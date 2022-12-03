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
    int preorderIndex;
    TreeNode *buildTree(vector<int> &preorder, vector<int> &inorder)
    {
        unordered_map<int, int> inorderIndexMap;
        preorderIndex = 0;
        for (int i = 0; i < inorder.size(); i++)
        {
            inorderIndexMap.insert({inorder[i], i});
        }

        return vectorToTree(preorder, 0, preorder.size() - 1, inorderIndexMap);
    }

    TreeNode *vectorToTree(vector<int> &preorder, int left, int right, unordered_map<int, int> &inorderIndexMap)
    {
        if (left > right)
            return nullptr;

        int rootValue = preorder[preorderIndex++];
        TreeNode *root = new TreeNode(rootValue);

        root->left = vectorToTree(preorder, left, inorderIndexMap.find(rootValue)->second - 1, inorderIndexMap);
        root->right = vectorToTree(preorder, inorderIndexMap.find(rootValue)->second + 1, right, inorderIndexMap);
        return root;
    }
};

int main()
{
    Solution s;
    vector<int> preorder = {1, 2};
    vector<int> inorder = {1, 2};
    cout << s.buildTree(preorder, inorder) << endl;
    return 0;
}