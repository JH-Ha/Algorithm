class Solution {

    public int solution(String[] lines) {
        int maxTime = 86400000;
        int[] count = new int[maxTime + 10000];
        for (int i = 0; i < maxTime + 10000; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < lines.length; i++) {
            String[] spt = lines[i].split(" ");
            int hour = Integer.parseInt(spt[1].substring(0, 2));
            int minute = Integer.parseInt(spt[1].substring(3, 5));
            int second = Integer.parseInt(spt[1].substring(6, 8));
            int sss = Integer.parseInt(spt[1].substring(9, 12));

            int periodIdx = spt[2].indexOf(".");
            int operTime = 0;
            if (periodIdx == -1) {
                operTime = Integer.parseInt(spt[2].substring(0, spt[2].length() - 1)) * 1000;
            } else {
                operTime = Integer.parseInt(spt[2].substring(0, periodIdx)) * 1000;
                int left = Integer.parseInt(spt[2].substring(periodIdx + 1, spt[2].length() - 1));
                int numDigit = spt[2].length() - 1 - periodIdx - 1;
                if (numDigit == 1) {
                    left *= 100;
                } else if (numDigit == 2) {
                    left *= 10;
                }
                operTime += left;
            }

            int time = (3600 * hour + 60 * minute + second) * 1000 + sss;
            int startTime = (time - operTime + 1);
            if (startTime <= 0)
                startTime = 0;
            int endTime = time + 999;

            for (int j = startTime; j <= endTime; j++) {
                count[j]++;
            }
            // System.out.println(hour + ":" + minute + ":" + second);
            // System.out.println(operTime);
        }
        int answer = 0;
        for (int i = 0; i < maxTime; i++) {
            answer = Math.max(answer, count[i]);
        }
        return answer;
    }
}

public class App {

    public static void main(String[] args) throws Exception {
        // String[] lines = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233
        // 1.181s",
        // "2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15
        // 20:59:59.591 1.412s",
        // "2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s",
        // "2016-09-15 21:00:00.748 2.31s",
        // "2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };
        String[] lines = { "2016-09-15 23:59:59.999 0.001s" };
        Solution solution = new Solution();

        System.out.println(solution.solution(lines));
    }
}
