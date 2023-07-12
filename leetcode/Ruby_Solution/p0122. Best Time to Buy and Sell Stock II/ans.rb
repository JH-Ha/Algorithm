# @param {Integer[]} prices
# @return {Integer}
def max_profit(prices)
    profit = 0
    for i in 1..prices.length-1 do
        if(prices[i-1] < prices[i])
            profit = profit + prices[i] - prices[i-1]
        end
    end
    return profit
end