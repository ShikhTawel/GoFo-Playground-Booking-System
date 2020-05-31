package src.Users;
import java.util.ArrayList;

public class Team {
    private String teamName;
    private String ownerUsername;
    private ArrayList<Player> players;
    private static int cnt = 0;

    public Team(String name, String username) {
        teamName = name;
        ownerUsername = username;
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
        for (int i = 0; i < players.size(); i++) {
            deletePlayer(players.get(0));
        }
    }

    @Override
    public String toString() {
        String res =
                "Team name: " + teamName
                + "\nUsername of the Owner Player: " + ownerUsername
                + "\nOther Players: \n";
        for (Player player: players) {
            res += "- ";
            res += player.getUsername() + "\n";
        }
        return res;
    }

    public void sendInvitations() {
        for (Player player: players) {
            if (!player.getUsername().equalsIgnoreCase(ownerUsername)) {
                System.out.println("Invitation sent to: " + player.getEmail());
            }
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
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