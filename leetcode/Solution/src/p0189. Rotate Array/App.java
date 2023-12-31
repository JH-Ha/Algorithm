class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] answer = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            answer[i] = nums[(i + (nums.length -  k))% nums.length];
        }
        for(int i = 0; i< nums.length; i ++){
            nums[i] = answer[i];
        }
    }
}


public class App {
    public static void main(String[] args){

    }
    
}


