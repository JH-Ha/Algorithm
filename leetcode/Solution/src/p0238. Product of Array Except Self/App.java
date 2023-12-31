package p0238;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int product = 1;
        for(int i = 0; i < nums.length; i ++){
            product *= nums[i];
            left[i] = product;
        }
        product = 1;
        for(int i = nums.length - 1; i >= 0; i --){
            product *= nums[i];
            right[i] = product;
        }
        int[] answer = new int[nums.length];
        answer[0] = right[1];
        answer[nums.length - 1] = left[nums.length - 2];
        for(int i = 1; i < nums.length - 1; i ++){
            answer[i] = left[i -1] * right[i+ 1];
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args){

    }
    
}


