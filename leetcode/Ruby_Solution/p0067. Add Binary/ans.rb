# @param {String} a
# @param {String} b
# @return {String}
def add_binary(a, b)
    ans = []
    if(a.length > b.length)
        c = a
        a = b
        b = c
    end
    carry = 0
    for i in 0..a.length-1 do
        num = carry + a[a.length - 1 - i].to_i + b[b.length - 1 - i].to_i
        carry = num / 2
        num = num % 2
        ans.unshift(num)
    end
    for i in a.length..b.length-1 do
        num = carry + b[b.length - 1 - i].to_i
        carry = num / 2
        num = num % 2
        ans.unshift(num)
    end
    if(carry > 0)
        ans.unshift(carry)
    end
    return ans.join("")
end