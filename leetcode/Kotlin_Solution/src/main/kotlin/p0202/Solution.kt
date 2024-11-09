package p0202

class Solution {
    val visited = mutableSetOf<Int>()
    fun isHappy(n: Int): Boolean {
        if (visited.contains(n)) {
            return false
        } else if (n == 1) {
            return true
        } else {
            visited.add(n)
            var next = 0
            var num = n
            while (num > 0) {
                var digit = num % 10
                next += digit * digit
                num = num / 10
            }
            return isHappy(next);
        }
    }
}