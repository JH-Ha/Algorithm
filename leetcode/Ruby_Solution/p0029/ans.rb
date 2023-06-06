# @param {Integer} dividend
# @param {Integer} divisor
# @return {Integer}
def divide(dividend, divisor)
   ans = dividend.abs / divisor.abs
   if (dividend < 0 && divisor > 0 ) || (dividend > 0 && divisor < 0 ) 
      ans = -ans
   end
   if ans >= 2**31 -1
      ans = 2**31 -1
   elsif ans <= - 2**31
      ans = - 2**31
   end
   ans
end