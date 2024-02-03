package p0290

class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val sArr = s.split(" ");
        if (pattern.length != sArr.size) {
            return false;
        }
        val mapPtoS = mutableMapOf<Char, String>()
        val mapStoP = mutableMapOf<String, Char>()
        for (i in pattern.indices) {
            val str = mapPtoS[pattern[i]]
            if (str == null) {
                mapPtoS[pattern[i]] = sArr[i]
            } else if (str != sArr[i]) {
                return false
            }

            val p = mapStoP[sArr[i]]
            if (p == null) {
                mapStoP[sArr[i]] = pattern[i]
            } else if (p != pattern[i]) {
                return false
            }
        }
        return true;
    }
}