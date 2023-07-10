# @param {Integer} target
# @param {Integer[]} nums
# @return {Integer}
def min_sub_array_len(target, nums)
    l = 0
    r = 0
    sum = nums[0]
    ans = nums.length + 1
    while(l <= r) do
        #puts "#{sum} #{l} #{r}"
        if(sum < target)
            r = r + 1
            if(r < nums.length)
                sum = sum + nums[r]
            else
                break
            end
        else
            ans = [ans, r - l + 1].min
            sum = sum - nums[l]
            l = l + 1
        end
    end
    if(ans > nums.length)
        ans = 0
    end
    return ans
end

puts "#{min_sub_array_len(11, [1,2,3,4,5])}"