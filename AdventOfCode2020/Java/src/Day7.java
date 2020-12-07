import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Bag {
    int num;
    String name;

    public Bag(int num, String name) {
        this.num = num;
        this.name = name;
    }
}

public class Day7 {

    // problem 1
    public static boolean findBag(List<Bag> bagList, String bagName, HashMap<String, List<Bag>> map) {
        if (bagList == null)
            return false;

        boolean result = false;
        for (Bag bag : bagList) {
            if (bag.name.equals(bagName))
                result = true;
            else {
                result |= findBag(map.get(bag.name), bagName, map);
            }
        }
        return result;
    }

    // problem 2
    public static int countNum(List<Bag> bagList, HashMap<String, List<Bag>> map, int num) {
        if (bagList == null) {
            return 0;
        }
        int result = 0;
        for (Bag bag : bagList) {
            result += num * bag.num;
            result += countNum(map.get(bag.name), map, num * bag.num);
        }
        return result;
    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p7Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            HashMap<String, List<Bag>> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                String[] spt = line.split(" contain ");
                String bagName = spt[0].split(" bag")[0];
                if (map.get(bagName) == null) {
                    if (spt[1].startsWith("no")) {
                        map.put(bagName, null);
                    } else {
                        String[] bagArr = spt[1].split(", ");
                        List<Bag> childBagList = new ArrayList<>();
                        for (int i = 0; i < bagArr.length; i++) {
                            int spaceIdx = bagArr[i].indexOf(" ");
                            int bagIdx = bagArr[i].indexOf("bag");
                            int num = Integer.parseInt(bagArr[i].substring(0, spaceIdx));
                            String childBag = bagArr[i].substring(spaceIdx + 1, bagIdx - 1);
                            childBagList.add(new Bag(num, childBag));
                        }
                        map.put(bagName, childBagList);
                    }
                }
            }
            int answer = 0;
            for (String bagName : map.keySet()) {
                if (findBag(map.get(bagName), "shiny gold", map)) {
                    answer++;
                }
            }

            System.out.println(answer);
            System.out.println(countNum(map.get("shiny gold"), map, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
