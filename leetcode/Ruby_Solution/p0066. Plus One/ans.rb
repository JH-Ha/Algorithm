# @param {Integer[]} digits
# @return {Integer[]}
def plus_one(digits)
    num = 0
    for i in 0..digits.length()-1 do
        num = num + digits[i] * (10 ** (digits.length - 1 - i))
    end
    puts num
    num = num + 1
    ans = []
    while num > 0 do
        ans.unshift(num % 10)
        num = num / 10
    end
    return ans
end

puts plus_one([1,2,3])