import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.File;

public class Day14 {
    public static String makeBaseTwo(Integer num) {
        StringBuilder builder = new StringBuilder();

        int length = 0;
        if (num == 0) {
            builder.append("0");
            length++;
        }
        while (num > 0) {
            if (num % 2 == 1) {
                builder.append("1");
            } else {
                builder.append("0");
            }
            num /= 2;
            length++;
        }
        while (length < 36) {
            builder.append("0");
            length++;
        }
        return builder.reverse().toString();
    }

    private static long calSum(String addressBaseTwo, Integer num) {
        int numX = 0;
        for (int i = 0; i < addressBaseTwo.length(); i++) {
            if (addressBaseTwo.charAt(i) == 'X') {
                numX++;
            }
        }
        return (long) (((long) num) * Math.pow(2.0, numX));
    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p14Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            String mask = null;
            Integer maxAddress = 0;
            Long[] mem = new Long[65536];
            Map<String, Long> memP2 = new HashMap<>();
            String[] mem2 = new String[65536];
            List<String> addressList = new ArrayList<>();
            List<Integer> numList = new ArrayList<>();
            for (int i = 0; i < 65536; i++) {
                mem[i] = 0L;
            }
            while ((line = br.readLine()) != null) {
                if (line.startsWith("mask")) {
                    mask = line.split(" = ")[1];
                } else if (line.startsWith("mem")) {
                    String[] spt = line.split(" = ");
                    Integer num = Integer.parseInt(spt[1]);
                    Integer address = Integer.parseInt(spt[0].substring(4, spt[0].length() - 1));

                    maxAddress = Math.max(maxAddress, address);
                    String baseTwo = makeBaseTwo(num);

                    String addressBaseTwo = makeBaseTwo(address);

                    long newNum = 0L;
                    StringBuilder newNumBuilder = new StringBuilder();
                    for (int i = 0; i < baseTwo.length(); i++) {

                        if (mask.charAt(i) == 'X') {
                            newNum += (baseTwo.charAt(i) - '0') * Math.pow(2.0, 35.0 - i);

                        } else if (mask.charAt(i) == '1') {
                            newNum += Math.pow(2.0, 35.0 - i);
                        }
                    }
                    // problem 2
                    for (int i = 0; i < addressBaseTwo.length(); i++) {
                        if (mask.charAt(i) == 'X') {
                            newNumBuilder.append('X');
                        } else if (mask.charAt(i) == '1') {
                            newNumBuilder.append('1');
                        } else {
                            newNumBuilder.append(addressBaseTwo.charAt(i));
                        }
                    }
                    numList.add(num);
                    addressList.add(newNumBuilder.toString());
                    // setMem(memP2, newNumBuilder.toString(), num);
                    mem[address] = newNum;
                    System.out.println(newNum);
                    System.out.println(baseTwo);
                    System.out.println(newNumBuilder.toString());
                }
            }
            long ans = 0;
            long ansP2 = 0L;
            for (int i = 0; i < 65536; i++) {
                ans += mem[i];
            }
            for (int i = addressList.size() - 1; i >= 0; i--) {
                String address = addressList.get(i);
                for (int j = i + 1; j < addressList.size(); j++) {
                    String address2 = addressList.get(j);
                    for (int k = 0; k < 36; k++) {
                        if (address.charAt(k) == 'X' && address2.charAt(k) != 'X') {
                            address = address.substring(0, k) + address2.charAt(k) + address.substring(k + 1);
                        }
                    }
                }
                int numX = 0;
                for (int j = 0; j < 36; j++) {
                    if (address.charAt(j) == 'X') {
                        numX++;
                    }
                }
                ansP2 += Math.pow(2.0, numX) * (long) numList.get(i);
            }
            System.out.println("ans : " + ans);
            System.out.println("ansP2 : " + ansP2);
            // System.out.println(maxAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
