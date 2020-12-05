import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

class Day4 {

    static String[] fields = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };

    static boolean checkValid(HashMap<String, String> passport) {

        for (String field : fields) {
            String value = passport.get(field);
            if (value == null) {
                return false;
            }
        }

        String byr = passport.get("byr");

        int byrInt = Integer.parseInt(byr);
        if (byrInt < 1920 || byrInt > 2002) {
            return false;
        }
        String iyr = passport.get("iyr");
        int iyrInt = Integer.parseInt(iyr);
        if (iyrInt < 2010 || iyrInt > 2020) {
            return false;
        }
        String eyr = passport.get("eyr");
        int eyrInt = Integer.parseInt(eyr);
        if (eyrInt < 2020 || eyrInt > 2030) {
            return false;
        }
        String hgt = passport.get("hgt");
        int inIdx = hgt.indexOf("in");
        int cmIdx = hgt.indexOf("cm");
        if (inIdx != -1) {
            int hgtIn = Integer.parseInt(hgt.substring(0, inIdx));
            if (hgtIn < 59 || hgtIn > 76) {
                return false;
            }
        } else if (cmIdx != -1) {
            int hgtCm = Integer.parseInt(hgt.substring(0, cmIdx));
            if (hgtCm < 150 || hgtCm > 193) {
                return false;
            }
        } else {
            return false;
        }
        String hcl = passport.get("hcl");
        int shopIdx = hcl.indexOf("#");
        if (hcl.length() != 7) {
            return false;
        } else if (shopIdx == -1) {
            return false;
        } else {
            for (int i = 1; i < 7; i++) {
                int ch = hcl.charAt(i);
                boolean val = false;
                if (ch >= '0' && ch <= '9')
                    val = true;
                if (ch >= 'a' && ch <= 'f')
                    val = true;
                if (!val)
                    return false;
            }
        }

        String ecl = passport.get("ecl");
        String[] colorList = { "amb", "blu", "brn", "gry", "grn", "hzl", "oth" };
        boolean val = false;
        for (String color : colorList) {
            if (color.equals(ecl)) {
                val = true;
            }
        }
        if (!val)
            return false;
        String pid = passport.get("pid");
        if (pid.length() != 9)
            return false;

        return true;
    }

    public static void main(String[] args) {
        File file = new File("/home/Algorithm/AdventOfCode2020/Java/src/p4Input.txt");
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);) {
            String line;

            HashMap<String, String> passport = new HashMap<>();
            int ans = 0;
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    if (checkValid(passport)) {
                        ans++;
                    }
                    passport.clear();
                } else {
                    String[] spt = line.split(" ");
                    for (String s : spt) {
                        String[] sp = s.split(":");
                        passport.put(sp[0], sp[1]);
                    }
                }
            }
            if (checkValid(passport)) {
                ans++;
            }
            System.out.println(ans);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}