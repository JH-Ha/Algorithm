
# @param {Float} x
# @param {Integer} n
# @return {Float}
def my_pow(x, n)
    if(n < 0)
        return my_pow(1/x, -n)
    elsif(n == 0)
        return 1
    end

    half = my_pow(x, n/2)
    if(n % 2 == 0)    
        return half * half
    else
        return half * half * x
    end 
end