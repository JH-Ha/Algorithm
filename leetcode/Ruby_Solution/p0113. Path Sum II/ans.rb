def dfs(root, cur, cur_sum, target_sum, ans)
    if(root == nil)
        return 
    end
    cur.append(root.val)
    dfs(root.left, cur, cur_sum + root.val, target_sum, ans) 
    dfs(root.right, cur, cur_sum + root.val, target_sum, ans)

    if(root.left == nil && root.right == nil && cur_sum + root.val == target_sum)
        ans.append(cur.clone)
    end
    cur.pop()
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
# @param {Integer} target_sum
# @return {Integer[][]}
def path_sum(root, target_sum)
    ans = []
    dfs(root, [], 0, target_sum, ans)
    return ans
end