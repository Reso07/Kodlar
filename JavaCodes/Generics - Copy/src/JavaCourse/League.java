package JavaCourse;

import java.util.ArrayList;
import java.util.Collections;

public class League<T extends Team> {
    private String leagueName;
    private ArrayList<T> teams = new ArrayList<>();

    public League(String leagueName){ this.leagueName = leagueName; }

    public void addTeam(T team) {
        if(teams.contains(team)) {
            System.out.println("This team is already on the league.");
        } else {
            teams.add(team);
        }
    }

    public void removeTeam(T team) {
        if(teams.contains(team)) {
            teams.remove(team);
            System.out.println(team.getTeamName() + " is eliminated from the league.");
        } else {
            System.out.println(team.getTeamName()+" is not on this league.");
        }
    }

    public void print() {
        Collections.sort(teams);
        for(T t: teams) {
            System.out.println("#"+(teams.indexOf(t)+1)+" - " + t.getTeamName() + " : "+t.ranking());
        }
    }
}
