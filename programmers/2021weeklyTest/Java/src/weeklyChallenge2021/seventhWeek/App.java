package weeklyChallenge2021.seventhWeek;

class Person {
    int enterOrder;
    int leaveOrder;

    public Person() {
    }
}

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int n = enter.length;
        int[] answer = new int[n];

        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            people[i] = new Person();
        }
        for (int i = 0; i < n; i++) {
            people[enter[i] - 1].enterOrder = i;
            people[leave[i] - 1].leaveOrder = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (people[j].enterOrder > people[i].enterOrder && people[j].leaveOrder < people[i].leaveOrder) {
                    answer[i]++;
                } else if (people[j].enterOrder < people[i].enterOrder && people[j].leaveOrder > people[i].leaveOrder) {
                    answer[i]++;
                } else if (people[j].enterOrder > people[i].enterOrder && people[j].leaveOrder > people[i].leaveOrder) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (people[k].enterOrder > people[i].enterOrder
                                    && people[k].enterOrder > people[j].enterOrder
                                    && people[k].leaveOrder < people[i].leaveOrder
                                    && people[k].leaveOrder < people[j].leaveOrder) {
                                answer[i]++;
                                break;
                            }
                        }
                    }
                } else if (people[j].enterOrder < people[i].enterOrder && people[j].leaveOrder < people[i].leaveOrder) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (people[k].enterOrder > people[i].enterOrder
                                    && people[k].enterOrder > people[j].enterOrder
                                    && people[k].leaveOrder < people[i].leaveOrder
                                    && people[k].leaveOrder < people[j].leaveOrder) {
                                answer[i]++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] enter = { 1, 4, 2, 3 };
        int[] leave = { 2, 1, 3, 4 };
        int[] answer = solution.solution(enter, leave);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }

    }
}
