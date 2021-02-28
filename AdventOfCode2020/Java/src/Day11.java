import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day11 {
    static boolean isValid(int i, int j, int n, int m) {
        boolean result = false;
        if (i >= 0 && i < n && j >= 0 && j < m) {
            result = true;
        }
        return result;
    }

    static int checkAdjOccupied(int i, int j, int n, int m, int[][] seats) {

        int numAdjOccupied = 0;
        for (int x = i - 1; x <= i + 1; x++) {
            for (int y = j - 1; y <= j + 1; y++) {
                if (isValid(x, y, n, m) && (x != i || y != j) && (seats[x][y] == 2)) {
                    numAdjOccupied++;
                }
            }
        }
        return numAdjOccupied;
    }

    static int checkAdjOccupied2(int i, int j, int n, int m, int[][] seats) {

        int numAdjOccupied = 0;
        for (int x = i - 1; x >= 0; x--) {
            boolean isEnd = false;
            if (isValid(x, j, n, m) && seats[x][j] == 1) {
                isEnd = true;
            } else if (isValid(x, j, n, m) && seats[x][j] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        for (int x = i + 1; x < n; x++) {
            boolean isEnd = false;
            if (isValid(x, j, n, m) && seats[x][j] == 1) {
                isEnd = true;
            } else if (isValid(x, j, n, m) && seats[x][j] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        for (int y = j - 1; y >= 0; y--) {
            boolean isEnd = false;
            if (isValid(i, y, n, m) && seats[i][y] == 1) {
                isEnd = true;
            } else if (isValid(i, y, n, m) && seats[i][y] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        for (int y = j + 1; y < m; y++) {
            boolean isEnd = false;
            if (isValid(i, y, n, m) && seats[i][y] == 1) {
                isEnd = true;
            } else if (isValid(i, y, n, m) && seats[i][y] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        for (int x = i + 1, y = j + 1; x < n && y < m; x++, y++) {
            boolean isEnd = false;
            if (isValid(x, y, n, m) && seats[x][y] == 1) {
                isEnd = true;
            } else if (isValid(x, y, n, m) && seats[x][y] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        for (int x = i + 1, y = j - 1; x < n && y >= 0; x++, y--) {
            boolean isEnd = false;
            if (isValid(x, y, n, m) && seats[x][y] == 1) {
                isEnd = true;
            } else if (isValid(x, y, n, m) && seats[x][y] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        for (int x = i - 1, y = j + 1; x >= 0 && y < m; x--, y++) {
            boolean isEnd = false;
            if (isValid(x, y, n, m) && seats[x][y] == 1) {
                isEnd = true;
            } else if (isValid(x, y, n, m) && seats[x][y] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
            boolean isEnd = false;
            if (isValid(x, y, n, m) && seats[x][y] == 1) {
                isEnd = true;
            } else if (isValid(x, y, n, m) && seats[x][y] == 2) {
                numAdjOccupied++;
                isEnd = true;
            }
            if (isEnd) {
                break;
            }
        }
        return numAdjOccupied;
    }

    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p11Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            List<List<Integer>> map = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                List<Integer> row = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == 'L') {
                        row.add(1);
                    } else if (line.charAt(i) == '.') {
                        row.add(0);
                    }
                }
                map.add(row);
            }

            int[][] seats = new int[map.size()][map.get(0).size()];
            int[][] seatsAfter = new int[map.size()][map.get(0).size()];

            for (int i = 0; i < map.size(); i++) {
                for (int j = 0; j < map.get(0).size(); j++) {
                    seatsAfter[i][j] = map.get(i).get(j);
                }
            }
            boolean isDifferent = true;
            int numIter = 0;

            int n = map.size();
            int m = map.get(0).size();
            while (isDifferent) {
                for (int i = 0; i < n; i++) {
                    String row = "";
                    for (int j = 0; j < m; j++) {
                        if (seatsAfter[i][j] == 2) {
                            row += "#";
                        } else if (seatsAfter[i][j] == 1) {
                            row += "L";
                        } else {
                            row += ".";
                        }
                    }
                    System.out.println(row);
                }
                System.out.println();

                numIter++;
                for (int i = 0; i < map.size(); i++) {
                    for (int j = 0; j < map.get(0).size(); j++) {
                        seats[i][j] = seatsAfter[i][j];
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int occupiedNum = checkAdjOccupied(i, j, n, m, seats);
                        if (seats[i][j] == 0) {
                            seatsAfter[i][j] = seats[i][j];
                        } else if (occupiedNum == 0) {
                            seatsAfter[i][j] = 2;
                        } else if (occupiedNum >= 4) {
                            seatsAfter[i][j] = 1;
                        } else {
                            seatsAfter[i][j] = seats[i][j];
                        }
                    }
                }
                isDifferent = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (seats[i][j] != seatsAfter[i][j]) {
                            isDifferent = true;
                            break;
                        }
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (seats[i][j] == 2) {
                        cnt++;
                    }
                }
            }
            System.out.println(numIter);
            System.out.println("cnt : " + cnt);

            // problem 2

            for (int i = 0; i < map.size(); i++) {
                for (int j = 0; j < map.get(0).size(); j++) {
                    seatsAfter[i][j] = map.get(i).get(j);
                }
            }

            isDifferent = true;
            while (isDifferent) {
                for (int i = 0; i < n; i++) {
                    StringBuilder row = new StringBuilder();
                    for (int j = 0; j < m; j++) {
                        if (seatsAfter[i][j] == 2) {
                            row.append("#");
                        } else if (seatsAfter[i][j] == 1) {
                            row.append("L");
                        } else {
                            row.append(".");
                        }
                    }
                    System.out.println(row.toString());
                }
                System.out.println();

                numIter++;
                for (int i = 0; i < map.size(); i++) {
                    for (int j = 0; j < map.get(0).size(); j++) {
                        seats[i][j] = seatsAfter[i][j];
                    }
                }

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        int occupiedNum = checkAdjOccupied2(i, j, n, m, seats);
                        if (seats[i][j] == 0) {
                            seatsAfter[i][j] = seats[i][j];
                        } else if (occupiedNum == 0) {
                            seatsAfter[i][j] = 2;
                        } else if (occupiedNum >= 5) {
                            seatsAfter[i][j] = 1;
                        } else {
                            seatsAfter[i][j] = seats[i][j];
                        }
                    }
                }
                isDifferent = false;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (seats[i][j] != seatsAfter[i][j]) {
                            isDifferent = true;
                            break;
                        }
                    }
                }
            }
            cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (seats[i][j] == 2) {
                        cnt++;
                    }
                }
            }
            System.out.println("problem 2 : cnt : " + cnt);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
