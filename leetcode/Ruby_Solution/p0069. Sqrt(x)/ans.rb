# @param {Integer} x
# @return {Integer}
def my_sqrt(x)
    l = 0
    r = x
    ans = 0
    while (l <= r) do
        m = l + (r - l)/2
        if(m * m <= x)
            ans = [ans, m].max
            l = m + 1
        else
            r = m - 1
        end
    end
    ans
end