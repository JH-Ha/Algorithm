package p0242

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val sMap = mutableMapOf<Int, Int>()
        val tMap = mutableMapOf<Int, Int>()

        for(i in s.indices){
            val idx = s[i] - 'a'
            val cnt = sMap.getOrDefault(idx,0)
            sMap[idx] = cnt + 1
        }
        for(i in t.indices){
            val idx = t[i] - 'a'
            val cnt = tMap.getOrDefault(idx,0)
            tMap[idx] = cnt + 1
        }
        for(i in 0 until 26){
            if(sMap[i] != tMap[i]) {
                return false
            }
        }
        return true
    }
}