import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Day13 {

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p13Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            Integer startTime = Integer.parseInt(br.readLine());
            line = br.readLine();
            String[] spt = line.split(",");
            List<Integer> timeList = new ArrayList<>();
            List<Integer> timeDiff = new ArrayList<>();
            int maxNum = 0;
            int maxNumIdx = 0;
            for (int i = 0; i < spt.length; i++) {
                if (!spt[i].equals("x")) {
                    int time = Integer.parseInt(spt[i]);
                    timeList.add(time);
                    timeDiff.add(i);
                    if (maxNum < time) {
                        maxNum = time;
                        maxNumIdx = i;
                    }
                }
            }
            boolean found = false;
            int endTime = 0;
            int busId = 0;
            for (int i = startTime; i < startTime + maxNum; i++) {
                if (found)
                    break;
                for (int j = 0; j < timeList.size(); j++) {
                    if (i % timeList.get(j) == 0) {
                        found = true;
                        endTime = i;
                        busId = timeList.get(j);
                        break;
                    }
                }
            }
            System.out.println("busId : " + busId + " endTime : " + endTime);
            System.out.println((endTime - startTime) * busId);
            Long multiAll = 1L;
            for (int i = 0; i < timeList.size(); i++) {
                multiAll *= timeList.get(i);
            }
            Long remainder = 0L;
            for (int i = 0; i < timeList.size(); i++) {
                long remain = -timeDiff.get(i);
                while (remain < 0) {
                    remain += timeList.get(i);
                }
                long multi = multiAll / timeList.get(i) * (remain) % multiAll;
                for (int j = 0; j < timeList.get(i); j++) {
                    if ((multiAll / timeList.get(i) * j) % timeList.get(i) == 1) {
                        remainder += (multi * j) % multiAll;
                        break;
                    }
                }
            }
            remainder %= multiAll;

            System.out.println(remainder % multiAll);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
