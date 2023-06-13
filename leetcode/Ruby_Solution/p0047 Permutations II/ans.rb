require 'set'

def solve(cur, nums, visited, ans)
    if(visited.size() == nums.length)
        ans << cur.clone
        return
    end

    for i in 0..nums.length-1 do
        if(!visited.include?(i))
            cur << nums[i]
            visited << i
            solve(cur, nums, visited, ans )
            visited.delete(i)
            cur.pop()
        end
    end
end

# @param {Integer[]} nums
# @return {Integer[][]}
def permute_unique(nums)
    ans = Set.new
    visited = Set.new
    solve([], nums, visited, ans)
    return ans.to_a
end

nums = [1,1,2]
puts "#{permute_unique(nums)}"