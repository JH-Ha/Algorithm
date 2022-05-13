package pb;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static boolean moveUp(int[][] map, int n, int m){
        for(int j = 0; j < m; j ++){
            if(map[0][j] == 1){
                return false;
            }
        }
        for(int i = 1; i < n; i ++){
            for(int j = 0; j < m; j ++){
                map[i-1][j] = map[i][j];
            }
        }
        return checkPossible(map, n, m);
    }
    public static boolean moveLeft(int[][] map, int n, int m){
        for(int i = 0; i < n; i ++){
            if(map[i][0] == 1){
                return false;
            }
        }
        for(int j = 1; j < m; j ++){
            for(int i = 0; i < n; i ++){
                map[i][j-1] = map[i][j];
            }
        }
        return checkPossible(map, n, m);
    }
    public static boolean checkPossible(int[][] map, int n, int m){
        if(map[0][0] == 1){
            return true;
        }else{
            boolean isAllEmpty = true;
            for(int i = 0; i < n; i ++){
                for(int j = 0; j < m; j ++){
                    if(map[i][j] == 1){
                        isAllEmpty = false;
                    }
                }
            }
            if(isAllEmpty){
                return false;
            }
            int[][] copyMap1 = new int[n][m];
            int[][] copyMap2 = new int[n][m];
            for(int i = 0; i < n; i ++){
                for(int j = 0; j < m; j ++){
                    copyMap1[i][j] = map[i][j];
                    copyMap2[i][j] = map[i][j];
                }
            }
            boolean upResult = moveUp(copyMap1, n, m);
            boolean leftResult = moveLeft(copyMap2, n, m);
            return upResult || leftResult;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer t = Integer.parseInt(sc.nextLine());
        while(t-- > 0){
            List<Integer> input = Arrays.stream(sc.nextLine().split(" ")).map(str -> Integer.parseInt(str)).collect(Collectors.toList());
            Integer n = input.get(0);
            Integer m = input.get(1);
            
            int[][] map = new int[n][m];
            
            for(int i = 0; i < n; i ++){
                String[] line = sc.nextLine().split("");
                for(int j = 0; j < m; j ++){
                    String ch = line[j];
                    if("R".equals(ch)){
                        map[i][j] = 1;
                    }
                }
            }
            String ans = "NO";
            if(checkPossible(map, n, m)){
                ans = "YES";
            }
            System.out.println(ans);
        }
    }
}
