# @param {Integer} x
# @return {Integer}
def reverse(x)
    answer = 0
    isNegative = x < 0 ? true : false
    x = x.abs
    while x > 0 do
        answer *= 10
        answer += x % 10
        x /= 10
    end
    
    if(isNegative && answer <= 2 ** 31)
        return - answer
    elsif(answer < 2** 31 - 1)
        return answer
    else
        return 0
    end
end

puts reverse(123)
puts reverse(-123)
puts reverse(120)
puts reverse(1534236469)