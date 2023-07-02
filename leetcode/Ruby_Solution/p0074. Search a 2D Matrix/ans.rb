# @param {Integer[][]} matrix
# @param {Integer} target
# @return {Boolean}
def search_matrix(matrix, target)
    n = matrix.length
    m = matrix[0].length

    l = 0
    r = n * m - 1
    while ( l <= r) do
        mid = (l + r)/2
        i = mid / m
        j = mid % m
        if(matrix[i][j] < target)
            l = mid + 1
        elsif(matrix[i][j] > target)
            r = mid - 1
        else
            return true
        end
    end
    return false
end