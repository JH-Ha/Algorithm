# @param {Integer[]} nums
# @return {Integer}
def remove_duplicates(nums)
    prev = nums[0]
    cnt = 1
    k = 1
    for i in 1..nums.length-1 do
        if(nums[i] == prev)
            if(cnt < 2) 
                cnt = cnt + 1
                nums[k] = nums[i]
                k = k + 1
            end
        else
            prev = nums[i]
            cnt = 1
            nums[k] = nums[i]
            k = k + 1
        end
    end
    k
end