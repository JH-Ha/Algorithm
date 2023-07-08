# @param {String} s
# @return {Boolean}
def is_palindrome(s)
    s = s.downcase.gsub(/[^a-z0-9]/,'')
    for i in 0..s.length/2 do
        if(s[i] != s[s.length - 1 - i])
            return false
        end
    end
    return true
end