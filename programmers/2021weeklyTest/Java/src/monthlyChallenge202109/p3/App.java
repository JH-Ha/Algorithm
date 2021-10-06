package monthlyChallenge202109.p3;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Truck {
    int t;
    int w;
    boolean firstTime = true;
    int nextValidTime;
    int id;

    public Truck(int w, int t, int id) {
        this.w = w;
        this.t = t;
        this.nextValidTime = 0;
        this.id = id;
    }
}

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;

        // PriorityQueue<Truck> pq = new PriorityQueue<>((t1, t2) -> {
        // if (t1.nextValidTime == t2.nextValidTime) {
        // return t1.t - t2.t;
        // } else {
        // return t1.nextValidTime - t2.nextValidTime;
        // }
        // });
        List<Truck> truckList = new ArrayList();
        List<Truck> goldList = new ArrayList<>();
        List<Truck> silverList = new ArrayList<>();
        for (int i = 0; i < t.length; i++) {
            Truck truck = new Truck(w[i], t[i], i);
            truckList.add(truck);
            if (g[i] > 0) {
                goldList.add(truck);
            }
            if (s[i] > 0) {
                silverList.add(truck);
            }
        }

        if (a > 0) {

        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = 90;
        int b = 500;
        int[] g = { 70, 70, 0 };
        int[] s = { 0, 0, 500 };
        int[] w = { 100, 100, 2 };
        int[] t = { 4, 8, 1 };
        System.out.println(solution.solution(a, b, g, s, w, t));
    }
}
