def solve(ans, cur, visited, start, nums, k)
    if(cur.length == k)
        ans.append(cur.clone)
        return
    end
    for i in start..nums.length-1 do
        if(!visited[i])
            visited[i] = true
            cur.append(nums[i])
            solve(ans, cur, visited, i + 1, nums, k)
            cur.pop()
            visited[i] = false
        end
    end
end

# @param {Integer} n
# @param {Integer} k
# @return {Integer[][]}
def combine(n, k)
    nums = []
    for i in 1..n do
        nums.append(i)
    end
    ans = []
    visited = Array.new(n, false)
    solve(ans, [], visited, 0, nums, k)
    return ans
end