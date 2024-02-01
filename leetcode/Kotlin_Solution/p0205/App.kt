class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val sToTMap = mutableMapOf<Char, Char>()
        val tToSMap = mutableMapOf<Char, Char>()

        for (i in 0 until s.length) {
            val charS = s[i]
            val charT = t[i]
            
            if (sToTMap.containsKey(charS)) {
                if (sToTMap[charS] != charT) return false
            } else {
                sToTMap[charS] = charT
            }

            if (tToSMap.containsKey(charT)) {
                if (tToSMap[charT] != charS) return false
            } else {
                tToSMap[charT] = charS
            }
        }

        return true
    }
}