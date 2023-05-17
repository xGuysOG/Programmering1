package Opgave3;

import java.util.ArrayList;

public class Team {
    private String name;

    private ArrayList<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void printPlayers() {
        for(Player player : players) {
            System.out.println("Player: " + player.getName() + "age: " + player.getAge() + " score " + player.getScore());
        }
    }

    public double calcAverageAge() {
        double average = 0;
        for(Player player : players) {
            average += player.getAge();
        }
        average = average / players.size();
        return average;
    }

    public int calcTotalScore() {
        int score = 0;
        for(Player player : players) {
            score += player.getScore();
        }
        return  score;
    }

    public int calcOldPlayerScore(int ageLimit) {
        int score = 0;
        for(Player player : players) {
            if (player.getAge() > ageLimit) {
                score += player.getScore();
            }
        }
        return  score;
    }

    public int maxScore() {
        int maxScore = 0;
        for(Player player : players) {
            if (player.getScore() > maxScore) {
                maxScore = player.getScore();
            }
        }
        return maxScore;
    }

    public ArrayList<String> bestPlayerNames() {
        ArrayList<String> bestPlayers = new ArrayList<>();
        int max = maxScore();
        for(Player player : players) {
            if (player.getScore() == max) {
                bestPlayers.add(player.getName());
            }
        }
        return bestPlayers;
    }




    @Override
    public String toString() {
        return "Team(" + name + ")";
    }
    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
