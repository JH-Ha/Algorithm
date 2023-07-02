def reverse(root)
    if (root == nil)
        return nil
    end
    left = reverse(root.left)
    right = reverse(root.right)
    root.left = right
    root.right = left
    return root
end

def is_same_tree(p, q)
    if(p == nil && q == nil)
        return true
    elsif(p != nil && q == nil)
        return false
    elsif(p == nil && q != nil)
        return false
    end
    
    if(p.val != q.val)
        return false
    else
        return is_same_tree(p.left, q.left) && is_same_tree(p.right, q.right) 
    end
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
# @return {Boolean}
def is_symmetric(root)
    if(root == nil)
        return true
    end
    return is_same_tree(root.left, reverse(root.right))
end