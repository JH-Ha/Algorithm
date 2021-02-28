import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Number {
    int num;
    int idx;
    int prevIdx;

    public Number(int num, int idx, int prevIdx) {
        this.num = num;
        this.idx = idx;
        this.prevIdx = prevIdx;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        int MAX_NUM = 1000000010;
        int n;
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = sc.nextInt();

        Number[] savePos = new Number[n];

        Number[] numberArr = new Number[n];
        for (int i = 0; i < n; i++) {
            savePos[i] = new Number(MAX_NUM, -1, -1);
        }
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int l = 0;
            int r = n - 1;
            int pos = l;
            while (l <= r) {
                int mid = (r - l) / 2 + l;
                if (num <= savePos[mid].num) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            Number saveNum = savePos[pos];
            saveNum.num = num;
            saveNum.idx = i;
            int prevIdx = -1;
            if (pos != 0) {
                prevIdx = savePos[pos - 1].idx;
            }
            Number number = new Number(num, i, prevIdx);
            numberArr[i] = number;
        }
        int lastPos = 0;
        int len = 1;
        for (int i = 0; i < n; i++) {
            if (savePos[i].num == MAX_NUM) {
                lastPos = savePos[i - 1].idx;
                len = i;
                break;
            }
        }
        int pos = lastPos;
        Deque<Integer> s = new ArrayDeque<>();

        while (pos != -1) {
            s.push(numberArr[pos].num);
            pos = numberArr[pos].prevIdx;
        }
        System.out.println(len);
        while (!s.isEmpty()) {
            if (s.size() == 1)
                bw.write(Integer.toString(s.pop()));
            else
                bw.write(s.pop() + " ");
        }
        bw.flush();
        System.out.println();
    }
}
