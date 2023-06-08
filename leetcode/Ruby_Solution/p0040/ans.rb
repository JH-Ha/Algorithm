# @param {Integer[]} candidates
# @param {Integer} target
# @return {Integer[][]}
def combination_sum2(candidates, target)
   ans = []
    if(candidates.length == 0)
      return ans
    end
    candi = candidates.sort
    first = candi.shift
    new_target = target - first
    if(new_target == 0)
      ans.append(first)
      return ans
    elsif new_target > 0
      sub_ans = combination_sum2(candi, new_target)
      # for a in sub_ans do
      #    ans.append(a.append(first))
      # end
      return sub_ans
    else
      return ans
    end
end

candidates = [2,5,2,1,2], target = 5
puts combination_sum2(candidates, target)