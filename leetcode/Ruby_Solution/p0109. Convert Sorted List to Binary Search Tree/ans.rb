# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end
# @param {ListNode} head
# @return {TreeNode}
def sorted_list_to_bst(head)
    if(head == nil)
        return nil
    end
    n = 0
    cur = head
    while(cur != nil) do
        n = n + 1
        cur = cur.next
    end
    
    if(n == 1)
        return TreeNode.new(head.val)
    end

    half = n/2
    left = head
    cur = head
    prev = nil
    for i in 0..half-1 do
        prev = cur
        cur = cur.next
    end
    if(prev != nil)
        prev.next = nil
    end
    right = cur.next
    return TreeNode.new(cur.val, sorted_list_to_bst(left), sorted_list_to_bst(right))
end