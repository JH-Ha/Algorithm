import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Edge {
    int x1;
    int y1;
    int x2;
    int y2;

    public Edge(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

class Input {
    int t;
    String turn;

    public Input(int t, String turn) {
        this.t = t;
        this.turn = turn;
    }
}

public class Main {
    public static boolean checkRange(int a1, int a2, int b) {
        if (a1 > a2) {
            int tmp = a1;
            a1 = a2;
            a2 = tmp;
        }
        if (a1 <= b && b <= a2) {
            return true;
        }
        return false;
    }

    public static boolean isValid(List<Edge> edgeList, Edge checkEdge) {
        int n = edgeList.size();
        for (int i = 0; i < n; i++) {
            Edge edge = edgeList.get(i);
            // 가로
            if (edge.y1 == edge.y2) {
                // 체크하려는 edge는 세로
                if (checkEdge.x1 == checkEdge.x2 && checkRange(checkEdge.y1, checkEdge.y2, edge.y1)
                        && checkRange(edge.x1, edge.x2, checkEdge.x1)) {
                    return false;
                    // edge가 똑같이 가로인 경우
                } else if (edge.y1 == checkEdge.y1) {
                    if (checkRange(edge.x1, edge.x2, checkEdge.x1) || checkRange(edge.x1, edge.x2, checkEdge.x2)) {
                        return false;
                    }
                    if (checkRange(checkEdge.x1, checkEdge.x2, edge.x1)
                            || checkRange(checkEdge.x1, checkEdge.x2, edge.x2)) {
                        return false;
                    }
                }
            } else {
                // edge가 가로인 경우
                if (checkEdge.y1 == checkEdge.y2 && checkRange(checkEdge.x1, checkEdge.x2, edge.x1)
                        && checkRange(edge.y1, edge.y2, checkEdge.y1)) {
                    return false;
                    // edge가 똑같이 세로인 경우
                } else if (edge.x1 == checkEdge.x1) {
                    if (checkRange(edge.y1, edge.y2, checkEdge.y1) || checkRange(edge.y1, edge.y2, checkEdge.y2)) {
                        return false;
                    }
                    if (checkRange(checkEdge.y1, checkEdge.y2, edge.y1)
                            || checkRange(checkEdge.y1, checkEdge.y2, edge.y2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int L;
        int N;
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        N = sc.nextInt();

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        int curX = 1;
        int curY = 0;
        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(0, 0, 0, 0));
        sc.nextLine();
        int pos = 0;
        long survived = 1;

        List<Input> inputList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int t;
            String turn;
            // t = sc.nextInt();
            // turn
            String line = sc.nextLine();
            String[] spt = line.split(" ");
            t = Integer.parseInt(spt[0]);
            turn = spt[1];

            inputList.add(new Input(t, turn));
            // System.out.println(t + " " + turn);

        }
        inputList.add(new Input(2 * L + 1, "L"));

        for (int i = 0; i <= N; i++) {
            Input input = inputList.get(i);
            int t = input.t;
            String turn = input.turn;

            int nextX = curX + dx[pos] * (t - 1);
            int nextY = curY + dy[pos] * (t - 1);

            boolean isOut = false;
            if (nextX > L || nextX < -L || nextY > L || nextY < -L) {
                isOut = true;

                int l = 0;
                int r = t - 1;
                int ans = l;
                while (l <= r) {
                    int mid = (r - l) / 2 + l;
                    nextX = curX + dx[pos] * mid;
                    nextY = curY + dy[pos] * mid;
                    if ((nextX <= L && nextX >= -L) && (nextY <= L && nextY >= -L)) {
                        ans = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                nextX = curX + dx[pos] * ans;
                nextY = curY + dy[pos] * ans;
                t = ans + 1;
            }
            Edge edge = new Edge(curX, curY, nextX, nextY);
            if (!isValid(edgeList, edge)) {
                int l = 0;
                int r = t - 1;
                int ans = -1;
                while (l <= r) {
                    int mid = (r - l) / 2 + l;
                    nextX = curX + dx[pos] * mid;
                    nextY = curY + dy[pos] * mid;
                    edge.x2 = nextX;
                    edge.y2 = nextY;
                    if (isValid(edgeList, edge)) {
                        ans = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                survived += (ans + 1);
                break;
            } else {
                edgeList.add(edge);
                survived += t;
                if (turn.equals("L")) {
                    pos--;
                    if (pos < 0)
                        pos += 4;
                } else if (turn.equals("R")) {
                    pos++;
                    pos %= 4;
                }
                curX = nextX + dx[pos];
                curY = nextY + dy[pos];
            }
            if (isOut) {
                break;
            }
        }

        System.out.println(survived);
    }
}
