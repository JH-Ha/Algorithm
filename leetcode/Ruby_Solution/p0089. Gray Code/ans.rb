def numToGray(num)
    num = num ^ num >> 1
    return num
end

# @param {Integer} n
# @return {Integer[]}
def gray_code(n)
    ans = []
    max_num = 2 ** n
    for i in 0..max_num-1 do
        ans.append(numToGray(i))
    end
    return ans
end