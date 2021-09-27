class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int n = sizes.length;
        int maxWidth = 0;
        int maxHeight = 0;
        for(int i = 0; i < n; i ++){
            maxWidth = Math.max(maxWidth, Math.max(sizes[i][0], sizes[i][1]));
            maxHeight = Math.max(maxHeight, Math.min(sizes[i][0], sizes[i][1]));
        }
        answer = maxHeight * maxWidth;
        return answer;
    }
}