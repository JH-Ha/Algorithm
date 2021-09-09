package weeklyChallenge2021.sixthWeek;

import java.util.ArrayList;
import java.util.List;

class Player {
    int id;
    int weight;
    int numWin;
    int numGame;
    int numWinOverWeight;
    double winRate;

    public Player(int id, int weight) {
        this.id = id;
        this.weight = weight;
        this.numWin = 0;
        this.numGame = 0;
        this.numWinOverWeight = 0;
    }
}

class Solution {
    public int[] solution(int[] weights, String[] head2head) {

        int n = weights.length;
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(i + 1, weights[i]));
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (head2head[i].charAt(j) != 'N') {
                    players.get(i).numGame++;
                }
                if (head2head[i].charAt(j) == 'W') {
                    players.get(i).numWin++;
                    if (players.get(j).weight > players.get(i).weight) {
                        players.get(i).numWinOverWeight++;
                    }
                }
            }
        }
        players.stream().forEach(a -> {
            if (a.numGame > 0) {
                a.winRate = (double) a.numWin / a.numGame;
            }
        });

        players.sort((a, b) -> {
            if (a.winRate != b.winRate) {
                return (b.winRate - a.winRate) > 0 ? 1 : -1;
            } else if (a.numWinOverWeight != b.numWinOverWeight) {
                return b.numWinOverWeight - a.numWinOverWeight;
            } else if (a.weight != b.weight) {
                return b.weight - a.weight;
            } else {
                return a.id - b.id;
            }
        });

        return players.stream().mapToInt(a -> a.id).toArray();

    }
}

public class App {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weights = { 50, 82, 75, 120 };
        String[] head2head = { "NLWL", "WNLL", "LWNW", "WWLN" };
        int[] answer = (solution.solution(weights, head2head));
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
