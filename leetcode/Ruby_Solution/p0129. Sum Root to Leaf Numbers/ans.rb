def solve(root, cur, answer)
    if(root == nil)
        return
    end
    cur = cur * 10 + root.val
    if (root.left == nil && root.right == nil)
        answer[0] = answer[0] + cur
    end
    solve(root.left, cur, answer)
    solve(root.right, cur, answer)
end


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
# @return {Integer}
def sum_numbers(root)
    answer = [0]
    solve(root, 0, answer)
    return answer[0]
end