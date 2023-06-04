# @param {String[]} strs
# @return {String}
def longest_common_prefix(strs)
   ans = ""
   index = 0
   first = strs[0]
   for i in 0..first.length-1 do
      match = true
      for str in strs do
         if(str[index] != first[index])
            match = false
         end
      end
      if(match)
         if (first[index] != nil)
            ans = ans  + first[index]
         end
         index += 1
      else
         break
      end
   end
   return ans
end

strs = ["dog","racecar","car"]
strs = ["flower","flow","flight"]
strs = [""]
strs = ["flower","flower","flower","flower"]
puts longest_common_prefix(strs)