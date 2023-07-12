# Definition for singly-linked list.
class ListNode
    attr_accessor :val, :next
    def initialize(val = 0, _next = nil)
        @val = val
        @next = _next
    end
end
# @param {ListNode} head
# @param {Integer} x
# @return {ListNode}
def partition(head, x)
    if(head == nil)
        return nil
    end
    leftHead = nil
    leftCur = nil
    rightHead = nil
    rightCur = nil
    cur = head
    while(cur != nil) do
        if(cur.val < x)
            if(leftHead == nil)
                leftHead = cur
                leftCur = cur
            else
                leftCur.next = cur
                leftCur = cur
            end
        else
            if(rightHead == nil)
                rightHead = cur
                rightCur = cur
            else
                rightCur.next = cur
                rightCur = cur
            end
        end
        cur = cur.next
    end
    if(leftCur != nil && rightCur != nil)
        leftCur.next = rightHead
        rightCur.next = nil
        return leftHead
    elsif(leftCur == nil)
        rightCur.next = nil
        return rightHead
    elsif(rightCur == nil)
        leftCur.next = nil
        return leftHead
    end
    return nil
end


x = 3
def arrayToNode(nums)
    head = ListNode.new(nums[0])
    cur = head
    for i in 1..nums.length-1 do
        cur.next = ListNode.new(nums[i])
        cur = cur.next
    end
    return head
end
nums = [1]
x = 0
ans = partition(arrayToNode(nums), x)
while (ans != nil) do
    puts "#{ans.val}"
    ans = ans.next
end