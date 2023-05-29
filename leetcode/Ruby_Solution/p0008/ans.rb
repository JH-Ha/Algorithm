# @param {String} s
# @return {Integer}
def my_atoi(s)
   answer = s.to_i 
   if(answer > 2**31 -1)
    return 2**31 -1
   elsif(answer < - 2**31)
    return -2**31
   else 
    return answer
   end
end