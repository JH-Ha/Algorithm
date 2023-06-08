def solve(candidates, target, cur_i, ans, cur)
   if(target == 0)
      ans.append(cur.clone)
      return
   end
   for i in cur_i..candidates.length-1 do
      if(cur_i != i && candidates[i] == candidates[i - 1])
         next
      end
      if(candidates[i] > target)
         break
      end
      cur.append(candidates[i])
      solve(candidates, target - candidates[i], i + 1, ans, cur)
      cur.pop()
   end
end

# @param {Integer[]} candidates
# @param {Integer} target
# @return {Integer[][]}


def combination_sum2(candidates, target)
   candidates.sort!
   ans = []
   solve(candidates, target, 0, ans, [])
   return ans
end

candidates = [2,5,2,1,2]
target = 5
# candidates = [1,1]
# target = 1
puts "#{combination_sum2(candidates, target)}"