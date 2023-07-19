require 'set'

def solve(nums, s_i, visited, ans, cur)
    if(s_i == nums.length)
        ans << cur.clone
        return
    end
    for i in s_i..nums.length-1 do
        cur.append(nums[i])
        solve(nums, i + 1, visited, ans, cur)
        cur.pop()

        solve(nums, i + 1, visited, ans, cur)
    end
end

# @param {Integer[]} nums
# @return {Integer[][]}
def subsets_with_dup(nums)
    visited = Array.new(nums.length, false)
    ans = Set.new
    solve(nums.sort, 0, visited, ans, [])
    return ans.to_a
end

puts "#{subsets_with_dup([1,2,2])}"