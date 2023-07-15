def solve(idx, s, ans, cur, dp)
    if(idx == s.length)
        ans.append(cur.clone())
        return 
    end
    for i in idx..s.length-1 do
        if(isPalindrome(s, idx, i, dp))
            cur.append(s[idx..i])
            solve(i + 1, s, ans, cur, dp)
            cur.pop()
        end
    end
end

def isPalindrome(s, s_i, e_i, dp)
    key = "#{s_i}_#{e_i}"
    if(dp[key] != nil)
        return dp[key]
    end

    while(s_i <= e_i) do
        if(s[s_i] != s[e_i ])
            dp[key] = false
            return dp[key]
        end
        s_i = s_i + 1
        e_i = e_i - 1
    end
    dp[key] = true
    return dp[key]
end

# @param {String} s
# @return {String[][]}
def partition(s)
    ans = []
    dp = Hash.new
    solve( 0, s, ans, [], dp)
    return ans
end