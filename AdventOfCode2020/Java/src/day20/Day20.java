package day20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

class Tile {
    String id;
    char[][] map;

    public Tile(String id, char[][] map) {
        this.id = id;
        this.map = map;
    }
}

class TileInfo{
    String id;
    int pos;
    
}

public class Day20 {
    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/day20/input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;

            Map<String, Tile> tileMap = new HashMap<>();
            Tile tile = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("Tile")) {
                    int blankIdx = line.indexOf(" ");
                    int colonIdx = line.indexOf(":");
                    String id = line.substring(blankIdx + 1, colonIdx);
                    System.out.println(id);
                    char[][] map = new char[10][10];
                    for (int i = 0; i < 10; i++) {
                        line = br.readLine();
                        for (int j = 0; j < line.length(); j++) {
                            map[i][j] = line.charAt(j);
                        }
                    }
                    tileMap.put(id, new Tile(id, map));
                }
            }
            System.out.println("test");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
