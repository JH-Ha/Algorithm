package diskController;

import java.util.LinkedList;
import java.util.PriorityQueue;

class Job {
    int startTime;
    int duration;
    int id;

    public Job(int id, int startTime, int duration) {
        this.id = id;
        this.startTime = startTime;
        this.duration = duration;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int n = jobs.length;

        PriorityQueue<Job> q = new PriorityQueue<>((Job a, Job b) -> a.duration - b.duration);
        PriorityQueue<Job> jobQueue = new PriorityQueue<>((Job a, Job b) -> {
            int diff = a.startTime - b.startTime;
            if (diff < 0) {
                return -1;
            } else if (diff == 0) {
                return a.duration - b.duration;
            } else {
                return 1;
            }
        });
        boolean[] completed = new boolean[n];
        for (int i = 0; i < n; i++) {
            completed[i] = false;
        }

        long sum = 0;
        int time = 0;

        for (int i = 0; i < n; i++) {
            jobQueue.add(new Job(i, jobs[i][0], jobs[i][1]));
        }

        while (!jobQueue.isEmpty() || !q.isEmpty()) {
            while (true) {
                Job job = jobQueue.poll();
                if (job == null)
                    break;
                if (time >= job.startTime) {
                    q.add(job);
                } else {
                    if (q.isEmpty()) {
                        time = job.startTime;
                    }
                    jobQueue.add(job);
                    break;
                }
            }
            if (!q.isEmpty()) {
                Job mainJob = q.poll();
                time += mainJob.duration;
                sum += (time - mainJob.startTime);
            }
        }

        answer = (int) (sum / n);
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println();
        Solution solution = new Solution();
        int[][] jobs = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
        System.out.println(solution.solution(jobs));
    }
}
