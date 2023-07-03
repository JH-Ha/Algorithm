# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {Integer[]} inorder
# @param {Integer[]} postorder
# @return {TreeNode}
def build_tree(inorder, postorder)
    inorderMap = Hash.new()
    for i in 0..inorder.length-1 do
        inorderMap[inorder[i]] = i
    end
    return solve(0, inorder.length - 1, inorderMap, postorder)
end


def solve(left, right, inorderMap, postorder) 
    if(left > right)
        return nil
    end
    
    value = postorder.pop()
    node = TreeNode.new(value)
    node.right = solve(inorderMap[value] + 1, right, inorderMap, postorder)
    node.left = solve(left, inorderMap[value] - 1, inorderMap, postorder)
    return node
end