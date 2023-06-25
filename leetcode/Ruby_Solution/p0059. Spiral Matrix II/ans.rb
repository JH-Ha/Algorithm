# @param {Integer} n
# @return {Integer[][]}
def generate_matrix(n)
    ans = []
    for i in 0..n-1 do
        ans.append(Array.new(n))
    end
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]
    dir = 0
    x = 0
    y = -1
    k = n * 2
    num = 0
    for i in 1..n*n do
        x = x + dx[dir]
        y = y + dy[dir]
        ans[x][y] = i
        num = num + 1
 #       puts "x: #{x} y: #{y}"
        if(k / 2 - num == 0) 
            dir = dir + 1
            dir = dir % 4
            k = k - 1
            num = 0
#            puts "here #{dir} #{k}"
        end
    end
    return ans
end

puts "#{generate_matrix(3)}"