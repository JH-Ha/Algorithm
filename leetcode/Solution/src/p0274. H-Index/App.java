package p0274;

class Solution {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length;
        int answer = 0;
        while(l <= r){
            int m = l + (r - l)/2;
            int cnt = 0;
            for(int i = 0; i < citations.length; i ++){
                if(citations[i]>= m){
                    cnt ++;
                }
            }
            if(cnt < m){
                r = m - 1;
            } else if(cnt > m) {
                answer = m;
                l = m + 1;
            } else {
                answer = m;
                break;
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args){

    }
    
}


