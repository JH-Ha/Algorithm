package weeklyChallenge2021.week07;

class Person {
    int enterOrder;
    int leaveOrder;
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
                // 자기 자신의 경우는 제외
                if (i == j)
                    continue;
                // j가 i에 안쪽으로 포함되는 경우
                if (people[j].enterOrder > people[i].enterOrder && people[j].leaveOrder < people[i].leaveOrder) {
                    answer[i]++;
                    // j가 i에 바깥쪽으로 포함되는 경우
                } else if (people[j].enterOrder < people[i].enterOrder && people[j].leaveOrder > people[i].leaveOrder) {
                    answer[i]++;
                    // j의 입실 시간이 i에 포함되는 경우
                } else if (people[j].enterOrder > people[i].enterOrder && people[j].leaveOrder > people[i].leaveOrder) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (people[k].enterOrder > people[i].enterOrder
                                    && people[k].enterOrder > people[j].enterOrder
                                    && people[k].leaveOrder < people[i].leaveOrder) {
                                answer[i]++;
                                break;
                            }
                        }
                    }
                    // j의 퇴실 시간이 i에 포함되는 경우
                } else if (people[j].enterOrder < people[i].enterOrder && people[j].leaveOrder < people[i].leaveOrder) {
                    for (int k = 0; k < n; k++) {
                        if (k != i && k != j) {
                            if (people[k].enterOrder > people[i].enterOrder
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
