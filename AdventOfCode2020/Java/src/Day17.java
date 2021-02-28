import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day17 {
    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p17Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            int[][][] map = new int[30][30][30];
            int[][][] mapAfter = new int[30][30][30];
            int[][][][] mapP2 = new int[30][30][30][30];
            int[][][][] mapAfterP2 = new int[30][30][30][30];

            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    for (int k = 0; k < 30; k++) {
                        map[i][j][k] = 0;
                        for (int l = 0; l < 30; l++) {
                            mapP2[i][j][k][l] = 0;
                        }
                    }
                }
            }
            int row = 10;
            while ((line = br.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '#') {
                        map[row][10 + i][15] = 1;
                        mapP2[row][10 + i][15][15] = 1;
                    }
                }
                row++;
            }

            for (int t = 0; t < 6; t++) {
                for (int i = 1; i < 29; i++) {
                    for (int j = 1; j < 29; j++) {
                        for (int k = 1; k < 29; k++) {

                            // P1
                            int cnt = 0;
                            for (int x = i - 1; x <= i + 1; x++) {
                                for (int y = j - 1; y <= j + 1; y++) {
                                    for (int z = k - 1; z <= k + 1; z++) {
                                        if (x != i || y != j || z != k) {
                                            if (map[x][y][z] == 1) {
                                                cnt++;
                                            }
                                        }
                                    }
                                }
                            }
                            if (map[i][j][k] == 0) {
                                if (cnt == 3) {
                                    mapAfter[i][j][k] = 1;
                                } else {
                                    mapAfter[i][j][k] = 0;
                                }
                            } else if (map[i][j][k] == 1) {
                                if (cnt == 2 || cnt == 3) {
                                    mapAfter[i][j][k] = 1;
                                } else {
                                    mapAfter[i][j][k] = 0;
                                }
                            }

                            // P2

                            for (int l = 1; l < 29; l++) {
                                int cntP2 = 0;
                                for (int x = i - 1; x <= i + 1; x++) {
                                    for (int y = j - 1; y <= j + 1; y++) {
                                        for (int z = k - 1; z <= k + 1; z++) {
                                            for (int w = l - 1; w <= l + 1; w++) {
                                                if (x != i || y != j || z != k || w != l) {
                                                    if (mapP2[x][y][z][w] == 1) {
                                                        cntP2++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                if (mapP2[i][j][k][l] == 0) {
                                    if (cntP2 == 3) {
                                        mapAfterP2[i][j][k][l] = 1;
                                    } else {
                                        mapAfterP2[i][j][k][l] = 0;
                                    }
                                } else if (mapP2[i][j][k][l] == 1) {
                                    if (cntP2 == 2 || cntP2 == 3) {
                                        mapAfterP2[i][j][k][l] = 1;
                                    } else {
                                        mapAfterP2[i][j][k][l] = 0;
                                    }
                                }
                            }
                        }
                    }
                }

                for (int i = 0; i < 30; i++) {
                    for (int j = 0; j < 30; j++) {
                        for (int k = 0; k < 30; k++) {
                            map[i][j][k] = mapAfter[i][j][k];
                            // P2
                            for (int l = 0; l < 30; l++) {
                                mapP2[i][j][k][l] = mapAfterP2[i][j][k][l];
                            }
                        }
                    }
                }

            }
            int cnt = 0;
            int cntP2 = 0;
            for (int i = 0; i < 30; i++) {
                for (int j = 0; j < 30; j++) {
                    for (int k = 0; k < 30; k++) {
                        if (map[i][j][k] == 1) {
                            cnt++;
                        }
                        // P2
                        for (int l = 0; l < 30; l++) {
                            if (mapP2[i][j][k][l] == 1) {
                                cntP2++;
                            }
                        }
                    }
                }
            }
            System.out.println("ans : " + cnt);
            System.err.println("ansP2 : " + cntP2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
