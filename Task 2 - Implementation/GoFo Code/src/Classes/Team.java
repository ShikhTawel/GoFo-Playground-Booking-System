package Classes;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private int teamID;
    private int teamCount;
    private String ownerUsername;
    private ArrayList<Player> players;

    public Team(){
        teamName="Team";
        teamID=1;
        teamCount=0;
        players=new ArrayList<>();
    }
}