import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day16 {
    static long cnt = 0L;

    public static void createPermutation(LinkedList<Integer> permutation, boolean[] used, int n,
            List<List<Integer>> ticketList, int[][] p2ValidRange, List<List<Integer>> validList) {
        if (permutation.size() == n) {
            cnt++;
            // if (cnt % 100000 == 0) {
            System.out.println(cnt + "!!!!");
            for (int i = 0; i < permutation.size(); i++) {
                System.out.print(permutation.get(i) + " ");
            }
            System.out.println("valid!!");
            int[] myTicket = { 103, 197, 83, 101, 109, 181, 61, 157, 199, 137, 97, 179, 151, 89, 211, 59, 139, 149, 53,
                    107 };
            long ans = 1L;
            for (int i = 0; i < 6; i++) {
                ans *= myTicket[permutation.get(i)];
            }
            System.out.println("P2 answer : " + ans);
            return;

        }
        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;
            int pos = permutation.size();
            List<Integer> validNum = validList.get(pos);
            boolean isValid = false;
            for (int j = 0; j < validNum.size(); j++) {
                if (validNum.get(j) == i) {
                    isValid = true;
                }
            }
            if (!isValid)
                continue;
            if (!used[i]) {
                permutation.add(i);
                used[i] = true;
                createPermutation(permutation, used, n, ticketList, p2ValidRange, validList);
                used[i] = false;
                permutation.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p16Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            boolean[] numValid = new boolean[1000];
            int[][] p2ValidRange = new int[20][4];
            for (int i = 0; i < 1000; i++) {
                numValid[i] = false;
            }
            int idx = 0;
            while ((line = br.readLine()) != null) {
                if (line.equals(""))
                    break;
                String[] spt = line.split(": ");
                String[] spt2 = spt[1].split(" or ");
                for (int i = 0; i < spt2.length; i++) {
                    String[] numRange = spt2[i].split("-");
                    for (int j = Integer.parseInt(numRange[0]); j <= Integer.parseInt(numRange[1]); j++) {
                        numValid[j] = true;
                    }
                    p2ValidRange[idx][2 * i + 0] = Integer.parseInt(numRange[0]);
                    p2ValidRange[idx][2 * i + 1] = Integer.parseInt(numRange[1]);
                }
                idx++;
            }
            while ((line = br.readLine()) != null) {
                if (line.equals("nearby tickets:"))
                    break;
            }
            long ans = 0L;
            List<List<Integer>> ticketList = new ArrayList<>();

            while ((line = br.readLine()) != null) {
                String[] numArr = line.split(",");
                boolean isValid = true;
                for (int i = 0; i < numArr.length; i++) {
                    if (!numValid[Integer.parseInt(numArr[i])]) {
                        ans += Integer.parseInt(numArr[i]);
                        isValid = false;
                    }
                }
                if (isValid) {
                    List<Integer> ticket = new ArrayList<>();
                    for (int i = 0; i < numArr.length; i++) {
                        ticket.add(Integer.parseInt(numArr[i]));
                    }
                    ticketList.add(ticket);
                }
            }
            System.out.println(ans);
            int numClass = 20;
            boolean[] used = new boolean[numClass];
            for (int i = 0; i < numClass; i++) {
                used[i] = false;
            }
            List<List<Integer>> validList = new ArrayList<>();
            for (int i = 0; i < numClass; i++) {
                List<Integer> validListLocal = new ArrayList<>();

                for (int k = 0; k < numClass; k++) {
                    boolean isValid = true;
                    for (int j = 0; j < ticketList.size(); j++) {
                        List<Integer> ticket = ticketList.get(j);
                        if ((ticket.get(k) >= p2ValidRange[i][0] && ticket.get(k) <= p2ValidRange[i][1])
                                || (ticket.get(k) >= p2ValidRange[i][2] && ticket.get(k) <= p2ValidRange[i][3])) {

                        } else {
                            isValid = false;
                        }
                    }
                    if (isValid) {
                        validListLocal.add(k);
                    }
                }
                validList.add(validListLocal);
            }
            long size = 1L;
            for (int i = 0; i < numClass; i++) {
                size *= validList.get(i).size();
            }
            System.out.println(size);
            createPermutation(new LinkedList<>(), used, numClass, ticketList, p2ValidRange, validList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}