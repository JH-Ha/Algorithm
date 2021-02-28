package day21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day21 {
    public static boolean solved = false;

    public static void findSolution(Map<String, String> usedFood, Map<String, String> usedAllergen,
            List<List<String>> foodListTwo, List<List<String>> allergenListTwo) {
        int n = allergenListTwo.size();
        for (int i = 0; i < n; i++) {
            List<String> foodList = foodListTwo.get(i);
            List<String> allergenList = allergenListTwo.get(i);

            // for (int j = 0; j < foodList.size(); j++) {
            // String food = foodList.get(j);
            // String foodAllergen = usedFood.get(food);
            // if (foodAllergen != null) {
            // boolean contains = false;
            // for (int k = 0; k < allergenList.size(); k++) {
            // if (foodAllergen.equals(allergenList.get(k))) {
            // contains = true;
            // }
            // }
            // if (!contains) {
            // return;
            // }
            // }
            // }

            for (int j = 0; j < allergenList.size(); j++) {
                String allergen = allergenList.get(j);
                if (usedAllergen.get(allergen) == null) {
                    if (allergen.equals("soy")) {
                        System.out.println("soy");
                    }
                    for (int k = 0; k < foodList.size(); k++) {
                        String food = foodList.get(k);
                        if (usedFood.get(food) == null) {
                            usedFood.put(food, allergen);
                            usedAllergen.put(allergen, food);
                            findSolution(usedFood, usedAllergen, foodListTwo, allergenListTwo);
                            // int unused = 0;
                            // for (String allergenTmp : usedAllergen.keySet()) {
                            // if (usedAllergen.get(allergenTmp) == null) {
                            // unused++;
                            // }
                            // }
                            // if (unused == 0) {
                            // System.out.println("solve");
                            // solved = true;
                            // }
                            // if (solved)
                            // return;
                            usedAllergen.put(allergen, null);
                            usedFood.put(food, null);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            List<String> foodList = foodListTwo.get(i);
            List<String> allergenList = allergenListTwo.get(i);

            for (int j = 0; j < foodList.size(); j++) {
                String food = foodList.get(j);
                String foodAllergen = usedFood.get(food);
                if (foodAllergen != null) {
                    boolean contains = false;
                    for (int k = 0; k < allergenList.size(); k++) {
                        if (foodAllergen.equals(allergenList.get(k))) {
                            contains = true;
                        }
                    }
                    if (!contains) {
                        return;
                    }
                }
            }
            // for (int j = 0; j < allergenList.size(); j++) {
            // String allergen = allergenList.get(j);
            // String allergenFood = usedAllergen.get(allergen);
            // if (allergenFood != null) {
            // boolean contains = false;
            // for (int k = 0; k < foodList.size(); k++) {
            // if (allergenFood.equals(foodList.get(k))) {
            // contains = true;
            // }
            // }
            // if (!contains) {
            // return;
            // }
            // } else {
            // return;
            // }
            // }
        }
        solved = true;

    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/day21/input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;

            Map<String, String> usedFood = new HashMap<>();
            Map<String, String> usedAllergen = new HashMap<>();

            List<List<String>> foodListTwo = new ArrayList<>();
            List<List<String>> allergenListTwo = new ArrayList<>();

            Map<String, Integer> foodCnt = new HashMap<>();
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                List<String> foodList = null;
                List<String> allergenList = null;
                String[] spt = line.split(" \\(contains ");
                String[] foods = spt[0].split(" ");
                foodList = Arrays.asList(foods);
                String[] allergens = spt[1].substring(0, spt[1].length() - 1).split(", ");
                allergenList = Arrays.asList(allergens);
                for (int i = 0; i < foods.length; i++) {
                    usedFood.put(foods[i], null);
                    if (foodCnt.get(foods[i]) == null) {
                        foodCnt.put(foods[i], 1);
                    } else {
                        foodCnt.put(foods[i], foodCnt.get(foods[i]) + 1);
                    }
                }
                for (int i = 0; i < allergens.length; i++) {
                    usedAllergen.put(allergens[i], null);
                }
                foodListTwo.add(foodList);
                allergenListTwo.add(allergenList);
            }
            findSolution(usedFood, usedAllergen, foodListTwo, allergenListTwo);
            long ans = 0;
            for (String food : usedFood.keySet()) {
                if (usedFood.get(food) == null) {
                    ans += foodCnt.get(food);
                }
            }
            System.out.println("ans : " + ans);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
