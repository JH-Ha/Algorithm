# @param {String} s1
# @param {String} s2
# @param {String} s3
# @return {Boolean}
def is_interleave(s1, s2, s3)
    dp = []
    for i in 0..100 do
        dp.append(Array.new(100, true))
    end
    if(s1.length + s2.length != s3.length)
        return false
    end
    #solve(dp, 0,0,0, s1,s2,s3)
    for i in 1..s1.length do
        dp[i][0] = dp[i - 1][0] && s1[i-1] == s3[i-1]
    end
    for j in 1..s2.length do
        dp[0][j] = dp[0][j-1] && s2[j-1] == s3[j-1]
    end
    for i in 1..s1.length do
        for j in 1..s2.length do
            dp[i][j] = (dp[i-1][j] && s1[i-1] == s3[i-1+j]) ||
            (dp[i][j-1] && s2[j-1] == s3[i -1 + j])
        end
    end
    return dp[s1.length][s2.length]
end