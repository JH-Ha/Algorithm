def digit_to_roman(num, one, five, ten)
   ans = ''
   if( num <= 3) 
      for i in 0..num-1 do
         ans += one
      end
   elsif (num == 4) 
      ans += one + five
   elsif (num == 5) 
      ans += five
   elsif (num >= 6 && num <= 8) 
      ans += five
      for i in 0..num-6 do
         ans += one
      end
   elsif (num == 9) 
      ans += one + ten
   end
   return ans
end

# @param {Integer} num
# @return {String}
def int_to_roman(num)
   a = num % 10
   num /= 10
   ans = digit_to_roman( a, 'I', 'V', 'X')
   if(num > 0) 
      a = num % 10
      num /= 10
      ans = digit_to_roman(a, 'X', 'L','C') + ans
   end
   if (num > 0)
      a = num % 10
      num /= 10
      ans = digit_to_roman(a, 'C', 'D','M') + ans
   end
   if (num > 0)
      a = num % 10
      num /= 10
      ans = digit_to_roman(a, 'M', '?','?') + ans
   end
   return ans
end

puts int_to_roman(10)
puts int_to_roman(3)
puts int_to_roman(58)
puts int_to_roman(1994)

puts 1/10
