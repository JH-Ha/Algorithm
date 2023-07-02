# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {TreeNode} root
# @return {TreeNode}
def invert_tree(root)
    if(root == nil)
        return nil
    end
    left = invert_tree(root.right)
    right = invert_tree(root.left)
    root.left = left
    root.right = right
    return root
end