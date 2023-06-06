require 'set'
# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[][]}
def four_sum(nums, target)
   ans = []
   keys = Set.new
   nums.sort!
    for a in 0..nums.length-1 do
      for b in a+1..nums.length-1 do
         c = b + 1
         d = nums.length - 1
         while c < d do
            sum = nums[a] + nums[b] + nums[c] + nums[d]
            if sum < target
               c += 1
            elsif sum > target
               d -= 1
            else
               key = "#{nums[a]}_#{nums[b]}_#{nums[c]}_#{nums[d]}"
               if keys.include?(key)
                  c += 1
               else 
                  keys << key
                  ans.append([nums[a],nums[b],nums[c],nums[d]])
               end
            end
         end
      end
    end
    ans
end

puts four_sum([2,2,2,2,2], 8)