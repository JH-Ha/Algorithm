package p3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public Integer getMinutes(String time) {
        String[] spt = time.split(":");
        Integer hours = Integer.parseInt(spt[0]);
        Integer minutes = Integer.parseInt(spt[1]);
        return hours * 60 + minutes;
    }

    class ParkingInfo {
        String carNumber;
        Integer fee;

        public Integer getFee() {
            return fee;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int minimumTime = fees[0];
        int minimumFee = fees[1];
        int timeUnit = fees[2];
        int feeUnit = fees[3];

        Map<String, String> timeRecord = new HashMap<>(); // car number, time
        Map<String, Integer> parkingTimeSum = new HashMap<>(); // car number, timeSum

        for (int i = 0; i < records.length; i++) {
            String[] spt = records[i].split(" ");

            String time = spt[0];
            String carNumber = spt[1];
            String order = spt[2];
            if ("IN".equals(order)) {
                timeRecord.put(carNumber, time);
            } else if ("OUT".equals(order)) {
                Integer inTime = getMinutes(timeRecord.get(carNumber));
                Integer outTime = getMinutes(time);
                Integer timeSum = parkingTimeSum.getOrDefault(carNumber, 0);
                timeSum += (outTime - inTime);
                parkingTimeSum.put(carNumber, timeSum);
                timeRecord.remove(carNumber);
            }
        }
        for (String carNumber : timeRecord.keySet()) {
            Integer inTime = getMinutes(timeRecord.get(carNumber));
            Integer outTime = 23 * 60 + 59;
            Integer timeSum = parkingTimeSum.getOrDefault(carNumber, 0);
            timeSum += (outTime - inTime);
            parkingTimeSum.put(carNumber, timeSum);
        }
        List<ParkingInfo> parkingFees = new ArrayList<>();
        for (String carNumber : parkingTimeSum.keySet()) {
            ParkingInfo parkingInfo = new ParkingInfo();
            parkingInfo.carNumber = carNumber;
            Integer parkingTime = parkingTimeSum.get(carNumber);
            Integer fee = 0;
            if (parkingTime <= minimumTime) {
                fee = minimumFee;
            } else {
                fee = minimumFee + (int) Math.ceil((parkingTime - minimumTime) / ((double) timeUnit)) * feeUnit;
            }
            parkingInfo.fee = fee;
            parkingFees.add(parkingInfo);
        }
        return parkingFees.stream()
                .sorted((a, b) -> a.carNumber.compareTo(b.carNumber))
                .mapToInt(ParkingInfo::getFee).toArray();
    }
}

public class Main {
    public static void main(String[] args) {
        int[] fees = { 180, 5000, 10, 600 };
        String[] records = { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };
        Solution solution = new Solution();
        int[] answer = solution.solution(fees, records);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}