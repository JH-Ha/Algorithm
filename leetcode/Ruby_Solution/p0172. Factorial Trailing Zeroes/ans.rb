def countNums(n, num)
    cnt = 0
    while(n % num == 0) do
        n = n / num
        cnt = cnt + 1
    end
    return cnt
end
    
# @param {Integer} n
# @return {Integer}
def trailing_zeroes(n)
    numFives = 0
    for i in 1..n do
        numFives = numFives + countNums(i, 5)
    end 
    return numFives
end