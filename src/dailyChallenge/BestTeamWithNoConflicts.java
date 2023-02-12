package dailyChallenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestTeamWithNoConflicts {

    static class Player{
        int score, age;

        public Player(int score, int age) {
            this.score = score;
            this.age = age;
        }
    }
    public static int bestTeamScore(int[] scores, int[] ages) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            players.add(new Player(scores[i], ages[i]));
        }
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.age == o2.age) {
                    return o2.score - o1.score;
                }
                return o2.age - o1.age;
            }
        });
        int[] prefixSum = new int[scores.length];
        int totalSum = 0, q = 0;
        for (Player i : players) {
            totalSum += i.score;
            prefixSum[q++] = totalSum;
        }

        int res = players.get(0).score;
        Player prevPlayer = players.get(0);
        for (int i = 1; i < players.size(); i++) {
            res += players.get(i).score;
            if (players.get(i).score > prevPlayer.score && players.get(i).age < prevPlayer.age) {
                if (totalSum - players.get(i).score > prefixSum[i]) {
                    res -= players.get(i).score;
                }else {
                    res = players.get(i).score;
                }
            }
            prevPlayer = players.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(bestTeamScore(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}));
    }
}
