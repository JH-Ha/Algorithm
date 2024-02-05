package p0169

class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        for(num in nums){
            map[num] = map.getOrDefault(num, 0) + 1;
        }
        var maxCnt = 0
        var majorEle = 0
        for(ele in map){
            if(ele.value > maxCnt){
                maxCnt = ele.value
                majorEle = ele.key
            }
        }
        return majorEle
    }
}