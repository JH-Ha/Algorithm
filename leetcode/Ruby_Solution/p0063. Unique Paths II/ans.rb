# @param {Integer[][]} obstacle_grid
# @return {Integer}
def unique_paths_with_obstacles(obstacle_grid)
    n = obstacle_grid.length
    m = obstacle_grid[0].length
    dp = []
    for i in 0..n-1 do
        dp.append(Array.new(m, 0))
    end
    if(obstacle_grid[0][0] == 0)
        dp[0][0] = 1
    end
    for i in 0..n-1 do
        for j in 0..m-1 do
            if(obstacle_grid[i][j] == 1)
                next
            end

            if(i > 0 && j > 0)
                dp[i][j] = dp[i-1][j] + dp[i][j-1]
            elsif(i > 0 && j == 0)
                dp[i][j] = dp[i-1][j]
            elsif(j > 0 && i == 0)
                dp[i][j] = dp[i][j-1]
            end
        end
    end
    dp[n-1][m-1]
end

puts "(#{calNumRoute(3, 2)})"