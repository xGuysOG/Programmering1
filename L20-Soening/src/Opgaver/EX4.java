package Opgaver;

import java.util.ArrayList;

public class EX4 {

//    Exercise 4
//    In this exercise you must use a Player class. Make a player class with the following fields:
//    name, height, weight, scoredGoals. The class must have a constructor that initializes all the
//            fields, and get methods for all four fields (and a toString() method).
//    In the test class make an ArrayList of Player with about 6-8 Players.
//            a) Write a linear search method that returns a player with a given number of scored goals
//    found in an ArrayList of players given as parameter. Return null, if no such player is found.
//            page 1 of 3
//    Datamatiker 23Y PRO1
//    MLCH
//    The header of the method:
//    public Player findPlayerLinear(ArrayList<Player> players, int score)
//    b) Write a binary search method that returns a player with a given number of scored goals
//    found in a sorted ArrayList of players (sorted in descending order according to scored goals)
//    given as parameter. Return null, if no such player is found.
//    The header of the method:
//    public Player findPlayerBinary(ArrayList<Player> players, int score)
//    c) Write a linear search method that returns the name of a player with a height less than 170
//    cm and with more than 50 scored goals in a given ArrayList of players. Return the empty
//    string, if no player is found.
//    The header of the method:
//    public String findPlayerName(ArrayList<Player> players)
public static void main(String[] args) {
    ArrayList<Player> players = new ArrayList<>();
    players.add(new Player("Player1", 180, 70, 30));
    players.add(new Player("Player2", 175, 75, 40));
    players.add(new Player("Player3", 165, 65, 50));
    players.add(new Player("Player4", 190, 80, 60));
    players.add(new Player("Player5", 160, 60, 70));
    players.add(new Player("Player6", 170, 70, 80));

    // Linear Search
    int searchScore1 = 60;
    Player linearResult = findPlayerLinear(players, searchScore1);
    if (linearResult != null) {
        System.out.println("Linear Search: Player with " + searchScore1 + " scored goals found: " + linearResult);
    } else {
        System.out.println("Linear Search: Player with " + searchScore1 + " scored goals not found.");
    }

    // Binary Search
    players.sort((p1, p2) -> Integer.compare(p2.getScoredGoals(), p1.getScoredGoals()));
    int searchScore2 = 70;
    Player binaryResult = findPlayerBinary(players, searchScore2);
    if (binaryResult != null) {
        System.out.println("Binary Search: Player with " + searchScore2 + " scored goals found: " + binaryResult);
    } else {
        System.out.println("Binary Search: Player with " + searchScore2 + " scored goals not found.");
    }

    // Linear Search by Height and Scored Goals
    String playerName = findPlayerName(players);
    if (!playerName.isEmpty()) {
        System.out.println("Player with height < 170cm and more than 50 scored goals: " + playerName);
    } else {
        System.out.println("No player found with height < 170cm and more than 50 scored goals.");
    }
}

    public static Player findPlayerLinear(ArrayList<Player> players, int score) {
        for (Player player : players) {
            if (player.getScoredGoals() == score) {
                return player;
            }
        }
        return null;
    }

    public static Player findPlayerBinary(ArrayList<Player> players, int score) {
        int left = 0;
        int right = players.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Player midPlayer = players.get(mid);

            if (midPlayer.getScoredGoals() == score) {
                return midPlayer;
            } else if (midPlayer.getScoredGoals() > score) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    public static String findPlayerName(ArrayList<Player> players) {
        for (Player player : players) {
            if (player.getHeight() < 170 && player.getScoredGoals() > 50) {
                return player.getName();
            }
        }
        return "";
    }

}
