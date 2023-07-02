# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val = 0, left = nil, right = nil)
#         @val = val
#         @left = left
#         @right = right
#     end
# end


class BSTIterator

=begin
    :type root: TreeNode
=end
    def initialize(root)
        @root = root
        @stack = []
        prepare(root)
    end


=begin
    :rtype: Integer
=end
    def next()
        node = @stack.pop
        prepare(node.right)
        node.val
    end

    def prepare(node)
        while(node) do
            @stack.push(node)
            node = node.left
        end
    end

=begin
    :rtype: Boolean
=end
    def has_next()
        return !@stack.empty?
    end


end
        
        # Your BSTIterator object will be instantiated and called as such:
        # obj = BSTIterator.new(root)
        # param_1 = obj.next()
        # param_2 = obj.has_next()