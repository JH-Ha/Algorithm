import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Day9 {
    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p9Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            List<Long> numberList = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                Long input = Long.parseLong(line);
                numberList.add(input);
            }

            List<Long> preamble = new LinkedList<>();
            for (int i = 0; i < 25; i++) {
                preamble.add(numberList.get(i));
            }
            Long invalidNumber = 0L;
            Long minValue = Long.MAX_VALUE;
            Long maxValue = Long.MIN_VALUE;

            int invalidIdx = 0;
            for (int i = 25; i < numberList.size(); i++) {
                boolean isPossible = false;
                for (int j = 0; j < 25; j++) {
                    for (int k = j + 1; k < 25; k++) {
                        if (numberList.get(i) == preamble.get(j) + preamble.get(k)) {
                            isPossible = true;
                        }
                    }
                }
                if (!isPossible) {
                    invalidNumber = numberList.get(i);
                    System.out.println(numberList.get(i));
                    invalidIdx = i;
                    break;
                }
                preamble.remove(0);
                preamble.add(numberList.get(i));
            }
            for (int i = 0; i < invalidIdx; i++) {
                for (int j = i + 1; j < invalidIdx; j++) {
                    Long sum = 0L;
                    for (int k = i; k < j; k++) {
                        sum += numberList.get(k);
                    }
                    if (sum.equals(invalidNumber)) {
                        System.out.println("equal");
                        for (int k = i; k < j; k++) {
                            minValue = Math.min(minValue, numberList.get(k));
                            maxValue = Math.max(maxValue, numberList.get(k));
                        }
                    }
                }
            }
            System.out.println("min : " + minValue);
            System.out.println("max : " + maxValue);
            System.out.println("sum : " + (minValue + maxValue));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}