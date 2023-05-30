# @param {Integer} x
# @return {Boolean}
def is_palindrome(x)
   if( x < 0)
      return false
   end
   reverse = x.digits.join().to_i
   return reverse == x
end

# puts is_palindrome(121)