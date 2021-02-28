import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Day12 {
    public static void main(String[] args) {
        File file = new File("/home/hjh/Algorithm/AdventOfCode2020/Java/src/p12Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line = null;

            Integer ew = 0;
            Integer ns = 0;
            Integer face = 1;
            // north : 0
            // east : 1
            // south : 2
            // west : 3

            Integer ew2 = 0;
            Integer ns2 = 0;

            Integer[] wayPoint = { 1, 10, 0, 0 };

            while ((line = br.readLine()) != null) {
                Integer num = Integer.parseInt(line.substring(1));
                if (line.startsWith("N")) {
                    ns += num;
                    wayPoint[0] += num;
                } else if (line.startsWith("S")) {
                    ns -= num;
                    wayPoint[2] += num;
                } else if (line.startsWith("E")) {
                    ew += num;
                    wayPoint[1] += num;
                } else if (line.startsWith("W")) {
                    ew -= num;
                    wayPoint[3] += num;
                } else if (line.startsWith("F")) {
                    switch (face) {
                        case 0:
                            ns += num;
                            break;
                        case 1:
                            ew += num;
                            break;
                        case 2:
                            ns -= num;
                            break;
                        case 3:
                            ew -= num;
                            break;
                        default:
                            break;
                    }

                    ns2 += wayPoint[0] * num;
                    ns2 -= wayPoint[2] * num;
                    ew2 += wayPoint[1] * num;
                    ew2 -= wayPoint[3] * num;

                } else if (line.startsWith("R")) {
                    face += num / 90;
                    face %= 4;

                    int cnt = num / 90;
                    while (cnt-- > 0) {
                        int tmp = wayPoint[3];
                        for (int i = 2; i >= 0; i--) {
                            wayPoint[i + 1] = wayPoint[i];
                        }
                        wayPoint[0] = tmp;
                    }
                } else if (line.startsWith("L")) {
                    face -= num / 90;
                    face += 4;
                    face %= 4;

                    int cnt = num / 90;
                    while (cnt-- > 0) {
                        int tmp = wayPoint[0];
                        for (int i = 1; i < 4; i++) {
                            wayPoint[i - 1] = wayPoint[i];
                        }
                        wayPoint[3] = tmp;
                    }
                }
            }

            System.out.println("ns : " + ns + " ew : " + ew);
            System.out.println("sum : " + (Math.abs(ns) + Math.abs(ew)));

            System.out.println("ns2 : " + ns2 + " ew2 : " + ew2);
            System.out.println("sum : " + (Math.abs(ns2) + Math.abs(ew2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
