package JavaCourse;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    private String teamName;
    private ArrayList<T> players = new ArrayList<>();
    int played = 0, won = 0, lost = 0, tied = 0;

    public Team(String teamName) { this.teamName = teamName; }

    public void addPlayer(T player) {
        if(players.contains(player)) {
            System.out.println(player.getName() +" is already on the team.");
        } else {
            players.add(player);
        }
    }

    public void removePlayer(T player) {
        if(players.contains(player)) players.remove(player);
        else System.out.println(player.getName() + " doesn't exist.");
    }

    public int numberOfPlayers() {
        return players.size();
    }

    public void match(Team<T> opponent, int ourPoints, int theirPoints) {
        String message;
        if(ourPoints > theirPoints) {
            won++;
            message = " beat ";
        } else if(ourPoints == theirPoints) {
            tied++;
            message = " tied with ";
        } else {
            lost++;
            message = " lost to ";
        }
        played++;
        if(opponent != null) {
            System.out.println(teamName + message + opponent.teamName);
            opponent.match(null, theirPoints,ourPoints);
        }
    }

    public int ranking() { return won*3+tied;}

    public String getTeamName() { return teamName; }

    @Override
    public int compareTo(Team<T> o) {
        if(ranking()>o.ranking()) {
            return -1;
        } else if(ranking()<o.ranking()) {
            return 1;
        }
        return 0;
    }
}
