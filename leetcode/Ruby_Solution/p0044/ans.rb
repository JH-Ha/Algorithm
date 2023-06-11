def key(s_i, p_i)
    "#{s_i}_#{p_i}"
end

def match(s,p,s_i, p_i, dp)
    if(dp[key(s_i, p_i)] != nil)
        return dp[key(s_i, p_i)]
    end

    if(s.length == s_i && p.length == p_i)
        return true
    elsif (s.length == s_i && p.length < p_i)
        dp[key(s_i, p_i)] = false
        return false
    elsif (s.length == s_i && p.length > p_i)
        is_all_star = true
        for i in p_i..p.length-1 do
            if(p[i] != "*")
                is_all_star = false
                break
            end
        end
        dp[key(s_i, p_i)] = is_all_star
        return is_all_star
    end

    if(p[p_i] == "*")
        if(match(s, p, s_i + 1, p_i, dp))
            return true
        end
        if(match(s, p, s_i, p_i + 1, dp))
            return true
        end 
        if(match(s, p, s_i + 1, p_i + 1, dp))
            return true
        end
    elsif(p[p_i] == "?")
        return match(s,p, s_i + 1, p_i + 1, dp)
    elsif(p[p_i] == s[s_i])
        return match(s,p, s_i + 1, p_i + 1, dp)
    end
    dp[key(s_i, p_i)] = false
    return false
end

# @param {String} s
# @param {String} p
# @return {Boolean}
def is_match(s, p)
    dp = Hash.new
    match(s,p, 0, 0, dp)
end