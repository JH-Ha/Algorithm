# @param {Integer[][]} triangle
# @return {Integer}
def minimum_total(triangle)
    n = triangle.length
    m = triangle[0].length
    dp = []
    for i in 0..n-1 do
        dp.append(Array.new(m, 0))
    end
    dp[0][0] = triangle[0][0]
    for i in 1..n-1 do
        for j in 0..i do
            if(j-1 < 0)
                dp[i][j] = triangle[i][j] + dp[i-1][j]
            elsif(j == i)
                dp[i][j] = triangle[i][j] + dp[i-1][j-1]
            else
                dp[i][j] = triangle[i][j] + [dp[i-1][j], dp[i-1][j-1]].min
            end

        end
    end
    ans = dp[n-1][0]
    for j in 0..n-1 do
        ans = [ans, dp[n-1][j]].min
     #   puts "#{ans}"
    end
    #puts "#{dp}"
    return ans
end

# minimum_total([[-1],[3,2],[-3,1,-1]])
#minimum_total([[2],[3,4],[6,5,7],[4,1,8,3]])