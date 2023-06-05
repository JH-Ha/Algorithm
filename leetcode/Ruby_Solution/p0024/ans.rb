# Definition for singly-linked list.
class ListNode
   attr_accessor :val, :next
   def initialize(val = 0, _next = nil)
       @val = val
       @next = _next
   end
end
# @param {ListNode} head
# @return {ListNode}
def swap_pairs(head)
  if head == nil
     return nil
  end
  _next = head.next
  if _next == nil
     return head
  else
     head.next = head.next.next
     _next.next = head
     head.next = swap_pairs(head.next)
     return _next
  end
end