import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.nextLine();
        Integer t = Integer.parseInt(numStr);
        while (t-- > 0) {
            String s = scanner.nextLine();
            String pattern100 = "100";
            String pattern1 = "1";
            String pattern01 = "01";
            int i = 0;
            int start = 0;
            String result = "YES";
            while (i < s.length()) {
                // 100+1+ match
                start = i;
                boolean isMatch = true;
                for (int j = 0; j < pattern100.length(); j++) {
                    if ((i + j >= s.length()) || (s.charAt(i + j) != pattern100.charAt(j))) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    i = i + pattern100.length();
                    while (i < s.length() && s.charAt(i) == '0') {
                        i++;
                    }
                    for (int j = 0; j < pattern1.length(); j++) {
                        if ((i + j >= s.length()) || (s.charAt(i + j) != pattern1.charAt(j))) {
                            isMatch = false;
                        }
                    }
                    if (isMatch) {
                        i = i + pattern1.length();
                        boolean matchOne = false;
                        while (i < s.length() && s.charAt(i) == '1') {
                            i++;
                            matchOne = true;
                        }
                        if (matchOne && i + 1 < s.length() && s.charAt(i) == '0' && s.charAt(i + 1) == '0') {
                            i = i - 1;
                        }
                    } else {
                        result = "NO";
                        break;
                    }
                } else {
                    isMatch = true;
                    // 01
                    i = start;
                    for (int j = 0; j < pattern01.length(); j++) {
                        if ((i + j >= s.length()) || (s.charAt(i + j) != pattern01.charAt(j))) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) {
                        i = i + pattern01.length();
                    } else {
                        result = "NO";
                        break;
                    }
                }
            }
            System.out.println(result);
        }
        scanner.close();
    }
}