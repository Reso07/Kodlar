package JavaCourse;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        BasketballPlayer Lebron = new BasketballPlayer("Lebron James"),
                Kyre = new BasketballPlayer("Kyre Irving");
        BasketballPlayer Kevin = new BasketballPlayer("Kevin Love");
        Team<BasketballPlayer> Cleveland = new Team<>("Cleveland Cavaliers");
        Cleveland.addPlayer(Lebron); Cleveland.addPlayer(Kyre); Cleveland.addPlayer(Kevin);
        Team<BasketballPlayer> GSW = new Team<>("Golden State Warriors");
        Team<BasketballPlayer> Oklahoma = new Team<>("Oklahoma Thunders");
        GSW.addPlayer(new BasketballPlayer("Stephen Curry"));
        GSW.addPlayer(new BasketballPlayer("Draymond Green"));
        Oklahoma.addPlayer(new BasketballPlayer("Kevin Durant"));
        Oklahoma.addPlayer(new BasketballPlayer("Russel Westbrook"));
        Team<FootballPlayer> Barca = new Team<>("Barcelona F.C.");
        League<Team<BasketballPlayer>> NBA = new League<>("National Basketball Association");
        NBA.addTeam(Oklahoma);
        NBA.addTeam(GSW);
        NBA.addTeam(Cleveland);
        Cleveland.match(GSW,106,103);
        GSW.match(Oklahoma,98,91);
        Oklahoma.match(Cleveland,103,94);
        Cleveland.match(Oklahoma,114,102);
        Cleveland.match(Oklahoma,99,99);
        GSW.match(Cleveland,111,97);
        NBA.print();
    }

    // Create a generic class to implement a league table for a sport.
    // The class should allow teams to be added to the list, and store
    // a list of teams that belong to the league.
    //
    // Your class should have a method to print out the teams in order,
    // with the team at the top of the league printed first.
    //
    // Only teams of the same type should be added to any particular
    // instance of the league class - the program should fail to compile
    // if an attempt is made to add an incompatible team.
}
