import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    class Element {
        int index;
        int num;

        public Element(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            int size = 0;

            PriorityQueue<Element> minPq = new PriorityQueue<>((a, b) -> {
                return a.num - b.num;
            });
            PriorityQueue<Element> maxPq = new PriorityQueue<>(new Comparator<Element>() {
                @Override
                public int compare(Element o1, Element o2) {
                    if (o1.num - o2.num < 0) {
                        return 1;
                    } else if (o1.num - o2.num == 0) {
                        return 0;
                    }
                    return -1;
                }
            });
            boolean[] isPop = new boolean[100010];
            for (int i = 0; i < operations.length; i++) {
                String[] spt = operations[i].split(" ");
                int num = Integer.parseInt(spt[1]);
                isPop[i] = false;
                if (spt[0].equals("I")) {
                    minPq.add(new Element(i, num));
                    maxPq.add(new Element(i, num));
                    size++;
                } else if (spt[0].equals("D")) {
                    if (size > 0) {
                        if (num == 1) {
                            Element top;
                            while (true) {
                                top = maxPq.poll();
                                if (!isPop[top.index]) {
                                    break;
                                }
                            }
                            size--;
                            isPop[top.index] = true;
                        } else {

                            Element top;
                            while (true) {
                                top = minPq.poll();
                                if (!isPop[top.index]) {
                                    break;
                                }
                            }
                            size--;
                            isPop[top.index] = true;
                        }
                    }
                }
            }
            if (size == 0) {
                answer[0] = 0;
                answer[1] = 0;
            } else {
                Element min;
                Element max;

                while (true) {
                    min = minPq.poll();
                    if (!isPop[min.index]) {
                        break;
                    }
                }
                while (true) {
                    max = maxPq.poll();
                    if (!isPop[max.index]) {
                        break;
                    }
                }
                answer[0] = max.num;
                answer[1] = min.num;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = (new DoublePriorityQueue()).new Solution();

        String[] operations = { "I 7", "I 5", "I -5", "D -1" };
        System.out.println(solution.solution(operations)[0] + " " + solution.solution(operations)[1]);
    }
}
