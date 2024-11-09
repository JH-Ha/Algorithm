package p3334

class Solution {
    fun pow(num: Long, cnt: Long): Long {
        if (cnt == 0L) {
            return 1
        }
        if (cnt % 2 == 0L) {
            val result = pow(num, cnt / 2)
            return result * result
        } else {
            val result = pow(num, cnt / 2)
            return result * result * num
        }
    }

    fun maxScore(nums: IntArray): Long {
        val primes: LongArray = longArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)

        val numPrimes = Array(nums.size) { LongArray(primes.size) }
        for (i in 0 until nums.size) {
            val num = nums[i]
            //print("num $num : ")
            for (j in 0 until primes.size) {
                val prime = primes[j]
                var cur = num.toLong()
                while (cur % prime == 0L) {
                    cur /= prime
                    numPrimes[i][j] += 1L
                }
            }
            //println(numPrimes[i].joinToString(" "))
        }


        var ans = 0L
        for (k in -1 until nums.size) {
            val minPrimes = LongArray(primes.size)
            val maxPrimes = LongArray(primes.size)
            for (j in 0 until primes.size) {
                var min = 10L
                var max = 0L
                for (i in 0 until nums.size) {
                    if (i == k)
                        continue
                    min = Math.min(min, numPrimes[i][j])
                    max = Math.max(max, numPrimes[i][j])
                }
                minPrimes[j] = min
                maxPrimes[j] = max
            }

//            println(minPrimes.joinToString(" "))
//            println(maxPrimes.joinToString(" "))
            var lcm: Long = 1
            var gcm: Long = 1
            for (i in 0 until primes.size) {
                lcm *= pow(primes[i], minPrimes[i])
                gcm *= pow(primes[i], maxPrimes[i])
            }
            ans = Math.max(ans, lcm * gcm)
        }
        return ans
    }
}