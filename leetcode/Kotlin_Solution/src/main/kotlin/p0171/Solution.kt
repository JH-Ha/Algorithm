package p0171

class Solution {
    fun titleToNumber(columnTitle: String): Int {
        fun pow(x: Int, y: Int): Int {
            var ret = 1
            for (i in 0 until y) {
                ret *= x
            }
            return ret
        }

        var ans = 0
        for (i in columnTitle.indices) {
            val reversePos = columnTitle.length - i - 1
            val num = columnTitle.get(i) - 'A' + 1
            ans += num * pow(26, reversePos)
        }
        return ans
    }
}