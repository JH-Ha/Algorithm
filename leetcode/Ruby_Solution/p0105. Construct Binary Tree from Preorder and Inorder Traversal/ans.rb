# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {Integer[]} preorder
# @param {Integer[]} inorder
# @return {TreeNode}
def build_tree(preorder, inorder)
    if(preorder == nil || preorder.length == 0)
        return nil
    end
    
    inorderMap = Hash.new()
    for i in 0..inorder.length-1 do
        inorderMap[inorder[i]] = i
    end
    return solve(0, preorder.length - 1, preorder, inorderMap)
end

def solve(left, right, preorder, inorderMap)
    if(left > right)
        return nil
    end
    value = preorder.shift
    node = TreeNode.new(value)
    node.left = solve(left, inorderMap[value] - 1, preorder, inorderMap)
    node.right = solve(inorderMap[value] + 1, right, preorder, inorderMap)
    return node
end

