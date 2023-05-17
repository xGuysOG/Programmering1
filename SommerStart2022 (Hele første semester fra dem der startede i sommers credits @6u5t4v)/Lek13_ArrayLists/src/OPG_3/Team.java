package OPG_3;

import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void printPlayers() {
        for (Player player : players) {
            System.out.printf("Navn: %s, Alder: %s, Score: %s", player.getName(), player.getAge(), player.getScore());
            System.out.println();
        }
    }

    public double calcAverageAge() {
        double average = 0.0;
        for (Player p : players) {
            average += p.getAge();
        }

        return average / players.size();
    }

    public int calcTotalScore() {
        int total = 0;
        for (Player p : players) {
            total += p.getScore();
        }

        return total;
    }

    public int calcOldPlayersScore(int ageLimit) {
        int score = 0;
        for (Player player : players) {
            if (player.getAge() > ageLimit) {
                score += player.getScore();
            }
        }

        return score;
    }

    public int maxScore() {
        int max = 0;

        for (int i = 0; i < players.size(); i++) {
            int score = players.get(i).getScore();
            if (score > max) {
                max = score;
            }
        }

        return max;
    }

    public String bestPlayer() {
        Player best = players.get(0);

        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            if (player.getScore() > best.getScore()) {
                best = player;
            }
        }

        return best.getName();
    }
}
