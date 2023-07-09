class TrieNode
    attr_accessor :key, :data, :children
    def initialize(key = nil, data = nil)
        @key = key
        @data = data
        @children = Hash.new
    end
end

class Trie
    def initialize()
        @root = TrieNode.new
    end


=begin
    :type word: String
    :rtype: Void
=end
    def insert(word)
        cur = @root
        for i in 0..word.length-1 do
            c = word[i]
            if(cur.children[c] == nil)
                cur.children[c] = TrieNode.new(c)
            end
            cur = cur.children[c]
        end
        cur.data = word
    end


=begin
    :type word: String
    :rtype: Boolean
=end
    def search(word)
        cur = @root
        for i in 0..word.length-1 do
            c = word[i]
            if(cur.children[c] == nil)
                return false
            else
                cur = cur.children[c]
            end
        end
        if(cur.data == word)
            return true
        else
            return false
        end
    end


=begin
    :type prefix: String
    :rtype: Boolean
=end
    def starts_with(prefix)
        cur = @root
        for i in 0..prefix.length-1 do
            c = prefix[i]
            if(cur.children[c] == nil)
                return false
            else
                cur = cur.children[c]
            end
        end
        return true
    end


end

# Your Trie object will be instantiated and called as such:
# trie = Trie.new();
# trie.insert("apple");
# puts trie.search("apple");   # return True
# puts trie.search("app");     # return False
# puts trie.starts_with("app"); # return True
# trie.insert("app");
# puts trie.search("app");     # return True