# @param {String} s
# @return {Integer}
def length_of_last_word(s)
    
    wordLength = 0
    lastWordLength = 0
    for i in 0..s.length-1 do
        if(s[i] != ' ')
            wordLength += 1
            lastWordLength = wordLength
        else
            wordLength = 0
        end
    end
    return lastWordLength
end