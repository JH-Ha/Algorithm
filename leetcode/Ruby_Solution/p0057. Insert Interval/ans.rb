# @param {Integer[][]} intervals
# @param {Integer[]} new_interval
# @return {Integer[][]}
def insert(intervals, new_interval)
    if(intervals.length == 0)
        return [new_interval]
    end
    
    ans = []
    for i in 0..intervals.length-1 do
        interval = intervals[i]
        s = [interval[0], new_interval[0]].max
        e = [interval[1], new_interval[1]].min
        
        # check new_interval is overlapped
        if(s <= e)
            i_s = [interval[0], new_interval[0]].min
            i_e = [interval[1], new_interval[1]].max
            new_interval = [i_s,i_e]
        elsif(s > e && new_interval[0] > interval[1])
            ans.append(interval)
        elsif(s > e && new_interval[1] < interval[0])
            ans.append(new_interval.clone)
            ans.append(interval)
            new_interval[0] = 10**5 + 1
            new_interval[1] = new_interval[0]
        end
    end
    if(new_interval[0] != 10**5 + 1)
        ans.append(new_interval)
    end
    return ans
end