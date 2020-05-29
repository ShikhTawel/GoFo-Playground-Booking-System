package Classes;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private int teamCount;
    private String ownerUsername;
    private ArrayList<Player> players;
    private static int cnt = 0;

    public Team(String name, String username) {
        teamName = name;
        ownerUsername = username;
        teamCount=0;
        players=new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.getTeamsEnrolled().add(this);
    }

    public void deletePlayer(Player player) {
        players.remove(player);
        player.getTeamsEnrolled().remove(this);
    }

    public void clearTeam() {
        players.clear();
    }

    @Override
    public String toString() {
        String res =
                "Team name: " + teamName
                + "\nNumber of players: " + teamCount
                + "\nUsername of the Owner Player: " + ownerUsername
                + "\nOther Players: \n";
        for (Player player: players) {
            res += "- ";
            res += player.getUsername() + "\n";
        }
        return res;
    }

    public void sendInvitations() {
        // send Email invitations
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
}