# @param {String} s
# @param {Integer} num_rows
# @return {String}
def convert(s, num_rows)
    first_gap = (num_rows - 1) * 2
    if(first_gap == 0)
        return s
    end

    answer = ""
    second_gap = 0
    for i in 0..num_rows-1 do
        str_idx = i
        if s[str_idx] == nil
            break
        end
        answer += s[str_idx]
        gap = first_gap
        if(first_gap == 0)
            gap = second_gap
        end
        next_idx = str_idx + gap
        while next_idx < s.length  do
            # puts next_idx
            answer += s[next_idx]
            if second_gap != 0 && gap == first_gap 
                gap = second_gap
            elsif first_gap != 0 && gap == second_gap
                gap = first_gap
            end
            next_idx = next_idx + gap
        end
        first_gap -= 2
        second_gap += 2

    end
    return answer
end

# puts convert("PAYPALISHIRING", 4)
puts convert("A", 2)