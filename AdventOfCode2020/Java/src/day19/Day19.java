package day19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.AsyncBoxView.ChildLocator;

class Node {
    String id;
}

class InternalNode extends Node {
    List<List<String>> childList;

    public InternalNode(String[] childNumArr, String id) {
        this.id = id;
        childList = new ArrayList<>();
        for (int i = 0; i < childNumArr.length; i++) {
            String[] childNum = childNumArr[i].split(" ");
            List<String> childNumList = new ArrayList<>();
            for (int j = 0; j < childNum.length; j++) {
                childNumList.add(childNum[j]);
            }
            childList.add(childNumList);
        }
    }
}

class LeafNode extends Node {
    String str;

    public LeafNode(String str, String id) {
        this.str = str;
        this.id = id;
    }
}

public class Day19 {
    static int num8Cnt = 0;
    static int num11Cnt = 0;
    static int[] numCount = new int[50];

    public static List<String> makeValidString(Node node, Map<String, Node> nodeMap) {
        numCount[Integer.parseInt(node.id)]++;
        for (int i = 0; i < 50; i++) {
            System.out.print(numCount[i] + " ");

            if (numCount[i] > 1000) {
                List<String> list = new ArrayList<>();
                list.add("");
                return list;
            }
        }
        System.out.println();
        // if (node.id.equals("42")) {
        // num11Cnt++;
        // System.out.println("11");
        // if (num11Cnt > 10) {
        // System.out.println("100!! : " + num11Cnt);
        // List<String> list = new ArrayList<>();
        // list.add("");
        // return list;
        // }
        // } else if (node.id.equals("8")) {
        // num8Cnt++;
        // if (num8Cnt > 10) {
        // List<String> list = new ArrayList<>();
        // list.add("");
        // return list;
        // }
        // }
        if (node instanceof LeafNode) {
            List<String> list = new ArrayList<>();
            list.add(((LeafNode) node).str);
            return list;
        } else {
            InternalNode internalNode = (InternalNode) node;
            List<String> returnList = new ArrayList<>();

            // '|'(또는)으로 연결된 횟수만큼 반복문이 실행된다.
            for (int i = 0; i < internalNode.childList.size(); i++) {

                // resultList에 연결된 애들의 정보를 넣어준다.
                List<String> resultList = new ArrayList<>();
                resultList.add("");
                List<String> childNumList = internalNode.childList.get(i);
                for (int j = 0; j < childNumList.size(); j++) {
                    Node nextNode = nodeMap.get(childNumList.get(j));
                    List<String> list = makeValidString(nextNode, nodeMap);
                    List<String> newList = new ArrayList<>();
                    // list에는 해당 수의 모든 경우의 수가 들어가 있으므로
                    // 이전에 연결된것과 현재 나온 애들을 전부 연결시켜준다.
                    for (int k = 0; k < resultList.size(); k++) {
                        for (int l = 0; l < list.size(); l++) {
                            newList.add(resultList.get(k) + list.get(l));
                        }
                    }
                    resultList = newList;
                }
                // 결과 값을 return해주기 위해서 결과로 나온애들을 저장해준다.
                for (int j = 0; j < resultList.size(); j++) {
                    returnList.add(resultList.get(j));
                }
            }
            return returnList;
        }
    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/day19/p19Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;

            Map<String, Node> nodeMap = new HashMap<>();
            // make rule
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                if (line.equals("")) {
                    break;
                }
                String[] spt = line.split(": ");
                String id = spt[0];
                String[] rule = spt[1].split(" \\| ");
                if (spt[1].indexOf("\"") == -1) {
                    nodeMap.put(id, new InternalNode(rule, id));
                } else {
                    nodeMap.put(id, new LeafNode(spt[1].substring(1, spt[1].length() - 1), id));
                }
            }
            Node node = nodeMap.get("0");
            // List<String> resultList = makeValidString(node, nodeMap);

            String[] rule8 = { "42", "42 42" };
            String[] rule11 = { "42 31", "42 42 31 31" };
            nodeMap.put("8", new InternalNode(rule8, "8"));
            nodeMap.put("11", new InternalNode(rule11, "11"));
            List<String> resultListP2 = makeValidString(node, nodeMap);

            Set<String> validSet = new HashSet<>();
            // for (int i = 0; i < resultList.size(); i++) {
            // validSet.add(resultList.get(i));
            // }

            Set<String> validSetP2 = new HashSet<>();
            for (int i = 0; i < resultListP2.size(); i++) {
                validSetP2.add(resultListP2.get(i));
            }

            int ans = 0;
            int ansP2 = 0;
            while ((line = br.readLine()) != null) {
                if (validSet.contains(line)) {
                    ans++;
                }
                if (validSetP2.contains(line)) {
                    ansP2++;
                }
            }
            System.out.println("p1 ans : " + ans);
            System.out.println("p2 ans : " + ansP2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
