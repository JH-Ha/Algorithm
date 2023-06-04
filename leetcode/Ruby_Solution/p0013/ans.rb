# @param {String} s
# @return {Integer}
def roman_to_int(s)
   roman_map = [
      ["M", 1000],
      ["CM", 900],
      ["D", 500],
      ["CD", 400],
      ["C", 100],
      ["XC", 90],
      ["L", 50],
      ["XL",40],
      ["X",10],
      ["IX",9],
      ["V",5],
      ["IV",4],
      ["I",1],
]
   #  roman_map = [
   #     {
   #        "key" : "M",
   #        "value" : 1000,
   #     },
   #     {
   #        "key" : "CM",
   #        "value" : 900,
   #     },
   #     {
   #        "key" : "D",
   #        "value" : 500,
   #     },
   #     {
   #        "key" : "CD",
   #        "value" : 400,
   #     },
   #     {
   #        "key" : "C",
   #        "value" : 100,
   #     },
   #     {
   #        "key" : "XC",
   #        "value" : 90,
   #     },
   #     {
   #        "key" : "L",
   #        "value" : 50,
   #     },
   #     {
   #        "key" : "XL",
   #        "value" : 40,
   #     },
   #     {
   #        "key" : "X",
   #        "value" : 10,
   #     },
   #     {
   #        "key" : "IX",
   #        "value" : 9,
   #     },
   #     {
   #        "key" : "V",
   #        "value" : 5,
   #     },
   #     {
   #        "key" : "IV",
   #        "value" : 4,
   #     },
   #     {
   #        "key" : "I",
   #        "value" : 1,
   #     },
   #  ]

   index = 0
   ans = 0
   while index < s.length do
      for ele in roman_map do
         if(s[index..-1].start_with?(ele[0])) 
            index += ele[0].length
            ans += ele[1]
            #puts ele
            break
         end
         
      end
   end
   return ans
end

puts roman_to_int("MCMXCIV")