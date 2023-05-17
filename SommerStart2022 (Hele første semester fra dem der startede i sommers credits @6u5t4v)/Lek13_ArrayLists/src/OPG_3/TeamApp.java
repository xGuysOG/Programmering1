package OPG_3;

import java.util.Random;

public class TeamApp {

    static Random random = new Random();

    public static void main(String[] args) {
        Team team = new Team("Datamatiker");
        Player p1 = new Player("Kaj", random.nextInt(18, 26));
        Player p2 = new Player("Andrea", random.nextInt(18, 26));
        Player p3 = new Player("Per", random.nextInt(18, 26));
        Player p4 = new Player("Egon", random.nextInt(18, 26));

        team.addPlayer(p1);
        team.addPlayer(p2);
        team.addPlayer(p3);
        team.addPlayer(p4);

        p1.setScore(random.nextInt(2, 10));
        p2.setScore(random.nextInt(2, 10));
        p3.setScore(random.nextInt(2, 10));
        p4.setScore(random.nextInt(2, 10));

        team.printPlayers();

        System.out.println();

        System.out.println("Gennemsnitlige alder: " + team.calcAverageAge());
        System.out.println("Total score: " + team.calcTotalScore());
        System.out.println("Alder total score (> 18): " + team.calcOldPlayersScore(18));
        System.out.println("Bedste score: " + team.maxScore());
        System.out.println("Bedste spiller: " + team.bestPlayer());

    }
}
