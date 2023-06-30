# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} head
# @param {Integer} k
# @return {ListNode}
def rotate_right(head, k)
    if(head == nil)
        return nil
    end
    cur = head
    len = 0
    tail = nil
    while(cur != nil) do
        len = len + 1
        if(cur != nil)
            tail = cur
        end
        cur = cur.next
        
    end
    k = len - k % len
    if(k == 0 || k == len)
        return head
    end
    prev = nil
    cur = head
    for i in 0..k-1 do
        prev = cur
        cur = cur.next
    end
    prev.next = nil
    tail.next = head
    return cur
end