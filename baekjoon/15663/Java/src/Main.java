import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void makeCombination(List<Integer> numList, Set<Integer> used, int depth, Set<String> usedCombi,
            ArrayList<Integer> answer) {
        if (depth == 0) {
            String combiNum = "";
            for (int i = 0; i < answer.size(); i++) {
                combiNum += answer.get(i);
            }
            if (!usedCombi.contains(combiNum)) {
                usedCombi.add(combiNum);
                for (int i = 0; i < answer.size(); i++) {
                    System.out.print(answer.get(i) + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < numList.size(); i++) {
                if (!used.contains(i)) {
                    answer.add(numList.get(i));
                    used.add(i);
                    makeCombination(numList, used, depth - 1, usedCombi, answer);
                    used.remove(i);
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        Set<String> set = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] spt = line.split(" ");
        int n = Integer.parseInt(spt[0]);
        int m = Integer.parseInt(spt[1]);

        line = sc.nextLine();
        spt = line.split(" ");
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < spt.length; i++) {
            numList.add(Integer.parseInt(spt[i]));
        }
        numList.sort((Integer a, Integer b) -> {
            return a - b;
        });
        Set<Integer> used = new HashSet<>();
        Set<String> usedCombi = new HashSet<>();
        ArrayList<Integer> answer = new ArrayList<>();
        Main.makeCombination(numList, used, m, usedCombi, answer);
        sc.close();
    }
}
