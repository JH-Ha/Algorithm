# @param {Integer[]} nums
# @return {Integer}
def remove_duplicates(nums)
    prev = nums[0]
    nextPos = 1
    for i in 1..nums.length-1 do
        if(nums[i] != prev)
            nums[nextPos] = nums[i]
            nextPos = nextPos + 1
            prev = nums[i]
        end
    end
    return nextPos
end