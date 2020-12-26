package bestAlbum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Music {
    int id;
    int playNum;
    String genre;

    public Music(int id, int playNum, String genre) {
        this.id = id;
        this.playNum = playNum;
        this.genre = genre;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, List<Music>> map = new HashMap<>();
        Map<String, Integer> playSumMap = new HashMap<>();
        int n = genres.length;
        int[] answer = null;
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            int playNum = plays[i];
            List<Music> musicList = map.get(genre);
            Integer playSum = playSumMap.get(genre);
            if (musicList == null) {
                musicList = new ArrayList<>();
                map.put(genre, musicList);
            }
            if (playSum == null) {
                playSum = 0;
            }
            playSum += playNum;
            playSumMap.put(genre, playSum);
            musicList.add(new Music(i, playNum, genre));
        }
        List<Music> playSumList = new ArrayList<>();
        for (String genre : playSumMap.keySet()) {
            playSumList.add(new Music(0, playSumMap.get(genre), genre));
        }
        Collections.sort(playSumList, (Music a, Music b) -> {
            return b.playNum - a.playNum;
        });
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < playSumList.size(); i++) {
            Music music = playSumList.get(i);
            List<Music> musicList = map.get(music.genre);
            Collections.sort(musicList, (Music a, Music b) -> {
                int diff = b.playNum - a.playNum;
                if (diff > 0) {
                    return 1;
                } else if (diff == 0) {
                    return a.id - b.id;
                } else {
                    return -1;
                }
            });
            int countTwo = 0;
            for (int j = 0; j < musicList.size(); j++) {
                if (countTwo >= 2)
                    break;
                // answer[ansIdx] = musicList.get(j).id;
                answerList.add(musicList.get(j).id);
                countTwo++;
            }
        }
        int m = answerList.size();
        answer = new int[m];
        for (int i = 0; i < m; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        int[] ans = (solution.solution(genres, plays));
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}