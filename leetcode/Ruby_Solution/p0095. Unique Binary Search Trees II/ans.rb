def generate(s, e)
    if(s > e)
        return [nil]
    end
    ans = []
    if(s == e)
        ans.append(TreeNode.new(s))
    else
        for i in s..e do
            l_trees = generate(s, i - 1)
            r_trees = generate(i + 1, e)
            for l_i in 0..l_trees.length-1 do
                for r_i in 0..r_trees.length-1 do
                    ans.append(TreeNode.new(i, l_trees[l_i], r_trees[r_i]))
                end
            end
        end
    end
    return ans
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
# @param {Integer} n
# @return {TreeNode[]}
def generate_trees(n)
    return generate(1, n)
end