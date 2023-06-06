# @param {Integer} n
# @return {String}
def count_and_say(n)
   ans = "1"
    while n > 1 do
      new_ans = ""
      num_start = 0
      while num_start < ans.length do
         i = num_start
         while i < ans.length do
            if(ans[i] == ans[i+1])
               i += 1
            else
               break
            end
         end
         new_ans += (i - num_start + 1).to_s + ans[i].to_s
         num_start = i + 1
      end
      ans = new_ans
      n -= 1
    end
    ans
end

puts count_and_say(4)