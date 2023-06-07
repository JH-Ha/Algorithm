def is_valid_square(board, x, y)
   x_start = x/3 * 3
   y_start = y/3 * 3

   for i in x_start..x_start+2 do
      for j in y_start..y_start+2 do
         if(i == x && j == y)
            next
         end
         if (board[i][j] == board[x][y])
            # puts "is_valid_square #{x} #{y} #{i} #{j}"
            return false
         end
      end
   end
   return true
end

def is_valid_line(board, x, y)
   for i in 0..8 do
      if(i == x)
         next
      end
      if(board[i][y] == board[x][y])
        #  puts "is_valid_line1 #{x} #{y} #{i} #{j}"
         return false
      end
   end
   for j in 0..8 do
      if(j == y)
         next
      end
      if(board[x][j] == board[x][y])
        #  puts "is_valid_line2 #{x} #{y} #{i} #{j}"
         return false
      end
   end
   return true
end

# @param {Character[][]} board
# @return {Void} Do not return anything, modify board in-place instead.
solved = false
def solve_sudoku(board)
    for i in 0..8 do
        for j in 0..8 do
            if(board[i][j] == ".")
                for k in 1..9 do
                    board[i][j] = k.to_s
                   
                    if(is_valid_square(board, i,j) && is_valid_line(board, i, j))
                        # puts "#{i} #{j} #{k}"
                        # for a in 0..8 do
                        #     for b in 0..8 do
                        #         print board[a][b] + " "
                        #     end
                        #     puts ""
                        # end
                  
                        
                        if(solve_sudoku(board))
                            return true
                        end
                    end
                    board[i][j] = "."
                end
                return false
            end
        end
    end
    return true
end

board = [["5","3",".",".","7",".",".",".","."]\
,["6",".",".","1","9","5",".",".","."]\
,[".","9","8",".",".",".",".","6","."]\
,["8",".",".",".","6",".",".",".","3"]\
,["4",".",".","8",".","3",".",".","1"]\
,["7",".",".",".","2",".",".",".","6"]\
,[".","6",".",".",".",".","2","8","."]\
,[".",".",".","4","1","9",".",".","5"]\
,[".",".",".",".","8",".",".","7","9"]]

[["5","3",".",".","7",".",".",".","."],\
["6",".",".","1","9","5",".",".","."],\
[".","9","8",".",".",".",".","6","."],\
["8",".",".",".","6",".",".",".","3"],\
["4",".",".","8",".","3",".",".","1"],\
["7",".",".",".","2",".",".",".","6"],\
[".","6",".",".",".",".","2","8","."],\
[".",".",".","4","1","9",".",".","5"],\
[".",".",".",".","8",".",".","7","9"]]

solve_sudoku(board)
# puts board

for a in 0..8 do
    for b in 0..8 do
        print board[a][b] + " "
    end
    puts ""
end