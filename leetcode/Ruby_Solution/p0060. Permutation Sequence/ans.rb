# def solve(n, k, cnt, visited, cur, start)
#     if(start == n)
#         cnt[0] = cnt[0] + 1
#     end
#     if(k == cnt[0])
#         return true;
#     end

#     for i in 0..n-1 do
#         if(!visited[i]) 
#             visited[i] = true
#             cur[start] = i + 1
#             if(solve(n, k, cnt, visited, cur, start + 1))
#                 return true;
#             end
#             visited[i] = false
#         end 
#     end
#     return false;
# end

# # @param {Integer} n
# # @param {Integer} k
# # @return {String}
# def get_permutation(n, k)
#     ans = Array.new(n, 0)
#     visited = Array.new(n, false)
#     solve(n, k , [0], visited, ans, 0)
#     return ans.join("").to_s
# end

def get_permutation(n, k)
  list = (1..n).to_a
  
  # factorial of all req numbers in O(n), O(n)
  factorial = [1]
  list.each { |num| factorial[num] = factorial[num - 1] * num }
  puts "#{list}, #{factorial}"
  perm = ''
  while n > 0
    index = (k-1)/factorial[n-1]
    element = list[index]
    perm = "#{perm}#{element}"

    k = k - (index * factorial[n-1])
    n -= 1
    list = list - [element]
  end
  perm
end

puts "#{get_permutation(3, 3)}"