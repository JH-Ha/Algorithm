import java.util.*;

class Node {
    int id;
    int numParent;
    List<Integer> childList;

    public Node(int id) {
        this.id = id;
        childList = new ArrayList<Integer>();
        numParent = 0;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] spt = line.split(" ");

        int n = Integer.parseInt(spt[0]);
        int m = Integer.parseInt(spt[1]);

        Node[] nodeArr = new Node[n + 1];
        for (int i = 0; i <= n; i++) {
            nodeArr[i] = new Node(i);
        }
        for (int i = 0; i < m; i++) {
            line = sc.nextLine();
            spt = line.split(" ");
            int l = Integer.parseInt(spt[0]);
            int r = Integer.parseInt(spt[1]);
            nodeArr[l].childList.add(r);
            nodeArr[r].numParent++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (nodeArr[i].numParent == 0) {
                q.add(i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int top = q.poll();
            answer.add(top);
            for (int i = 0; i < nodeArr[top].childList.size(); i++) {
                int childId = nodeArr[top].childList.get(i);
                nodeArr[childId].numParent--;
                if (nodeArr[childId].numParent == 0) {
                    q.add(childId);
                }
            }
        }
        answer.stream().forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();
        sc.close();
    }
}
