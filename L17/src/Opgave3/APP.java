package Opgave3;

public class APP {
    public static void main(String[] args) {
        Team teamA = new Team("TeamA");
        Team teamB = new Team("TeamB");

        Player player1A = new Player("Lars", 10);
        Player player2A = new Player("Lars1", 15);
        Player player3A = new Player("Lars2", 12);
        Player player4A = new Player("Lars3", 11);
        player1A.setScore(10);
        player2A.setScore(20);
        player3A.setScore(20);
        player4A.setScore(5);
        teamA.addPlayer(player1A);
        teamA.addPlayer(player2A);
        teamA.addPlayer(player3A);
        teamA.addPlayer(player4A);


        Player player1B = new Player("Lars", 10);
        Player player2B = new Player("Lars1", 15);
        Player player3B = new Player("Lars2", 12);
        Player player4B = new Player("Lars3", 11);
        player1B.setScore(10);
        player2B.setScore(-1);
        player3B.setScore(-1);
        player4B.setScore(5);
        teamB.addPlayer(player1B);
        teamB.addPlayer(player2B);
        teamB.addPlayer(player3B);
        teamB.addPlayer(player4B);


        teamA.printPlayers();

        System.out.println("TeamA Average" + teamA.calcAverageAge());
        System.out.println("TeamB Average" + teamB.calcAverageAge());

        System.out.println("Team A totalScore " + teamA.calcTotalScore());
        System.out.println("Team B totalScore " + teamB.calcTotalScore());

        System.out.println("Team a calcOldPlayerScore " + teamA.calcOldPlayerScore(11));
        System.out.println("Team B calcOldPlayerScore " + teamB.calcOldPlayerScore(11));

        System.out.println("Team A max " + teamA.maxScore());
        System.out.println("Team B max " + teamB.maxScore());

        System.out.println("Team a bestPlayer " + teamA.bestPlayerNames());
        System.out.println("Team B bestPlayer " + teamB.bestPlayerNames());

    }
}
