import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {
    static int n;
    static int m;
    static Integer arr[];

    public static void union(int a, int b) {
        int pa = findParent(a);
        int pb = findParent(b);
        if (pa < pb) {
            arr[pb] = pa;
        } else {
            arr[pa] = pb;
        }
    }

    public static int findParent(int a) {
        if (arr[a] == a) {
            return a;
        }
        return findParent(arr[a]);
    }

    public static boolean check(int a, int b) {
        if (findParent(a) == findParent(b)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new Integer[n + 1];
            for (int i = 0; i <= n; i++) {
                arr[i] = i;
            }
            for (int i = 0; i < m; i++) {

                st = new StringTokenizer(br.readLine(), " ");
                int type, a, b;
                type = Integer.parseInt(st.nextToken());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                if (type == 0) {
                    union(a, b);
                } else if (check(a, b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}